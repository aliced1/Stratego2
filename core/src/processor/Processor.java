package processor;

import data.Board;
import util.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Processor {

    Board board;

    public Processor(Board b) throws Exception {
        this.board = b;
        this.createInitialPieces();
        this.placePiecesRandomly();
    }

    //TODO remove pieces from player's pool

    private void createInitialPieces() throws Exception {
        board.createAndAddPiece("Marshal", "Marshal.png");
        board.createAndAddPiece("General", "General.png");
        board.createAndAddPiece("Spy", "Spy.png");
        board.createAndAddPiece("FLA", "flag.jpg");

        for (int i = 0; i < 2; i++) board.createAndAddPiece("Colonel", "Colonel.png");
        for (int i = 0; i < 3 ; i++) board.createAndAddPiece("Major", "Major.png");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Captain", "Captain.png");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Lieutenant", "Lieutenant.png");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Sergeant", "Sergeant.png");
        for (int i = 0; i < 5; i++) board.createAndAddPiece("Miner", "Miner.png");
        for (int i = 0; i < 8; i++) board.createAndAddPiece("Scout", "Scout.png");
        for (int i = 0; i < 6; i++) board.createAndAddPiece("BOM", "Bomb.png");
    }

    private void placePiecesRandomly() throws Exception {
        // create list of pieces from set, shuffle, create iterator, iterate over board and place
        List<Piece> listForShuffle = new ArrayList<Piece>(board.getCurrentPieces("red"));
        Collections.shuffle(listForShuffle);
        Iterator<Piece> it = listForShuffle.iterator();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                board.placePiece(it.next(), i, j);
            }
        }

        listForShuffle = new ArrayList<Piece>(board.getCurrentPieces("blue"));
        Collections.shuffle(listForShuffle);
        it = listForShuffle.iterator();
        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board.placePiece(it.next(), i, j);
            }
        }
    }

}
