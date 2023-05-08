package main;

import gui.Window;

public class Player extends Character {

	public int numDefUpgrades;

	// Arrays para guardar os atributos/habilidades
	//public static String[] itemsAttk = { "Arma Corporal", "Espada", "Metralhadora" };
	public static String[] items = { "Escudo", "Droga p/ aumento de força", "Estimulante" };

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
		return 0;
	}

	public void removeStats() {
		currentDefensePoints = 0;
	};

	public void invetory() {
		//inventário do player
		Window.setDisplayText("Inventário:\n(1) " + items[0] + "\n(2) " + items[1] + "\n(3) " + items[2]);
		if(Window.getUserInput() != null && Window.getUserInput().equals("1")){
			//use item 1
			useItem();
		} else if (Window.getUserInput() != null && Window.getUserInput().equals("2")) {
			//use item 2
			useItem();
		} else if (Window.getUserInput() != null && Window.getUserInput().equals("3")){
			//use item 3
			useItem();
		}
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

	
