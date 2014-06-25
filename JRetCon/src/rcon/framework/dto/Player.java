package rcon.framework.dto;


/**
 * Used to store per player stats.
 * @author mattconroy
 *
 */
public class Player {
	private String name;
	private int kills;
	private int deaths;
	private int teamId;
	private int squadId;
	private String guid;
	
	public Player(String name) {
		this.name = name;
		kills = 0;
		deaths = 0;
	}
	
	public void addKill() {
		kills++;
	}
	
	public void addDeath() {
		deaths++;
	}
}
