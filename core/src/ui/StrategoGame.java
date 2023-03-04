package ui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class StrategoGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
//	private OrthographicCamera camera;
	private Sprite gridSquare;
	private Sprite gridLake;
	private int squaresOnWidth;
	private int squaresOnHeight;
	private float width;
	private float height;

	private Sprite cursor;


	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("red.png");
		gridSquare = new Sprite(new Texture("white.png"));
		gridLake = new Sprite(new Texture("black.png"));

		cursor = new Sprite(new Texture("Spy.png"));
		cursor.setScale(0.1f);
		cursor.setPosition(0, 0);

//		Gdx.graphics.setWindowedMode(800, 800);

		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();

//		camera = new OrthographicCamera(w, h);

//		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
//		camera.update();

		squaresOnWidth = 10;
		squaresOnHeight = 10;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		// move cursor according to input
		int movementScale = 10;
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) cursor.translateX(-movementScale);
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) cursor.translateX(movementScale);
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) cursor.translateY(-movementScale);
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) cursor.translateY(movementScale);

		Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		float squareWidth = camera.viewportWidth / squaresOnWidth;
//		float squareHeight = camera.viewportHeight / squaresOnHeight;
		float squareWidth = width / squaresOnWidth;
		float squareHeight = height / squaresOnHeight;
		gridSquare.setSize(squareWidth, squareHeight);
		gridLake.setSize(squareWidth, squareHeight);

		batch.begin();
//		batch.draw(img, 10, 20);
		for(int y = 0; y < squaresOnHeight; y++){
			for(int x = 0; x < squaresOnWidth; x++){
				if ((y == 4 || y == 5) && (x == 2 || x == 3 || x == 6 || x == 7)) {
					gridLake.setX(x * squareWidth);
					gridLake.setY(y * squareHeight);
					gridLake.draw(batch);
					continue;
				}
				gridSquare.setX(x * squareWidth);
				gridSquare.setY(y * squareHeight);
				gridSquare.draw(batch);
			}
		}

		cursor.draw(batch);

		batch.end();




	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
