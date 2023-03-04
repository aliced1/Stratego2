package data;

import util.Piece;

import java.util.Arrays;
import java.util.HashSet;

// Singleton pattern
public class Board {

    private final Piece[][] gameBoard;
    private final HashSet<Piece> redRemainingPieces;
    //	private HashSet<Piece> redCapturedPieces;
    private final HashSet<Piece> blueRemainingPieces;
//	private HashSet<Piece> blueCapturedPieces;

    private static final Board singleInstance = new Board();

    private Board() {
        gameBoard = new Piece[10][10];
        for (Piece[] row : gameBoard) {
            Arrays.fill(row, new Piece("   ", "white.png"));
        }
        this.redRemainingPieces = new HashSet<Piece>();
        this.blueRemainingPieces = new HashSet<Piece>();
    }

    public static Board getInstance() {
        return singleInstance;
    }


    public void placePiece(Piece p, int x, int y) {
        if (x < 0 || y < 0 || x > 10 || y > 10 || p == null) throw new IllegalArgumentException();
        gameBoard[x][y] = p;
    }

    public Piece getPieceAt(int x, int y) {
        if (x < 0 || y < 0 || x > 10 || y > 10) throw new IllegalArgumentException();
        return this.gameBoard[x][y];
    }

    public void createAndAddPiece(String r, String texturePath) {
        this.redRemainingPieces.add(new Piece(r, texturePath));
        this.blueRemainingPieces.add(new Piece(r, texturePath));
    }

    public HashSet<Piece> getCurrentPieces(String color) {
        if (!color.equals("red") && !color.equals("blue")) throw new IllegalArgumentException();
        if (color.equals("red")) return this.redRemainingPieces;
        else return this.blueRemainingPieces;
    }



}

