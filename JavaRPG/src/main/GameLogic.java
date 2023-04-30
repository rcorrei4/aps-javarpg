package main;

import gui.Window;

public class GameLogic {
	private static int gameState = 0;
	private static int gameStateLvl = 0;
	
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
				menu();
			} else {
				gameStateLvl = 0;
				startGame();
			}
		}
		gameStateLvl += 1;
	}
	
	public static void menu() {
		Window.setDisplayText("Teste");
	}
	
	public static void handleUserInput() {
		if (gameState == 0) {
			startGame();
		} else if (gameState == 1) {
			menu();
		}
	}
}

/*
import java.util.Scanner;
import java.util.Random;

public class GameLogic {
	static Scanner sc = new Scanner(System.in);

	static Player player; // creating a player

	// method to get input from console
	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(sc.next());
			} catch (Exception e) {
				input = -1;
				System.out.println("Por favor, entre com um número inteiro.");
			}
		} while (input < 1 || input > userChoices);
		return input;
	}

	// method to simulate a clear in the console
	public static void clearConsole() {
		for (int i = 0; i < 100; i++)
			System.out.println();
	}

	// method to put a divider with size n
	public static void printSeparator(int n) {
		for (int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}

	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}

	public static void anythingToContinue() {
		System.out.println("\nDigite qualquer coisa para continuar...");
		sc.next();
	}

	// method to start the game
	public static void startGame() {
		boolean nameSet = false;
		String name;

		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("NOME DO JOGO");
		System.out.println("Algoritmo por CodeStudent");
		printSeparator(30);
		printSeparator(40);

		// getting the name
		do {
			clearConsole();
			printHeading("Qual o seu nome? ");
			name = sc.next();

			clearConsole();
			printHeading("Seu nome é: " + name + "\nEstá correto? (1)SIM (2)NÃO");
			int input = readInt("->", 2);
			if (input == 1)
				nameSet = true;
		} while (!nameSet);

		player = new Player(name);

		gameLoop();
	}

	public static void printMenu() {
		printSeparator(40);
		printSeparator(30);
		System.out.println("(1) Continuar Jornada");
		System.out.println("(2) Informações do Personagem");
		printSeparator(30);
	}

	public static void gameLoop() {
		while (true) {
			printMenu();
			int input = readInt("->", 2);
			if (input == 1) {
				continueJourney();
				break;
			} else if (input == 2) {
				characterInfo();
			} else {
				break;
			}
		}
	}

	public static void characterInfo() {
		// code to show the player's character info
		printHeading("Informações do personagem");
		System.out.println("Nome: " + player.name);
		System.out.println("HP " + player.hp);
		System.out.println("XP " + player.xp);
		printSeparator(30);
	}

	/*
	 * public static void randomBattle(Enemy weakEnemies) {
	 * GameLogic.clearConsole();
	 * GameLogic.printHeading("Você encontrou os mercenários. Lute!");
	 * GameLogic.anythingToContinue();
	 * battle(weakEnemies);
	 * }
	 

	public static void battle() {
		// main loop
		while (true) {
			clearConsole();
			WeakEnemies enemy1 = new WeakEnemies("Jorge", 100, 100, 0);
			printHeading(enemy1.name + "\nHP " + enemy1.hp + "/" + enemy1.maxHp);
			printHeading(player.name + "\nHP " + player.hp + "/" + player.maxHp);
			System.out.println("Escolha uma ação: ");
			printSeparator(20);
			System.out.println("(1)Lutar\n(2)Usar Estimulante\n(3)Fugir");
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
					anythingToContinue();
					break;
				} else {
					System.out.println("Você não conseguiu escapar...");
					anythingToContinue();
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
}
*/