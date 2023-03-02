package stratego.datamanagement;

import java.util.Arrays;
import java.util.HashSet;

import stratego.util.Piece;

public class Board {
	
	private Piece[][] gameBoard;
	private HashSet<Piece> redRemainingPieces;
//	private HashSet<Piece> redCapturedPieces;
	private HashSet<Piece> blueRemainingPieces;
//	private HashSet<Piece> blueCapturedPieces;
	
	public Board() throws Exception {
		gameBoard = new Piece[10][10];
		for (Piece[] row : gameBoard) {
			Arrays.fill(row, new Piece("   "));
		}
		this.redRemainingPieces = new HashSet<Piece>();
		this.blueRemainingPieces = new HashSet<Piece>();
	}
	
	
	public void placePiece(Piece p, int x, int y) {
		
		//TODO add check for outside board space
		//TODO add check for null piece
		
		gameBoard[x][y] = p;
	}
	
	public Piece getPieceAt(int x, int y) {
		if (x < 0 || y < 0 || x > 10 || y > 10) throw new IllegalArgumentException();
		return this.gameBoard[x][y];
	}
	
	public void createAndAddPiece(String r) throws Exception {
		this.redRemainingPieces.add(new Piece(r));
		this.blueRemainingPieces.add(new Piece(r));
	}
	
	public HashSet<Piece> getCurrentPieces(String color) {
		if (color != "red" && color != "blue") throw new IllegalArgumentException();
		if (color == "red") return this.redRemainingPieces;
		else return this.blueRemainingPieces;
	}
	
	

}
