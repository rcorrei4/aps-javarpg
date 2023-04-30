package main;
import static java.util.Map.entry;

import gui.Window;

public class Main {
	public static void main(String[] args) {
		GameLogic game = new GameLogic();
		Window window = new Window();
		
		window.createWindow();
		game.startGame();
	}
}
