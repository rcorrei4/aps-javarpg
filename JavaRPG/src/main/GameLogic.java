package main;

import gui.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class GameLogic {
	private static int gameState = 0;
	private static int gameStateLvl = 0;
	private static Enemy currentEnemy;
	private static String previousWindowText;
	public static boolean onInventory;

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
				loadData();
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

	public static void loadData(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("saveFile.txt"));
			player.name = br.readLine();
			player.maxHp = Integer.parseInt(br.readLine());
			player.hp = Integer.parseInt(br.readLine());
			player.xp = Integer.parseInt(br.readLine());
			gameState = Integer.parseInt(br.readLine());
			gameStateLvl = Integer.parseInt(br.readLine());
			
			br.close();
		}
		catch(Exception e){

		}
	}

	public static void saveWriter(){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("saveFile.txt"));
			bw.write(player.name);
			bw.newLine();
			bw.write(""+player.maxHp);
			bw.newLine();
			bw.write(""+player.hp);
			bw.newLine();
			bw.write(""+player.xp);
			bw.newLine();
			bw.write(""+gameState);
			bw.newLine();
			bw.write(""+gameStateLvl);

			bw.close();
		}
		catch(Exception e){
			
		}
	}

	public static void characterInfo() {
		Window.setDisplayText(
				"Informações do personagem:" +
						"\n\nNome: " + player.name + "\nHP:" + player.hp + "\nXP:" + player.xp);
		gameStateLvl -= 1;
	}

	public static void battle(Enemy enemy) {
		gameStateLvl -= 1;
		battleRound(enemy);
	}

	public static void battleRound(Enemy enemy) {
		previousWindowText = "";

		try {
			String input = Window.getUserInput();
			int playerAction = Integer.parseInt(input);

			switch (playerAction) {
				case 1:
					double damageToEnemy = player.attack() - enemy.currentDefensePoints;
					if (damageToEnemy < 0) {
						damageToEnemy = 0;
					}
					enemy.hp -= damageToEnemy;
					previousWindowText += "Você atacou " + enemy.name + " causando " + damageToEnemy + " de dano!\n";
					if (enemy.hp <= 0) {
						previousWindowText += "\n\n" + enemy.name + " foi derrotado!";
						gameStateLvl++;
					}
					break;
				case 2:
					double defensePoints = player.increaseDefense();
					System.out.println(defensePoints);
					previousWindowText += "Você se defendeu e ganhou " + defensePoints + " pontos de defesa!\n";
					break;
				case 3:
					// Implementar uso de itens
					player.printInventory();
					break;
				default:
					previousWindowText += "Comando inválido!\n";
					break;
			}
			int enemyAction = enemy.randomAction();
			switch (enemyAction) {
				case 1:
					double damageToPlayer = enemy.attack() - player.currentDefensePoints;
					if (damageToPlayer < 0) {
						damageToPlayer = 0;
					}
					player.hp -= damageToPlayer;
					previousWindowText += enemy.name + " atacou causando " + damageToPlayer + " de dano!";
					if (player.hp <= 0) {
						previousWindowText += "\n\nVocê foi derrotado!";
						gameStateLvl++;
					}
					break;
				case 2:
					double defensePoints = enemy.increaseDefense();
					previousWindowText += enemy.name + " se defendeu e ganhou " + defensePoints + " pontos de defesa!";
					break;
				case 3:
					System.out.println("Item especial enemy");
					break;
			}

			Window.setDisplayText(
				enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp +
				"\n\n\nNome: " + player.name + "\nHP:" + player.hp + "/" + player.maxHp + "\nXP:" + player.xp +
				"\n\nAtacar (1) - Defender-se (2) - Abrir Invetário (3)\n\n" + previousWindowText
			);
		} catch (NumberFormatException erro1) {
			Window.setDisplayText(
				enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp +
				"\n\n\nNome: " + player.name + "\nHP:" + player.hp + "/" + player.maxHp + "\nXP:" + player.xp +
				"\n\nAtacar (1) - Defender-se (2) - Utilizar item (3)\n\n" + previousWindowText
			);
		}
	}

	public static void deathScreen() {
		if (gameStateLvl == 0) {
			Window.setDisplayText("(1) Retomar progresso anterior\n(2) Voltar ao início\n(3) Sair do jogo");
		} else if (gameStateLvl == 1) {
			if (Window.getUserInput().equals("1")) {
				// Retomar save
			} else if (Window.getUserInput().equals("2")) {
				gameState = 0;
				gameStateLvl = 0;
			} else {
				System.exit(0);
			}
		}
		
		
	}

	public static void inventory() {
		onInventory = true;
		gameStateLvl = 0; 
		if(gameStateLvl == 0){
			if (Window.getUserInput().equals("1")){// ja volto
				// bele
				player.useItem();
			} else  if(Window.getUserInput().equals("2")){
				player.useItem();
			} else if(Window.getUserInput().equals("3")) {
				player.useItem();
			}
		}
	}




	public static void firstChapter() {
		if (gameStateLvl == 0) {
			Story.intro();
		} else if (gameStateLvl == 1) {
			Story.act1();
		} else if (gameStateLvl == 2) {
			Story.act1_1();
		} else if (gameStateLvl == 3) {
			Window.setDisplayText("Você encontrou os mercenários. Lute!");
			currentEnemy = new Enemy("Mercenários", 100, 100, 0, 2);
		} else if (gameStateLvl == 4) {
			if (player.hp <= 0) {
				player.hp = player.maxHp;
				gameStateLvl++;
			} else {
				battle(currentEnemy);
			}
		} else if (gameStateLvl == 5){
			Story.act1_2();
		}else if (gameStateLvl == 6) {
			handleUserInput(true, true);
		}
	}

	public static void secondChapter() {
		System.out.println(gameStateLvl);
		if (gameStateLvl == 0) {
			Story.act2_1();
		} else if (gameStateLvl == 1) {
			Story.act2_2();
		} else if (gameStateLvl == 2) {
			Story.act2_3();
		} else if (gameStateLvl == 3) {
			Story.act2_4();
		} else if (gameStateLvl == 4) {
			Story.act2_5();
		} else if (gameStateLvl == 5) {
			Story.act2_6();
		} else if (gameStateLvl == 6) {
			Story.act2_7();
			currentEnemy = new Enemy("Mercenários", 15, 15, 0, 1);
		} else if (gameStateLvl == 7) {
			if (player.hp <= 0) {
				gameState = 999;
				gameStateLvl = 0;
			} else if (currentEnemy.hp <= 0) {
				handleUserInput(true, true);
			} else {
				battle(currentEnemy);
			}
		}
	}

	public static void thirdChapter () {
		
	}
}