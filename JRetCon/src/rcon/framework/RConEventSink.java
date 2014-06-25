package rcon.framework;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Monitors the input stream from RCon and proxies those messages to handlers.
 * @author mattconroy
 */
public class RConEventSink extends Thread {
	private RCon rcon;
	private InputStream in;
	private RConRecv[] recv;
	private AtomicBoolean running = new AtomicBoolean(true);
	private static Map<Integer, RConSeqAck> requestAcks = 
		new ConcurrentHashMap<Integer, RConSeqAck>();

	public RConEventSink(RCon r, RConRecv... recv) {
		this.rcon = r;
		this.in = r.getIn();
		this.recv = recv;
	}

	public static void addAck(RConSeqAck ack) {
		requestAcks.put(ack.getSeq(), ack);
	}
	
	public void run() {
		while (running.get()) {
			try {
				// Storage for the received message.
				List<Byte> list = new ArrayList<Byte>();
				
				// Init to the maximum size of a packet from RCon.
				int streamLength = 16384;
				
				// Read the stream.
				int b;
				while (streamLength > 0 && (b = in.read()) != -1) {
					// Store this byte and continue.
					list.add((byte) b);

					// Make sure we read until we are done.
					if (streamLength == 16384) {
						// If we have read enough packet information to view the
						// total packet size field we can adjust the streamLength
						// accordingly.
						if (list.size() > 8)
							streamLength = RCon.toInt(list.subList(4, 8)) - 9;
					} else {
						// A byte was read decrease the read length
						streamLength--;
					}
				}

				// In some cases we will receive garbage packets.. If 
				// we didn't receive enough information we can just ignore it.
				if (list.size() > 8) {
					// Convert the response to a list of strings.
					List<String> words = RCon.fromWord(list.subList(9,
							list.size()));

					// Call each message receiver with the received response.
					for (RConRecv r : recv) {
						// Catch Throwable to avoid RConRecv handlers killing the 
						// process.
						try {
							r.message(new RConMessage(words));
						} catch (Throwable e) {
							System.out.println("Exception in recevier: " + e.getMessage());
						}
					}
					
					int seq = rcon.toInt(list.subList(0, 3));
					RConSeqAck ack = requestAcks.remove(seq);
					if (ack != null)
						ack.done(words);
				}
			} catch (SocketTimeoutException e) {
				shutdown();
				System.err.println(e.getMessage());
			} catch (IOException e) {
				shutdown();
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void shutdown() {
		running.set(false);
	}
	
	public boolean isRunning() {
		return running.get();
	}
}
