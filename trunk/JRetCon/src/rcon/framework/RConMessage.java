package rcon.framework;
import java.util.List;


public class RConMessage {
	private List<String> words;
	
	public RConMessage(List<String> words) {
		this.words = words;
	}
	
	public List<String> getWords() {
		return words;
	}
}
