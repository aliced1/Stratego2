package com.stratego.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class StrategoGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private OrthographicCamera camera;
	Sprite gridSquare;
	Sprite gridLake;
	private int squaresOnWidth;
	private int squaresOnHeight;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("red.png");
		gridSquare = new Sprite(new Texture("white.png"));
		gridLake = new Sprite(new Texture("black.png"));

//		Gdx.graphics.setWindowedMode(800, 800);

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera(w, h);

		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();

		squaresOnWidth = 10;
		squaresOnHeight = 10;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		float squareWidth = camera.viewportWidth / squaresOnWidth;
		float squareHeight = camera.viewportHeight / squaresOnHeight;
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
		batch.end();




	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
