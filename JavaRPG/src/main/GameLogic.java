package main;

import gui.Window;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Map.Entry;
import java.awt.Color;

public class GameLogic {
	private static int gameState = 0;
	private static int gameStateLvl = 0;
	private static Enemy currentEnemy;
	private static String previousWindowText;
	private static boolean firstBattleQuestion;
	private static boolean secondBattleQuestion;
	private static int currentQuestionIndex;
	private static int[] previousGameStateAndLvl = {0, 0};
	private static double battleAtkBonus = 1.0;
	public static boolean onInventory;
	public static String password = "216248";

	
	private static String[] questions = {
		"Qual é o princípio por trás do mantra 'reduzir, reutilizar, reciclar' no desenvolvimento sustentável?",
		"O que é o conceito de 'biodiversidade' no desenvolvimento sustentável?"
	};

	private static String[] answers = {
		"a) Minimizar a geração de resíduos e o consumo de recursos\n" +
		"b) Incentivar avanços tecnológicos em energia verde\n" +
		"c) Foco no crescimento econômico em detrimento das preocupações ambientais",

		"a) A variedade de plantas, animais e outros organismos em um ecossistema\n" +
		"b) O uso sustentável dos recursos naturais\n" +
		"c) A promoção da igualdade de gênero nas áreas rurais",


	};
	
	private static String[] correctAnswers = {"a", "b"};

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
		Window.input.requestFocus();
		if (gameStateLvl == 0) {
			Window.setDisplayText("(1) - Criar novo jogo\n(2) - Carregar Jogo");
			player = new Player(Window.getUserInput(), 10, 10, 1, 5);
			currentEnemy = new Enemy("Mercenários", 100, 100, 0, 2, 1);
		} else if (gameStateLvl == 1) {
			if (Window.getUserInput() != null && !Window.getUserInput().equals("1")
					&& !Window.getUserInput().equals("2")) {
				handleUserInput(true, false);
			}
			if (Window.getUserInput() != null && Window.getUserInput().equals("1")) {
				handleUserInput(true, true);
			} else if (Window.getUserInput() != null && Window.getUserInput().equals("2")) {
				loadData();

			}
		}
	}

	public static void saveGame() {
		if (gameStateLvl == 0) {
			Window.setDisplayText("Digite seu nome: ");
		} else if (gameStateLvl == 1) {
			if (!Window.getUserInput().isEmpty()) {
				player = new Player(Window.getUserInput(), 10, 10, 1, 5);
				Window.setDisplayText("Seu nome é: " + Window.getUserInput() + "\nEstá correto? (1) - Sim (2) - Não");
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

	public static void loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("JavaRPG/src/main/saveFile.txt"));

			player.name = br.readLine();
			player.maxHp = Integer.parseInt(br.readLine());
			player.xp = Integer.parseInt(br.readLine());
			player.defenseMultiplier = Double.parseDouble(br.readLine());
			gameState = Integer.parseInt(br.readLine());
			gameStateLvl = Integer.parseInt(br.readLine());

			String line;

			
			Inventory.inventory.remove(1);
			Inventory.inventory.remove(2);
			Inventory.inventory.remove(3);

    		while ((line = br.readLine()) != null) {
        		String[] parts = line.split(":");
            	int id = Integer.parseInt(parts[0]);
            	String value = parts[1];
				Inventory.inventory.put(id, value);
				
			}
			br.close();

			Main.gameMap.get(gameState).run();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void saveWriter() {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("JavaRPG/src/main/saveFile.txt"));

			bw.write(String.valueOf(player.name));
			bw.newLine();
			bw.write(String.valueOf(player.maxHp));
			bw.newLine();
			bw.write(String.valueOf(player.xp));
			bw.newLine();
			bw.write(String.valueOf(player.defenseMultiplier));
			bw.newLine();
			bw.write(String.valueOf(gameState));
			bw.newLine();
			bw.write(String.valueOf(gameStateLvl));
			bw.newLine();

	
			for (Entry<Integer, String> entry : Inventory.inventory.entrySet()) {
				int id = entry.getKey();
				String item = entry.getValue();
				bw.write(id + ":" + item);
				bw.newLine();
			}

			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void tutorial() {
		Window.setDisplayText(
				"Comandos: \ni - Abre o inventário\ntutorial - Tutorial básico do jogo\nmenu - Mostra informações sobre personagem\nsave - Salva o jogo\nload - Carrega o save");
	}

	public static void battleTutorial() {
		Window.setDisplayText(
				"Instruções: \nDurante a batalha, você terá as seguintes opções: \n1. Atacar - Escolha essa opção para atacar o inimigo.\n2. Defender - Use essa opção para aumentar sua defesa.\n3. Utilizar o item - Abra o inventário e escolha um item.\nVocê pode digitar 'i' para abrir o inventário.\nVocê pode digitar 'menu' para retomar a tela inicial do jogo.");
	}

	public static void characterInfo() {
		Window.setDisplayText(
				"Informações do personagem:" +
						"\n\nNome: " + "Akira Kankyo" + "\nHP:" + player.hp + "\nXP:" + player.xp);
		gameStateLvl -= 1;
	}

	public static void battle(Enemy enemy) {
		gameStateLvl -= 1;
		battleRound(enemy);
	}

	public static void battleRound(Enemy enemy) {
		previousWindowText = "";
		
		try {
			if (onInventory) {
				String itemMsg = Inventory.chooseItem();
				previousWindowText += itemMsg;
				onInventory = false;
			} else {
				String input = Window.getUserInput();
				int playerAction = Integer.parseInt(input);

				switch (playerAction) {
					case 1:
						double damageToEnemy = (player.attack()*battleAtkBonus) - enemy.currentDefensePoints;
						if (damageToEnemy < 0) {
							damageToEnemy = 0;
						}
						enemy.hp -= damageToEnemy;
						previousWindowText += "Você atacou " + enemy.name + " causando " + damageToEnemy
								+ " de dano!\n";
						if (enemy.hp <= 0) {
							previousWindowText += "\n\n" + enemy.name + " foi derrotado!";
						}
						break;
					case 2:
						double defensePoints = player.increaseDefense();
						System.out.println(defensePoints);
						previousWindowText += "Você se defendeu e ganhou " + defensePoints + " pontos de defesa!\n";
						break;
					case 3:
						// calls the method printInventory
						previousWindowText += "Seu inventário:\n" + Inventory.printInventory();
						onInventory = true;
						break;
					default:
						previousWindowText += "Comando inválido!\n";
						break;
				}
			}

			if (!onInventory) {
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
						}
						break;
					case 2:
						double defensePoints = enemy.increaseDefense();
						previousWindowText += enemy.name + " se defendeu e ganhou " + defensePoints
								+ " pontos de defesa!";
						break;
					case 3:
						System.out.println("Item especial enemy");
						break;
				}
			}

			Window.setDisplayText(
					enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp +
							"\n\n\nNome: " + "Akira Kankyo" + "\nHP:" + player.hp + "/" + player.maxHp + "\nXP:"
							+ player.xp +
							"\n\nAtacar (1) - Defender-se (2) - Abrir Inventário (3)\n\n" + previousWindowText + "\n");
		} catch (NumberFormatException erro1) {
			Window.setDisplayText(
					enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp +
							"\n\n\nNome: " + "Akira Kankyo" + "\nHP:" + player.hp + "/" + player.maxHp + "\nXP:"
							+ player.xp +
							"\n\nAtacar (1) - Defender-se (2) - Utilizar item (3)\n\n" + previousWindowText + "\n");
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

	public static void battleQuestion() {
		if (gameStateLvl == 0) {
			int randomQuestionIndex = new Random().nextInt(questions.length);
		
			Window.setDisplayText(questions[randomQuestionIndex] + "\n" + answers[randomQuestionIndex]);
		} else if (gameStateLvl == 1) {
			if (Window.getUserInput().equals(correctAnswers[currentQuestionIndex])) {
				Window.setDisplayText("Resposta correta");
				battleAtkBonus += 1.5;
			} else {
				Window.setDisplayText("Resposta incorreta");
			}
			gameState = previousGameStateAndLvl[0];
			gameStateLvl = previousGameStateAndLvl[1]-1;
		}
	}

	public static void enemyDefeated(Enemy enemy) {
		String message = "";
		message += "[Você conseguiu 1 componente eletrônico ao derrotar os mercenários]";
		String droppedItem = enemy.dropItem();
		if (droppedItem != null) {
			message += enemy.name + " deixou cair um item: " + droppedItem + "\n" + Inventory.addEnemyItem(droppedItem); // 
		}

		player.eletronicComponents++;

		Window.setDisplayText(message);
	}

	public static void firstChapter() {
		if (gameStateLvl == 0) {
			Story.intro();
		} else if (gameStateLvl == 1) {
			Story.act1();
		} else if (gameStateLvl == 2) {
			Story.act1_1();
		} else if (gameStateLvl == 3) {
			Inventory.setAvailable(false);
			Window.setDisplayText("Você encontrou os mercenários. Lute!");
			// currentEnemy = new Enemy("Mercenários", 100, 100, 0, 2, 1);
		} else if (gameStateLvl == 4) {
			if (player.hp <= 0) {
				Inventory.setAvailable(true);
				player.hp = player.maxHp;
			} else {
				battle(currentEnemy);
			}
		} else if (gameStateLvl == 5) {
			Story.act1_2();
		} else if (gameStateLvl == 6) {
			handleUserInput(true, true);
		}
	}

	public static void secondChapter() {
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
			currentEnemy = new Enemy("Mercenários", 15, 15, 0, 1, 1);
		} else if (gameStateLvl == 7) {
			if (currentEnemy.hp == currentEnemy.maxHp && !firstBattleQuestion) {
				System.out.println("teste");
				firstBattleQuestion = true;
				
				previousGameStateAndLvl[0] = gameState;
				previousGameStateAndLvl[1] = gameStateLvl;

				gameState = 999;
				gameStateLvl = 0;
				Main.gameMap.get(999).run();
			} else if (currentEnemy.hp <= (currentEnemy.maxHp/2) && !secondBattleQuestion) {
				secondBattleQuestion = true;
				
				previousGameStateAndLvl[0] = gameState;
				previousGameStateAndLvl[1] = gameStateLvl;

				gameState = 999;
				gameStateLvl = 0;
				Main.gameMap.get(999).run();
			}

			if (player.hp <= 0) {
				gameState = 666;
				gameStateLvl = 0;
				Main.gameMap.get(666).run();
			} else if (currentEnemy.hp <= 0) {
				enemyDefeated(currentEnemy);
			} else {
				battle(currentEnemy);
			}
		} else if (gameStateLvl == 8){
			Window.displayText.setForeground(Color.BLUE);
			Window.setDisplayText("");
			player.eletronicComponents += 1;
			Window.displayText.setForeground(Color.BLACK);
		} else if (gameStateLvl == 8){
			Story.act2_8();
		} else if (gameStateLvl == 9) {
			Story.act2_9();
		} else if (gameStateLvl == 10) {
			Story.act2_10();
		} else if (gameStateLvl == 11) {
			handleUserInput(true, true);
		}
	}

	public static void thirdChapter() {
		if (gameStateLvl == 0) {
			Story.act3_1();
		} else if (gameStateLvl == 1) {
			Story.act3_2();
		} else if (gameStateLvl == 2) {
			Story.act3_3();
		} else if (gameStateLvl == 3) {
			Story.act3_4();
		} else if (gameStateLvl == 4) {
			Story.act3_5();
		} else if (gameStateLvl == 5) {
			Story.act3_6();
		} else if (gameStateLvl == 6) {
			handleUserInput(true, true);
		}
	}

	public static void fourthChapter() {
		if (gameStateLvl == 0) {
			Story.act4_1();
		} else if (gameStateLvl == 1) {
			Story.act4_2();
		} else if (gameStateLvl == 2) {
			Story.act4_3();
		} else if (gameStateLvl == 3) {
			Story.act4_4();
		} else if (gameStateLvl == 4) {
			Story.act4_5();
		} else if (gameStateLvl == 5) {
			Story.act4_6();
		} else if (gameStateLvl == 6) {
			Window.displayText.setForeground(Color.BLUE);
			Window.setDisplayText(
				"[Miyuki agora pode fazer itens para o jogador a partir dos componentes eletrônicos que você conseguir.]");
		} else if (gameStateLvl == 7) {
			Window.displayText.setForeground(Color.BLACK);
			handleUserInput(true, true);
		}
	}

	public static void fifthChapther() {
		if (gameStateLvl == 0) {
			Story.act5_1();
		} else if (gameStateLvl == 1) {
			Story.act5_2();
		} else if (gameStateLvl == 2) {
			Story.act5_3();
		} else if (gameStateLvl == 3) {
			Story.act5_4();
		} else if (gameStateLvl == 4) {
			Story.act5_5();
			currentEnemy = new Enemy("Mercenários", 10, 10, 50, 1, 1);
		} else if (gameStateLvl == 5) {
			if (player.hp <= 0) {
				gameState = 999;
				gameStateLvl = 0;
			} else if (currentEnemy.hp <= 0) {
				enemyDefeated(currentEnemy);
			} else {
				battle(currentEnemy);
			}
		} else if (gameStateLvl == 6){
			Story.act5_6();
		} else if (gameStateLvl == 7){
			Story.act5_7();
			handleUserInput(true, true);
		} 
	}

	public static void puzzle() {
		if(gameStateLvl == 0) {
			Window.setDisplayText("\nDigite a senha: ");
		} else if (gameStateLvl == 1) {
			if (Window.getUserInput().equals(password)) {
				Window.setDisplayText("Senha correta! A porta foi aberta.");
			} else {
				Window.setDisplayText("Senha incorreta. Tente novamente!");
				handleUserInput(true, false);
			}
		} else if(gameStateLvl == 2) {
			Story.act5_8();
		}
	}
		
	public static void sixthChapter() {
		if(gameStateLvl == 0) {
			Story.act6_1();
			currentEnemy = new Enemy("Mercenário", 10, 10, 0, 1, 1);
		} else if(gameStateLvl == 1) {
			if (player.hp <= 0) {
				gameState = 999;
				gameStateLvl = 0;
			} else if (currentEnemy.hp <= 0) {
				enemyDefeated(currentEnemy);
			} else {
				battle(currentEnemy);
			}
		} else if(gameStateLvl == 2) {
			Story.act6_2();
		} else if (gameStateLvl == 3) {
			Story.act6_3();
		} else if(gameStateLvl == 4) {
			Story.act6_4();
		} else if (gameStateLvl == 5) {
			Story.act6_5();
		} else if(gameStateLvl == 6) {
			Story.act6_6();
		} else if (gameStateLvl == 7) {
			Story.act6_7();
		}
	}	

	public static void seventhChapter() {
		if(gameStateLvl == 0) {
			Story.act7_1();
		} else if(gameStateLvl == 1){
			Story.act7_2();
			currentEnemy = new Enemy("Hefesto", 100, 100, 100, 2, 2);
		} else if(gameStateLvl == 1) {
			if (player.hp <= 0) {
				gameState = 999;
				gameStateLvl = 0;
			} else if (currentEnemy.hp <= 0) {
				enemyDefeated(currentEnemy);
			} else {
				battle(currentEnemy);
			}
		} else if(gameStateLvl == 2) {
			Story.act7_3();
		} else if(gameStateLvl == 3) {
			Story.act7_4();
		} else if(gameStateLvl == 4) {
			Story.act7_5();
		} else if(gameStateLvl == 5) {
			Story.act7_6();
		}
	}
}