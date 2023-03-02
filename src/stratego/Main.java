package stratego;

import java.util.Scanner;

import stratego.datamanagement.Board;
import stratego.processor.Processor;
import stratego.ui.CLI;

public class Main {

	public static void main(String[] args) {
		
		
		//TODO add exception handling
		
		try {
			Scanner s = new Scanner(System.in);
			Board b = new Board();
			Processor p = new Processor(b);
			CLI userInterface = new CLI(p, b);
			userInterface.start();

		}
		catch (Exception e) {
			CLI.printException(e);
		}
		
		
	}
}
