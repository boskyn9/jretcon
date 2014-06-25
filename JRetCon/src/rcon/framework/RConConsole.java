package rcon.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicBoolean;

import rcon.framework.dto.PlayerInfo;

public class RConConsole extends Thread {
	AtomicBoolean running = new AtomicBoolean(false);
	
	private RCon r;
	
	public RConConsole(RCon r) {
		this.r = r;
	}

	public void run() {
		running.set(true);
		
		String input = "";
		while (running.get()) {
			System.out.print("=> ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (input.startsWith("!")) {
				try {
					String cmd = input.replace("!", "");
					String params[] = cmd.split(" ");
					for (String p : params)
						System.out.println("Param: " + p);

					if (cmd.contains("listPlayers")) {
						PlayerInfo p;
						try {
							p = new PlayerInfo(r.send(params).waitForResp());
							System.out.println(p);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("Exec: " + cmd);
						try {
							for (String str : r.send(params).waitForResp())
								System.out.println("CR: " + str);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					System.out.println();
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
			}
			
			if (input.contains("quit")) {
				try {
					r.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
				running.set(false);
			}
		}
	}
	
	public void setRCon(RCon r) {
		this.r = r;
	}
}
