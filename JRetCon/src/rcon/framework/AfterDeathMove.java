package rcon.framework;

import java.util.HashMap;
import java.util.Map;

public class AfterDeathMove extends RConRecv {
	private static Map<String, Integer> playersToMove = new HashMap<String, Integer>();
	
	public AfterDeathMove(RCon rcon) {
		super(rcon);
	}
	
	@Override
	public void onKill(String killer, String killed, String weapon,
			boolean headShot) {
		
		synchronized (playersToMove) {
			Integer p = playersToMove.get(killed);
			if (p != null)
				rcon.movePlayer(killed, p, 0, true);
		}
	}
	
	public static void add(String username, int newTeamId) { 
		synchronized (playersToMove) {
			playersToMove.put(username, newTeamId);
		}
	}
}
