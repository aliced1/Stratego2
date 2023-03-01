package stratego.datamanagement;

import java.util.HashSet;

import stratego.util.Piece;

public class Board {
	
	Piece[][] gameBoard;
	HashSet<Piece> redRemainingPieces;
	HashSet<Piece> redCapturedPieces;
	HashSet<Piece> blueRemainingPieces;
	HashSet<Piece> blueCapturedPieces;
	
	public Board() {
		gameBoard = new Piece[10][10];
	}
	
	
	public void placePiece(Piece p, int x, int y) {
		
		//TODO add check for outside board space
		//TODO add check for null piece
		
		gameBoard[x][y] = p;
	}

}
