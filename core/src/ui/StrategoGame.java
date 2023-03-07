package ui;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.Gdx;
import data.Board;
import processor.Processor;
import util.BoardSquare;
import util.Piece;

import java.lang.Math;

public class StrategoGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private float squareWidth;
	private float squareHeight;
	public Stage mainStage;
	private Piece p;

	private Sprite cursor;



	@Override
	public void create () {
		// create objects for game mechanics
		try {
			Board b = Board.getInstance();
			processor.Processor p = new Processor(b);
			CLI userInterface = new CLI(b);
			userInterface.start();

		}
		catch (Exception e) {
			CLI.printException(e);
		}


		// initializations for grid layout
		int squaresOnWidth = 10;
		int squaresOnHeight = 10;

		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		squareWidth = width / squaresOnWidth;
		squareHeight = height / squaresOnHeight;

		// init batch, board, stage for actors
		batch = new SpriteBatch();

		Board b = Board.getInstance();
		mainStage = new Stage();


		// TESTING TODO -remove
		cursor = new Sprite(new Texture("Spy.png"));
		cursor.setPosition(0, 0); // bottom left corner coordinate




		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 10; i++) {

				if ((j == 4 || j == 5) &&
						(i == 2 || i == 3 || i == 6 || i == 7)) {
					BoardSquare gridLake = new BoardSquare("black.png");
					mainStage.addActor(gridLake);
					gridLake.setPosition(i * squareHeight, j * squareWidth);
					gridLake.setSize(squareWidth, squareHeight);
					gridLake.setZIndex(1);
					continue;
				}

				Piece p = b.getPieceAt(i, j);
				mainStage.addActor(p);
				p.setPosition(i * squareHeight, j * squareWidth);
				p.setSize(squareWidth, squareHeight);
				p.setZIndex(2);
//				System.out.println("Name = " + p.getName() + "     coordinates = " + p.getX() + ", " + p.getY() + "     Z-level = " + p.getZIndex());
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		Gdx.gl.glClearColor(1f, 0.8f, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cursor.setSize(squareWidth, squareHeight);

		// move cursor according to input
		int movementScale = 100;
//		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) cursor.translateX(-squareWidth);
//		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) cursor.translateX(squareWidth);
//		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) cursor.translateY(-squareHeight);
//		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) cursor.translateY(squareHeight);
		if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
			if (cursor.getX() != 0.0) cursor.translateX(-movementScale);
			System.out.println(cursor.getX() + ", " + cursor.getY() + "   " + Math.floor(cursor.getX()/100)*100 + ", " + Math.floor(cursor.getY()/100)*100);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
			if (cursor.getX() != 900.0) cursor.translateX(movementScale);
			System.out.println(cursor.getX() + ", " + cursor.getY() + "   " + Math.floor(cursor.getX()/100)*100 + ", " + Math.floor(cursor.getY()/100)*100);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			if (cursor.getY() != 0.0) cursor.translateY(-movementScale);
			System.out.println(cursor.getX() + ", " + cursor.getY() + "   " + Math.floor(cursor.getX()/100)*100 + ", " + Math.floor(cursor.getY()/100)*100);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			if (cursor.getY() != 900.0) cursor.translateY(movementScale);
			System.out.println(cursor.getX() + ", " + cursor.getY() + "   " + Math.floor(cursor.getX()/100)*100 + ", " + Math.floor(cursor.getY()/100)*100);
		}
		mainStage.act();
		mainStage.draw();

		batch.begin();
////		batch.draw(img, 10, 20);
//		for(int y = 0; y < squaresOnHeight; y++){
//			for(int x = 0; x < squaresOnWidth; x++){
//				if ((y == 4 || y == 5) && (x == 2 || x == 3 || x == 6 || x == 7)) {
//					gridLake.setX(x * squareWidth);
//					gridLake.setY(y * squareHeight);
//					gridLake.draw(batch);
//					continue;
//				}
//				gridSquare.setX(x * squareWidth);
//				gridSquare.setY(y * squareHeight);
//				gridSquare.draw(batch);
//			}
//		}
//
		cursor.draw(batch);
//
		batch.end();




	}

	@Override
	public void dispose () {
		batch.dispose();
		mainStage.dispose();
	}
}
