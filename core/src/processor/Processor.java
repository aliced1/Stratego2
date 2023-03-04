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
        board.createAndAddPiece("Marshal");
        board.createAndAddPiece("General");
        board.createAndAddPiece("Spy");
        board.createAndAddPiece("FLA");

        for (int i = 0; i < 2; i++) board.createAndAddPiece("Colonel");
        for (int i = 0; i < 3 ; i++) board.createAndAddPiece("Major");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Captain");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Lieutenant");
        for (int i = 0; i < 4; i++) board.createAndAddPiece("Sergeant");
        for (int i = 0; i < 5; i++) board.createAndAddPiece("Miner");
        for (int i = 0; i < 8; i++) board.createAndAddPiece("Scout");
        for (int i = 0; i < 6; i++) board.createAndAddPiece("BOM");
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
