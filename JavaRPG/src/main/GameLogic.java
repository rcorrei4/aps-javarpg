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
				handleUserInput(true, true);
			} else if (Window.getUserInput() != null && Window.getUserInput().equals("2")) {
				gameState = 2;
				handleUserInput(true, false);
			}
		}
	}

	public static void saveGame() {
		if (gameStateLvl == 0) {
			Window.setDisplayText("Digite seu nome: ");
		} else if (gameStateLvl == 1) {
			if (!Window.getUserInput().isEmpty()) {
				player = new Player(Window.getUserInput(), 10, 10, 1, 5);
				Window.setDisplayText("Seu nome é: " + Window.getUserInput() + "\nEstá correto? (1) Sim (2)Não");
			} else {
				handleUserInput(true, false);
			}
		} else if (gameStateLvl == 2) {
			if (player != null) {
				if (Window.getUserInput() != null && Window.getUserInput().equals("1")) {
					handleUserInput(true, true);
				} else {
					handleUserInput(true, false);
				}
			} else {
				handleUserInput(true, false);
			}
		}
	}

	public static void characterInfo() {
		Window.setDisplayText(
				"Informações do personagem:" +
						"\n\nNome: " + player.name + "\nHP:" + player.hp + "\nXP:" + player.xp);
		gameStateLvl -= 1;
	}

	public static void firstChapter() {
		if (gameStateLvl == 0) {
			Story.intro();
		} else if (gameStateLvl == 1) {
			Story.actI();
		} else if (gameStateLvl == 2) {
			Story.actI_1();
		} else if (gameStateLvl == 3) {
			Window.setDisplayText("Você encontrou os mercenários. Lute!");
		} else if (gameStateLvl == 4) {
			System.out.println("teste");
			if (player.hp <= 0) {
				player.hp = player.maxHp;
				handleUserInput(true, true);
			} else {
				Enemy enemy1 = new Enemy("Mercenários", 1, 1, 0, 2);
				battle(enemy1);
			}
		}
	}

	public static void battle(Enemy enemy) {
		gameStateLvl -= 1;
		int action = enemy.randomAction();
		Window.setDisplayText(
			enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp +
			"\n\n\nNome: " + player.name + "\nHP:" + player.hp + "/" + player.maxHp + "\nXP:" + player.xp +
			"\n\nAtacar (1) - Defender-se (2) - Utilizar item (3)"
		);

		String input = Window.getUserInput();
		int playerAction = Integer.parseInt(input);
		int enemyAction = enemy.randomAction();

		switch (playerAction) {
			case 1:
				int damageToEnemy = player.attack();
				enemy.hp -= damageToEnemy;
				Window.setDisplayText("Você atacou " + enemy.name + " causando " + damageToEnemy + " de dano!");
				if (enemy.hp <= 0) {
					Window.setDisplayText(enemy.name + " foi derrotado!");
					return;
				}

				int damageToPlayer = enemy.attack();
				player.hp -= damageToPlayer;
				Window.setDisplayText(enemy.name + " contra-atacou causando " + damageToPlayer + " de dano!");
				if (player.hp <= 0) {
					Window.setDisplayText("Você foi derrotado!");
					return;
				}
				break;
			case 2:
				int defense = player.defend();
				Window.setDisplayText("Você se defendeu e ganhou " + defense + " pontos de defesa!");
				int enemyDamage = enemy.attack() - defense;
				if (enemyDamage < 0) {
					enemyDamage = 0;
				}
				player.hp -= enemyDamage;
				Window.setDisplayText(enemy.name + " atacou mas você se defendeu. Recebeu " + enemyDamage + " de dano!");
				if (player.hp <= 0) {
					Window.setDisplayText("Você foi derrotado!");
					return;
				}
				break;
			case 3:
				// Implementar uso de itens
				break;
			default:
				Window.setDisplayText("Comando inválido!");
				break;
		}
	}
	
	public static void teste () {
		System.out.println("blablabla");
	}

	private static boolean tryToEscape() {
		Random random = new Random();
		return random.nextInt(100) < 50;// 50% de chance de escapar
	}
}