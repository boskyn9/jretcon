package rcon.framework;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class RCon {
	private Socket s;
	private int seq;
	private OutputStream out;
	private InputStream in;

	public RCon(String host, int port) throws UnknownHostException, IOException {
		s = new Socket(host, port);
		seq = 1;
		out = new BufferedOutputStream(s.getOutputStream());
		in = s.getInputStream();

		// If we dont' receive any data for 20 minutes timeout.
		// Might need to restart the connection for some reason.
		s.setSoTimeout(20 * 60 * 1000);
	}

	public InputStream getIn() {
		return in;
	}

	public void disconnect() throws IOException {
		out.close();
		in.close();
		s.close();
	}

	static byte[] buildWord(String str) {
		char[] chars = str.toCharArray();
		ByteBuffer buff = ByteBuffer.allocate(4 + chars.length + 1).putInt(
				Integer.reverseBytes(chars.length));
		for (char c : chars) {
			buff.put(ByteBuffer.allocate(1).put(("" + c).getBytes()).array());
		}
		buff.put((byte) 0x00);
		return buff.array();
	}

	static List<String> fromWord(List<Byte> bytes) {
		// int wordCount = toInt(bytes.subList(0, 3));

		List<String> words = new ArrayList<String>();

		StringBuffer word = new StringBuffer();
		for (int i = 4; i < bytes.size(); i++) {
			// Spacer
			if (bytes.get(i) == (byte) 0x00) {
				String s = word.toString();
				if (s.trim().length() > 0)
					words.add(word.toString());
				word = new StringBuffer();
			} else {
				word.append(((char) (byte) bytes.get(i)));
			}
		}

		return words;
	}

	static byte[] buildInt(int i) {
		return ByteBuffer.allocate(4).putInt(Integer.reverseBytes(i)).array();
	}

	static int toInt(List<Byte> list) {
		Collections.reverse(list);
		String val = "";
		for (byte a : list) {
			val += String.format("%02x", a);
		}
		return Integer.parseInt(val, 16);
	}
	
	public void movePlayer(String username, int teamId, int squadId, boolean force) {
		if (force) {
			try {
				send("admin.movePlayer", username, "" + teamId, "" + squadId, "" + force);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			AfterDeathMove.add(username, teamId);
		}
	}

	public synchronized RConSeqAck send(String... cmd) throws IOException {
		RConSeqAck seqAck = new RConSeqAck(this.seq);
		RConEventSink.addAck(seqAck);
		
		int packetSize = 0;

		byte[] seq = buildInt(this.seq);
		packetSize += seq.length;

		byte[] wc = buildInt(cmd.length);
		packetSize += wc.length;

		Vector v = new Vector();
		for (String s : cmd) {
			byte[] word = buildWord(s);
			packetSize += word.length;
			v.add(word);
		}

		byte[] size = buildInt(packetSize + 4);

		out.write(seq);
		out.write(size);
		out.write(wc);
		for (int i = 0; i < v.size(); i++)
			out.write((byte[]) v.get(i));
		out.flush();
		
		this.seq++;
		return seqAck;
	}

	public static void main(String args[]) throws Exception {
		final String hostname = JOptionPane.showInputDialog("Host");
		final String port = JOptionPane.showInputDialog("Port");
		final String password = JOptionPane.showInputDialog("PassWord");

		List<String> receivers = new ArrayList<String>();
		
                receivers.add("rcon.framework.AfterDeathMove");

		// Store the number of attempts so that we can back off on our connection retries.
		int connAttempts = 0;
		
		
		RConConsole rConsole = null;
		
		while (true) {
			try {
				System.out.println("Connecting to RCon");
				connAttempts++;
				RCon rCon = new RCon(hostname, Integer.valueOf(port));
				System.out.println("Connected");
				
				System.out.println("Starting Console");
				if (rConsole == null) {
					rConsole = new RConConsole(rCon);
					rConsole.setDaemon(true);
					rConsole.start();
				} else {
					rConsole.setRCon(rCon);
				}
				System.out.println("Started");
				
				connAttempts = 0;
				try {
					System.out.println("Starting event monitor");

					RConRecv[] recv = new RConRecv[receivers.size()];
					for (int i = 0; i < recv.length; i++) {
						recv[i] = (RConRecv) Class.forName(receivers.get(i))
							.getConstructor(RCon.class).newInstance(rCon);
						System.out.println("Loaded " + receivers.get(i));
					}

					RConEventSink eventSink = new RConEventSink(rCon, recv);
					eventSink.setDaemon(true);
					eventSink.start();
					System.out.println("Started");

                                        
                                        
                                        
					System.out.println("Authenticating");
					for (String retorno : rCon.send("login.plainText", password).waitForResp())
						if (retorno.equals("OK"))
							System.out.println("Authentication completed");

					System.out.println("Enabling events");
					for (String s : rCon.send("admin.eventsEnabled", "true").waitForResp())
						if (s.equals("OK"))
							System.out.println("Events enabled");
                                        
                                        
					System.out.println("Startup complete");
                                        
                                        
                                        
                                        
					eventSink.join();
                                        
				} finally {
					rCon.send("logout").waitForResp();
					rCon.disconnect();
				}
			} catch (Exception e) {
				if (!rConsole.running.get())
					System.exit(0);
				
				e.printStackTrace();
				int retryTime = 30;
				for (int i = 0; i < Math.min(6, connAttempts); i++)
					retryTime = retryTime* 2;
				
				System.err.println("Error: Retry in " + retryTime + " sec.");
				Thread.currentThread().sleep(retryTime * 1000);
			}
		}
	}
}
