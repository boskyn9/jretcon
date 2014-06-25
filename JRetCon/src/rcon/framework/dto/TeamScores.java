package rcon.framework.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamScores {
	private int paramCount;
	private List<String> teamScores = new ArrayList<String>();
	private int targetScore;

	public TeamScores(List<String> words) {
		paramCount = Integer.parseInt(words.get(1));

		for (int i = 2; i < paramCount + 2; i++) {
			System.out.println(words.get(i));
			teamScores.add(words.get(i));
		}

		targetScore = Integer.parseInt(words.get(words.size()));
	}

	public int getParamCount() {
		return paramCount;
	}

	public void setParamCount(int paramCount) {
		this.paramCount = paramCount;
	}

	public List<String> getTeamScores() {
		return teamScores;
	}

	public void setTeamScores(List<String> teamScores) {
		this.teamScores = teamScores;
	}

	public int getTargetScore() {
		return targetScore;
	}

	public void setTargetScore(int targetScore) {
		this.targetScore = targetScore;
	}

	@Override
	public String toString() {
		return "TeamScores [paramCount=" + paramCount + ", teamScores="
				+ teamScores + ", targetScore=" + targetScore + "]";
	}
}
