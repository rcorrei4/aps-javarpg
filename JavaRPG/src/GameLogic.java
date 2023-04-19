import java.util.Scanner;

public class GameLogic {
	static Scanner sc = new Scanner(System.in);

	static Player player; //creating a player

	// method to get input from console
	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(sc.next());
			} catch(Exception e ) {
				input = -1;
				System.out.println("Por favor, entre com um número inteiro.");
			}
		} while(input < 1 || input > userChoices);
		return input;
	}

	// method to simulate a clear in the console
	public static void clearConsole() {
		for (int i = 0; i < 100; i++) 
			System.out.println();
	}

	// method to put a divider with size n
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}

	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
	}

	public static void anythingToContinue() {
		System.out.println("\nDigite algo para continuar...");
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
			printHeading("Seu nome é: " + name + "\nEstá correto?");
			int input = readInt("->", 2);
			if (input == 1) 
				nameSet = true;
		} while(!nameSet);

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
			} else if (input == 2){
				characterInfo();
			} else {
				break;
			}
		}
	}

	public static void continueJourney() {
	}

	public static void characterInfo() {
		// code to show the player's character info
	}
}
