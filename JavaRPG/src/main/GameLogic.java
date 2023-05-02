package main;

import java.util.Random;

import gui.Window;

public class GameLogic {
	private static int gameState = 0;
	private static int gameStateLvl = 0;

	static Player player; // creating a player

	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			Window.setDisplayText(prompt);
			try {
				input = Integer.parseInt(Window.getUserInput());
			} catch (Exception e) {
				input = -1;
				Window.setDisplayText("Por favor, entre com um número inteiro.");
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	// Method called when user press ENTER and goes to the next gameState
	public static void handleUserInput() {
		gameStateLvl++;
		Main.gameMap.get(gameState).run();
	}

	/* Another method when user press ENTER but with the options to reset the gameStateLvl
	and going to the next gameState */
	public static void handleUserInput(boolean resetGameStateLvl, boolean nextGameState) {
		if(resetGameStateLvl) {
			gameStateLvl = 0;
		} else {
			gameStateLvl++;
		}

		if(nextGameState) {
			gameState++;
		}
		Main.gameMap.get(gameState).run();
	}

	public static void startGame() {
		if (gameStateLvl == 0) {
			Window.setDisplayText("Qual o seu nome?");
		} else if (gameStateLvl == 1) {
			player = new Player(Window.getUserInput());
			Window.setDisplayText("Seu nome é: " + Window.getUserInput() + "\nEstá correto? (1)SIM (2)NÃO");
		} else if (gameStateLvl == 2) {
			// If name is correct continue, if not do all over again
			if (Window.getUserInput().equals("1")) {
				handleUserInput(true, true);
			} else {
				handleUserInput(true, false);
			}
		}
	}

	public static void printMenu() {
		if(gameStateLvl == 0) {
			Window.setDisplayText("(1) Continuar Jornada\n(2) Informações do Personagem");
		} else if (gameStateLvl == 1) {
			if(Window.getUserInput().equals("1")){
				handleUserInput(true, true);
			} else if (Window.getUserInput().equals("2")) {
				characterInfo();
			}
		}
	}

	public static void characterInfo() {
		gameStateLvl -= 2;
		Window.setDisplayText(
			"Informações do personagem:" + 
			"\n\nNome: " + player.name
		);
	}

	public static void randomBattle(Enemy weakEnemies) {
		Window.setDisplayText("Você encontrou os mercenários. Lute!");
		battle();
	}

	public static void battle() {
		// main loop
		while (true) {

			WeakEnemies enemy1 = new WeakEnemies("Jorge", 100, 100, 0);
			Window.setDisplayText(enemy1.name + "\nHP " + enemy1.hp + "/" + enemy1.maxHp + player.name + "\nHP "
					+ player.hp + "/" + player.maxHp + "Escolha uma ação: "
					+ "(1)Lutar\n(2)Usar Estimulante\n(3)Fugir");
			int input = readInt("->", 3);
			if (input == 1) {
				// LUTAR
				player.chooseTrait();
				enemy1.chooseTraitsEnemies();
			} else if (input == 2) {
				// USAR ESTIMULANTE PARA AUMENTAR HP
				// USO LIMITADO
				// player.useStimulant();
			} else {
				// TENTAR FUGIR
				if (tryToEscape()) {
					System.out.println("Você fugiu da batalha! ");
					break;
				} else {
					System.out.println("Você não conseguiu escapar...");
					enemy1.chooseTraitsEnemies();
				}
			}
		}
	}

	private static boolean tryToEscape() {
		Random random = new Random();
		return random.nextInt(100) < 50;// 50% de chance de escapar
	}

	public static void continueJourney() {
		if(gameStateLvl == 0) {
			Story.intro();
		} else if (gameStateLvl == 1) {
			Story.actI();
		} else if (gameStateLvl == 2) {
			Story.actI_1();
		}
	}

	
}

/*
 * 
 * 
 * /*
 * public static void randomBattle(Enemy weakEnemies) {
 * GameLogic.clearConsole();
 * GameLogic.printHeading("Você encontrou os mercenários. Lute!");
 * GameLogic.anythingToContinue();
 * battle(weakEnemies);
 * }
 * 
 * 
 * public static void battle() {
 * // main loop
 * while (true) {
 * clearConsole();
 * WeakEnemies enemy1 = new WeakEnemies("Jorge", 100, 100, 0);
 * printHeading(enemy1.name + "\nHP " + enemy1.hp + "/" + enemy1.maxHp);
 * printHeading(player.name + "\nHP " + player.hp + "/" + player.maxHp);
 * System.out.println("Escolha uma ação: ");
 * printSeparator(20);
 * System.out.println("(1)Lutar\n(2)Usar Estimulante\n(3)Fugir");
 * int input = readInt("->", 3);
 * if (input == 1) {
 * // LUTAR
 * player.chooseTrait();
 * enemy1.chooseTraitsEnemies();
 * 
 * } else if (input == 2) {
 * // USAR ESTIMULANTE PARA AUMENTAR HP
 * // USO LIMITADO
 * // player.useStimulant();
 * } else {
 * // TENTAR FUGIR
 * if (tryToEscape()) {
 * System.out.println("Você fugiu da batalha! ");
 * anythingToContinue();
 * break;
 * } else {
 * System.out.println("Você não conseguiu escapar...");
 * anythingToContinue();
 * enemy1.chooseTraitsEnemies();
 * }
 * }
 * 
 * }
 * 
 * }
 * 
 * private static boolean tryToEscape() {
 * Random random = new Random();
 * 
 * return random.nextInt(100) < 50;// 50% de chance de escapar
 * }
 * 
 * public static void continueJourney() {
 * Story.intro();
 * Story.actI();
 * battle();
 * }
 * }
 */