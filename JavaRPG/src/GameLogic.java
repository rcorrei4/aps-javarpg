import java.util.Scanner;

public class GameLogic {
	static Scanner sc = new Scanner(System.in);

	static Player player; //criando um player

	// método para pegar o input do console
	public static int readInt(String prompt, int userChoices) {
		int input;
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(sc.next());
			}catch(Exception e ) {
				input = -1;
				System.out.println("Por favor, entre com um número inteiro.");
			}

		}while(input < 1 || input > userChoices);
		return input;
	}

	// método para simular um clear no console
	public static void clearConsole() {
		for (int i = 0; i < 100; i++) 
			System.out.println();
	}

	// método para colocar um divider com tamanho n
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

	// método para começar o game
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

		// pegando o nome
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
		player = new Player (name);
	}
}
