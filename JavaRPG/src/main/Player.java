package main;

import gui.Window;

public class Player extends Character {

	public int numDefUpgrades;
	// Arrays para guardar os atributos/habilidades
	//public static String[] itemsAttk = { "Arma Corporal", "Espada", "Metralhadora" };
	public static String[] items = { "Escudo", "Droga p/ aumento de força", "Estimulante" };
										//0      //1 							//2
	public Player(String name, int hp, int maxHp, int xp, int atkDamage) {
		super(name, hp, maxHp, xp, atkDamage);
		// Setando upgrades para 0
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade

	}

	@Override
	public double attack () {
		return atkDamage;
	}
	@Override
	public double increaseDefense () {
		currentDefensePoints += 1.5 % maxHp;
		return 1.5 % maxHp;
	}

	@Override
	public int useItem() {
		String inventoryMsg = "";

		for(int i = 0; i < items.length; i++){
			if(items[i].equals(0)){
				//defesa
				double defensePoints = GameLogic.player.increaseDefense();
				System.out.println(defensePoints);
				inventoryMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n";				
			} else if(items[i].equals(1)){
				//aumenta força
				increaseStrength();
				double damagePoints = GameLogic.player.increaseStrength();
				System.out.println(damagePoints);
				inventoryMsg += "Você usou o tal e ganhou " + damagePoints + "pontos de ataque!\n"; 
			} else if(items[i].equals(2)){
				//estimulante
				increaseHp();
			}
		}

		return 0;
	}

	@Override
	public double increaseStrength () {
		atkDamage =+ atkDamage;
		
		return 0;
	}

	@Override
	public double increaseHp() {
		return 0;
	}



	public void removeStats() {
		currentDefensePoints = 0;
	};

	

	public static void printInvetory() {
		String inventory = "";
		for (int i = 0; i < items.length; i++) {
			inventory += "\n" + items[i];
		}
		Window.setDisplayText(inventory);
	
	} 
}
		/*
		 * int input = Window.getUserInput("-> ", 3);
		 * 
		 * // lidando com os casos
		 * if (input == 1) {
		 * Window.setDisplayText("Você escolheu: " + atkUpgrades[0] + "!");
		 * 
		 * } else if (input == 2) {
		 * Window.setDisplayText("Você escolheu: " + atkUpgrades[1] + "!");
		 * numDefUpgrades++;
		 * } else if (input == 3) {
		 * Window.setDisplayText("Você escolheu: " + atkUpgrades[2] + "!");
		 * numDefUpgrades++;
		 * }
		 */

	
