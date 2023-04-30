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

	// player = new Player(name);

	public static void handleUserInput() {
		if (gameState == 0) {
			startGame();
		} else if (gameState == 1) {
			printMenu();
		} else if (gameState == 2) {
			continueJourney();
		}
	}
	// method to start the game
	public static void startGame() {
		System.out.println(gameStateLvl);
		if (gameStateLvl == 0) {
			Window.setDisplayText("Qual o seu nome?");
		} else if (gameStateLvl == 1) {
			Window.setDisplayText("Seu nome é: " + Window.getUserInput() + "\nEstá correto? (1)SIM (2)NÃO");
		} else if (gameStateLvl == 2) {
			if (Window.getUserInput().equals("1")) {
				gameState += 1;
				gameStateLvl = 0;
				handleUserInput();
			} else {
				gameStateLvl = 0;
				handleUserInput();
			}
		}
		gameStateLvl++;
	}

	public static void printMenu() {
		if(gameStateLvl == 0) {
			Window.setDisplayText("(1) Continuar Jornada\n(2) Informações do Personagem");
		} else if (gameStateLvl == 1) {
			if(Window.getUserInput().equals("1")){
				gameState = 2;
				gameStateLvl = 0;
				handleUserInput();
			} else if (Window.getUserInput().equals("2")) {
				// Window.setDisplayText("Informações do personagem" + "Nome: " + player.name + "\nHP: " + player.hp + "\nXP: " + player.xp);
				Window.setDisplayText("teste");
			}
		}
		gameStateLvl++;
			
	}

	public static void characterInfo() {
		// code to show the player's character info
		

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
		Story.intro();
		Story.actI();
		battle();
	}

	public static void menu() {
		Window.setDisplayText("Teste");
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