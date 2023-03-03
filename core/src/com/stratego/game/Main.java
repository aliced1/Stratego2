package com.stratego.game;

import data.Board;
import processor.Processor;
import ui.CLI;

public class Main {

    public static void main(String[] args) {


        //TODO add exception handling

        try {
            Board b = Board.getInstance();
            processor.Processor p = new Processor(b);
            CLI userInterface = new CLI(b);
            userInterface.start();

        }
        catch (Exception e) {
            CLI.printException(e);
        }


    }
}
