package rcon.framework.balancer;

import java.util.HashMap;
import java.util.Map;

import rcon.framework.dto.Player;

/**
 * A class to collect player stats.
 * @author mattconroy
 */
public class PlayerStats {
	private Map<String, Player> stats = 
		new HashMap<String, Player>();
	
	private Player getPlayer(String username) {
		synchronized (stats) {
			Player p = stats.get(username);
			if (p == null) {
				p = new Player(username);
				stats.put(username, p);
			}
			return p;
		}
	}
	
	public void addKill(String username) {
		synchronized(stats) {
			getPlayer(username).addKill();
		}
	}
	
	public void addDeath(String username) {
		synchronized(stats) {
			getPlayer(username).addDeath();
		}
	}
	
	public void roundComplete(String username) {
		synchronized(stats) {
			//getPlayer(username).addRound();
		}
	}
}
