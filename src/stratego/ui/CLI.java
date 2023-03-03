package stratego.ui;

import java.util.Scanner;

import stratego.datamanagement.Board;
import stratego.processor.Processor;

public class CLI {
	
	private Board board;
	private Processor processor;
	private Scanner scanner;
	
	
	public CLI(Processor p, Board b) {
		this.processor = p;
		this.board = b;
	}
	
	public static void printException(Exception e) {
		e.printStackTrace();
	}
	
	
	/**
	 * Simple starter method to kick off the CLI
	 * @throws Exception
	 */
	public void start() throws Exception {
		System.out.println("Welcome to Stratego! (command line interface)");
		
		try {
			this.scanner = new Scanner(System.in);
		}
		catch (Exception e) {
			throw new Exception(e);
		}
		
		printBoard();
		
		
	}
	
	/**
	 * Prints current board state
	 */
	private void printBoard() {
		System.out.println("   0   1   2   3   4   5   6   7   8   9");
		System.out.println("  _______________________________________");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + "|");
			
			for (int j = 0; j < 10; j++) {
				
				if ((i == 4 || i == 5) &&
					(j == 2 || j == 3 || j == 6 || j == 7)) {
					System.out.print("__\u2593__|");
					continue;
				}
				
				System.out.print("_" + board.getPieceAt(i, j) + "_|");
			}
			
			System.out.println();
		}
	}
	

}
