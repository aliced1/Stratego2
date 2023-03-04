package util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.HashMap;
import java.util.Map;

public class Piece extends Actor {

    private static final HashMap<String, Integer> strengths = new HashMap<>(Map.of("Marshal", 10, "General", 9,
            "Colonel", 8, "Major", 7, "Captain", 6, "Lieutenant", 5, "Sergeant", 4,
            "Miner", 3, "Scout", 2, "Spy", 0));
    static {
        strengths.put("   ", 0);
        strengths.put("BOM", 0);
        strengths.put("FLA", 0);
    }

    //TODO store available move lengths to display possible moves?
    private final String rank;

    // Sprite instance variables
    private Texture image;

    public Piece (String r, String texturePath) {
		if (!strengths.containsKey(r) || texturePath == null) throw new IllegalArgumentException();
        setTexture(new Texture(texturePath));
        rank = r;
    }

    public Integer getStrength() {
        return Piece.strengths.get(rank);
    }

    @Override
    public String toString () {
        return rank.substring(0, 3);
    }

    public Piece battle(Piece opponent) {
        if (getStrength() > opponent.getStrength()) return this;
        else if (getStrength() < opponent.getStrength()) return opponent;
        else return new Piece("   ", "white.png");
    }



    // Sprite methods
    public void setTexture (Texture t) {
        image = t;
    }

    public Texture getTexture () {
        return image;
    }

    public void draw(Batch b) {
        b.draw(getTexture(), getX(), getY());
    }







}

