package rcon.framework;

import java.util.List;

import rcon.framework.dto.PlayerInfo;
import rcon.framework.dto.TeamScores;


public class RConRecv {
	protected RCon rcon;
	
	// Allows access to send messages back to the server.
	public RConRecv(RCon rcon) {
		this.rcon = rcon;
	}

	public void message(RConMessage msg) {
		List<String> words = msg.getWords();
		String cmd = msg.getWords().get(0);
		if (cmd.contains("player.onTeamChange")) {
			String username = words.get(1);
			String team = words.get(2);
			String squad = words.get(3);
			onTeamChange(username, Integer.parseInt(team), Integer.parseInt(squad));
			onSquadOrTeamChange(username, Integer.parseInt(team), Integer.parseInt(squad));
		} else if (cmd.contains("player.onSquadChange")) {
			String username = words.get(1);
			String team = words.get(2);
			String squad = words.get(3);
			onSquadChange(username, Integer.parseInt(team), Integer.parseInt(squad));
			onSquadOrTeamChange(username, Integer.parseInt(team), Integer.parseInt(squad));
		} else if (cmd.contains("player.onJoin")) {
			String username = words.get(1);
			String guid = words.get(2);
			onJoin(username, guid);
		} else if (cmd.contains("player.onLeave")) {
			String username = words.get(1);
			onLeave(username);
		} else if (cmd.contains("player.onSpawn")) {
			String username = words.get(1);
			int teamId = Integer.parseInt(words.get(2));
			onSpawn(username, teamId);
		} else if (cmd.contains("player.onKill")) {
			String killer = words.get(1);
			String killed = words.get(2);
			String weapon = words.get(3);
			
			// headshot isn't sent for every kill.
			boolean headshot = false; 
			if (words.size() > 4)
				headshot = Boolean.parseBoolean(words.get(4));
			
			onKill(killer, killed, weapon, headshot);
		} else if (cmd.contains("player.onChat")) {
			onChat(words);
		} else if (cmd.contains("server.onLevelLoaded")) {
			String levelName = words.get(1);
			String gameMode = words.get(2);
			int roundsPlayed = Integer.parseInt(words.get(3));
			int roundsTotal = Integer.parseInt(words.get(4));
			onServerLevelLoaded(levelName, gameMode, roundsPlayed, roundsTotal);
		} else if (cmd.contains("server.onRoundOver")) {
			int teamId = Integer.parseInt(words.get(1));
			onServerRoundOver(teamId);
		} else if (cmd.contains("server.onRoundOverPlayers")) {
			PlayerInfo players = new PlayerInfo(words);
			onServerRoundOverPlayers(players);
		} else if (cmd.contains("server.onRoundOverTeamScores")) {
			onServerRoundOverTeamScores(new TeamScores(words));
		}
	}
	
	public void onTeamChange(String username, int teamId, int squadId) {
		
	}
	
	public void onSquadChange(String username, int teamId, int squadId) {
		
	}
	
	public void onSquadOrTeamChange(String username, int teamId, int squadId) {
		
	}
	
	public void onJoin(String username, String guid) {
		
	}
	
	public void onLeave(String username) {
		/*
		player.onLeave::
		Seraph1ne::7::
		name::
		guid::
		teamId::
		squadId::
		kills::
		deaths::
		score::
		1::
		Seraph1ne::
		#::
		EA_576047A63CDDF7779AA1D81BD0FEFE36::
		1::
		1::
		1::
		4::
		100::
		 */
	}
	
	public void onSpawn(String username, int teamId) {
		
	}
	
	public void onKill(String killer, String killed, String weapon, boolean headShot) {
		
	}
	
	public void onChat(List<String> words) {
		
	}
	
	public void onServerLevelLoaded(String mapName, String mode, int played, int total) {
		
	}
	
	public void onServerRoundOver(int teamId) {
		
	}
	
	public void onServerRoundOverPlayers(PlayerInfo players) {
		
	}

	public void onServerRoundOverTeamScores(TeamScores scores) {
		
	}
	
	public void onAdminListPlayers(List<String> words) {
		
	}
}
