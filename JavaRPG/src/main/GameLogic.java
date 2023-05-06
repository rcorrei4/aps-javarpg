package main;

import java.util.Random;
import gui.Window;

public class GameLogic {
	private static int gameState = 0;
	private static int gameStateLvl = 0;

	static Player player = null; // creating a player

	// Method called when user press ENTER or is called manually, goes to the next
	// gameStateLvl
	public static void handleUserInput() {
		gameStateLvl++;
		Main.gameMap.get(gameState).run();
	}

	/*
	 * Another method when user press ENTER but with the options to reset the
	 * gameStateLvl
	 * and going to the next gameState
	 */
	public static void handleUserInput(boolean resetGameStateLvl, boolean nextGameState) {
		if (resetGameStateLvl) {
			gameStateLvl = 0;
		} else {
			gameStateLvl++;
		}

		if (nextGameState) {
			gameState++;
		}
		Main.gameMap.get(gameState).run();
	}

	public static void startGame() {
		if (gameStateLvl == 0) {
			Window.setDisplayText("(1) Criar novo jogo\n(2) Carregar Jogo");
		} else if (gameStateLvl == 1) {
			if (Window.getUserInput() != null && Window.getUserInput().equals("1")) {
				Window.setDisplayText("Digite seu nome: ");
				// handleUserInput(true, true);
			} else if (!Window.getUserInput().isEmpty()) {
				player = new Player(Window.getUserInput());
				Window.setDisplayText("Seu nome é: " + Window.getUserInput() + "\nEstá correto? (1) Sim (2)Não");
			} else {
				Window.setDisplayText("Nome não pode ficar vazio!");
			}
		} else if (gameStateLvl == 3) {
			if (player != null) {
				if (Window.getUserInput() != null && Window.getUserInput().equals("1")) {
					handleUserInput(true, true);
				} else {
					handleUserInput(true, false);
				}
			}
		} else {
			handleUserInput(true, false);
		}
	}
	/*
	 * public static void startGame() {
	 * if (gameStateLvl == 0) {
	 * handleUserInput(true, true);
	 * Window.setDisplayText("(1) Criar novo jogo\n(2)Carregar jogo");
	 * if (Window.getUserInput().equals("1")) {
	 * Window.setDisplayText("Qual seu nome? ");
	 * } else if (!Window.getUserInput().isEmpty()) {
	 * player = new Player(Window.getUserInput());
	 * Window.setDisplayText("Seu nome é: " + Window.getUserInput() +
	 * "\nEstá correto? (1) SIM (2) NÃO");
	 * } else {
	 * Window.setDisplayText("Nome não pode ficar vazio!");
	 * }
	 * } else if (gameStateLvl == 2) {
	 * if (player != null) {
	 * if (Window.getUserInput().equals("1")) {
	 * handleUserInput(true, true);
	 * } else {
	 * handleUserInput(true, false);
	 * }
	 * } else {
	 * handleUserInput(true, false);
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	public static void saveGame() {

	}

	public static void characterInfo() {
		Window.setDisplayText(
				"Informações do personagem:" +
						"\n\nNome: " + player.name + "\nHP:" + player.hp + "\nXP:" + player.xp);
		gameStateLvl -= 1;
	}

	public static void randomBattle(Enemy weakEnemies) {
		if (gameStateLvl == 0) {
			Window.setDisplayText("Você encontrou os mercenários. Lute!");
		} else if (gameStateLvl == 1) {
			battle();
		}
	}

	public static void battle() {
		/*
		 * // main loop
		 * while (true) {
		 * WeakEnemies enemy1 = new WeakEnemies("Jorge", 100, 100, 0);
		 * Window.setDisplayText(enemy1.name + "\nHP " + enemy1.hp + "/" + enemy1.maxHp
		 * + player.name + "\nHP "
		 * + player.hp + "/" + player.maxHp + "Escolha uma ação: "
		 * + "(1)Lutar\n(2)Usar Estimulante\n(3)Fugir");
		 * int input = readInt("->", 3);
		 * if (input == 1) {
		 * // LUTAR
		 * player.chooseTrait();
		 * enemy1.chooseTraitsEnemies();
		 * } else if (input == 2) {
		 * // USAR ESTIMULANTE PARA AUMENTAR HP
		 * // USO LIMITADO
		 * // player.useStimulant();
		 * } else {
		 * // TENTAR FUGIR
		 * if (tryToEscape()) {
		 * System.out.println("Você fugiu da batalha! ");
		 * break;
		 * } else {
		 * System.out.println("Você não conseguiu escapar...");
		 * enemy1.chooseTraitsEnemies();
		 * }
		 * }
		 */ }

	private static boolean tryToEscape() {
		Random random = new Random();
		return random.nextInt(100) < 50;// 50% de chance de escapar
	}

	public static void continueJourney() {
		if (gameStateLvl == 0) {
			Story.intro();
		} else if (gameStateLvl == 1) {
			Story.actI();
		} else if (gameStateLvl == 2) {
			Story.actI_1();
		} else if (gameStateLvl == 3) {
			battle();
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