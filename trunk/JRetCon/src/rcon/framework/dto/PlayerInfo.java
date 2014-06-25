package rcon.framework.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerInfo {
	private int paramCount;
	private int playerCount;
	private List<String> fieldNames = new ArrayList<String>();
	private List<Map<String, String>> players = 
		new ArrayList<Map<String, String>>();
	
	public PlayerInfo(List<String> words) {
		paramCount = Integer.parseInt(words.get(1)) ;
		
		// Determine which field names are given.
		List<String> tempFieldNames = new ArrayList<String>();
		for (int i = 2; i < paramCount + 2; i++) {
			System.out.println(words.get(i));
			tempFieldNames.add(words.get(i));
		}
		
		// Append an extra field that RCon sends us...
		for (String s : tempFieldNames) { 
			if (s.equalsIgnoreCase("guid"))
				fieldNames.add("#");
			fieldNames.add(s);
		}
		
		// Player count comes after the parameters. 
		paramCount = fieldNames.size();
		playerCount = Integer.parseInt(words.get(paramCount + 1));
		
		
		for (int i = paramCount + 2; i < words.size(); i = i + paramCount) {
			System.out.println(i);
			Map<String, String> player = new HashMap<String, String>();
			for (int j = 0; j < fieldNames.size(); j++) {
				System.out.println(j + " " + words.get(i+j));
				player.put(fieldNames.get(j), words.get(i + j));
			}
			players.add(player);
		}
	}

	public int getParamCount() {
		return paramCount;
	}

	public void setParamCount(int paramCount) {
		this.paramCount = paramCount;
	}

	public int getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public void setFieldNames(List<String> fieldNames) {
		this.fieldNames = fieldNames;
	}

	@Override
	public String toString() {
		return "PlayerInfo [paramCount=" + paramCount + ", playerCount="
				+ playerCount + ", fieldNames=" + fieldNames + ", players="
				+ players + "]";
	}
	
	
}
