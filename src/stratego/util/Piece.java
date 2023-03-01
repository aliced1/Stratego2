package stratego.util;

import java.util.HashMap;
import java.util.Map;

public class Piece {
	
	HashMap<String, Integer> strengths = new HashMap<>(Map.of("Marshal", 10, "General", 9,
			"Colonel", 8, "Major", 7, "Captain", 6, "Lieutenant", 5, "Seregant", 4, 
			"Miner", 3, "Scout", 2, "Spy", 0));
	
	
	private String type;
	//TODO store available move lengths to display possible moves?

	
	
	public Piece (String type) throws Exception {
		
		if (!strengths.containsKey(type)) {
			throw new IllegalArgumentException();
		}
		
		this.type = type;
	}

	
	
	public Integer getStrength() {
		return this.strengths.get(this.type);
	}

	public String getType() {
		return type;
	}
	

	
	
}
