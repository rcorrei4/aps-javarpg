package main;

import gui.Window;
import main.GameLogic;
import java.util.HashMap;

import java.util.Map;

public class Main {

	public static void main(String[] args) {
		GameLogic game = new GameLogic();
		Window window = new Window();

		window.createWindow();
		game.startGame();

		Map<String, Runnable> gameMap = new HashMap<>();
		gameMap.put("startGame", GameLogic::startGame);
		gameMap.put("printMenu", GameLogic::printMenu);
		gameMap.put("characterInfo", GameLogic::characterInfo);
		gameMap.put("continueJourney", GameLogic::continueJourney);
		gameMap.put("randomBattle", () -> GameLogic.randomBattle(new WeakEnemies("Jorge", 100, 100, 0)));

		String userInput = "startGame"; // example userInput

		// invoke the method based on the userInput
		if (gameMap.containsKey(userInput)) {
			gameMap.get(userInput).run();
		} else {
			System.out.println("Invalid input");
		}

	}

}
