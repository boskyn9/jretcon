package rcon.framework.balancer;

import java.io.IOException;

import rcon.framework.RCon;
import rcon.framework.RConRecv;
import rcon.framework.dto.PlayerInfo;
import rcon.framework.dto.TeamScores;

/**
 * Store enough information received from server events to determine when to
 * balance and which players need to be moved to balance the server.
 * 
 * @author mattconroy
 */
public class Balancer extends RConRecv {
	private final PlayerStats statTracker;
	private PlayerInfo lastRound = null;
	private TeamScores scores = null;
	
	public Balancer(RCon rcon) {
		super(rcon);
		statTracker = new PlayerStats();
	}

	@Override
	public void onKill(String killer, String killed, String weapon, boolean headshot) {
		statTracker.addKill(killer);
		statTracker.addDeath(killed);
	}
	
	@Override
	public void onServerLevelLoaded(final String mapName, final String mode, final int played,
			final int total) {
		final Balancer b = this;
		if (played < total && mode.toLowerCase().contains("conquest")) {
			Thread t = new Thread() {
				public void run() {
					try {
						// Some machines load slower than others... 
						Thread.currentThread().sleep(10 * 1000);
						
						// Populate the Balancer with the current player list.
						PlayerInfo players = new PlayerInfo(rcon.send("admin.listPlayers").waitForResp());

						b.balance(players);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
		}
	}

	@Override
	public void onServerRoundOverPlayers(PlayerInfo players) {
		lastRound = players;
	}

	
	private void balance(PlayerInfo players) {
		if (lastRound == null || scores == null) {
			System.out.println("No lastRound or received scores available");
			return;
		}
		
		System.out.println("Target score: " + scores.getTargetScore());
		for (String s : scores.getTeamScores())
			System.out.println(s);

		System.out.println("Last Round Players:");
		System.out.println(lastRound);
		
		System.out.println("Current Players");
		System.out.println(players);
		
		
	}
	
	@Override
	public void onServerRoundOver(int teamId) {
		System.out.println("Winning Team: " + teamId);
	}
	
	
	@Override
	public void onServerRoundOverTeamScores(TeamScores scores) {
		this.scores = scores;
	}
}
