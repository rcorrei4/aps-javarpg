package main;

import gui.Window;
import java.util.HashMap;

import java.util.Map;

public class Main {
	static Map<Integer, Runnable> gameMap = new HashMap<>();

	public static void main(String[] args) {
		Window window = new Window();

		window.createWindow();

		// Hashmap for the gameLvls
		gameMap.put(0, GameLogic::startGame);
		gameMap.put(1, GameLogic::saveGame);
		gameMap.put(2, GameLogic::firstChapter);
		gameMap.put(3, GameLogic::secondChapter);
		gameMap.put(4, GameLogic::thirdChapter);
		gameMap.put(5, GameLogic::fourthChapter);
		gameMap.put(6, GameLogic::fifthChapther);
		gameMap.put(666, GameLogic::deathScreen);

		int userInput = 0; // example userInpu4

		// invoke the method based on the userInput
		if (gameMap.containsKey(userInput)) {
			gameMap.get(userInput).run();
		} else {
			System.out.println("Invalid input");
		}

	}

}
