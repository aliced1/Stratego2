package com.stratego.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import data.Board;
import processor.Processor;
import ui.CLI;
import ui.StrategoGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {

		try {
			Board b = Board.getInstance();
			processor.Processor p = new Processor(b);
			CLI userInterface = new CLI(b);
			userInterface.start();

		}
		catch (Exception e) {
			CLI.printException(e);
		}

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("stratego");
		new Lwjgl3Application(new StrategoGame(), config);
	}
}
