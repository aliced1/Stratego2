package util;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class BoardSquare extends Actor {

    // Sprite instance variables
    private final Sprite s;

    public BoardSquare (String texturePath) {
        s = new Sprite(new Texture(texturePath));
    }

    // Sprite methods
    public void setSize (float x, float y) {
        s.setSize(x, y);
    }

    public void setPosition (float x, float y) {
        s.setPosition(x, y);
    }

    @Override
    public void draw(Batch b, float parentAlpha) {
        s.draw(b);
    }

    public void act() {
    }
}
