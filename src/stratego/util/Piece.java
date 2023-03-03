package stratego.util;

import java.util.HashMap;
import java.util.Map;

public class Piece {
	
	private static final HashMap<String, Integer> strengths = new HashMap<>(Map.of("Marshal", 10, "General", 9,
			"Colonel", 8, "Major", 7, "Captain", 6, "Lieutenant", 5, "Seregant", 4, 
			"Miner", 3, "Scout", 2, "Spy", 0));
	static {
		strengths.put("   ", 0);
		strengths.put("BOM", 0);
		strengths.put("FLA", 0);
	}
	
	
	private String rank;
	//TODO store available move lengths to display possible moves?

	
	public Piece (String r) {
//		if (!strengths.containsKey(r)) throw new IllegalArgumentException();
		this.rank = r;
	}

	
	
	public Integer getStrength() {
		return Piece.strengths.get(this.rank);
	}

	@Override
	public String toString () {
		return this.rank.substring(0, 3);
	}
	
	public Piece battle(Piece opponent) {
		if (this.getStrength() > opponent.getStrength()) return this;
		else if (this.getStrength() < opponent.getStrength()) return opponent;
		else return new Piece("   ");
	}
	

	
	
}
