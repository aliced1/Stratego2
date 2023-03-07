package ui;

import data.Board;

public class CLI {

    private final Board board;


    public CLI(Board b) {
        this.board = b;
    }

    public static void printException(Exception e) {
        e.printStackTrace();
    }


    /**
     * Simple starter method to kick off the CLI
     * @throws Exception
     */
    public void start() {
        System.out.println("Welcome to Stratego! (command line interface)");
        printBoard();
    }

    /**
     * Prints current board state
     */
    private void printBoard() {
        for (int j = 9; j >= 0; j--) {
            System.out.print(j + " |");

            for (int i = 0; i < 10; i++) {

                if ((j == 4 || j == 5) &&
                        (i == 2 || i == 3 || i == 6 || i == 7)) {
                    System.out.print("__X__|");
                    continue;
                }

                System.out.print("_" + board.getPieceAt(i, j) + "_|");
            }

            System.out.println();
        }
        System.out.println("    0     1     2     3     4     5     6     7     8     9");
    }


}

