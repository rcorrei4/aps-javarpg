package main;

import gui.Window;

public class Player extends Character {

	public int numAtkUpgrades, numDefUpgrades;

	// Arrays para guardar os atributos/habilidades
	public String[] atkUpgrades = { "Arma Corporal", "Espada", "Metralhadora" };
	public String[] defUpgrades = { "Escudo", "Droga p/ aumento de força", "Estimulante" };

	public Player(String name, int hp, int maxHp, int xp, int atkDamage) {
		super(name, hp, maxHp, xp, atkDamage);
		// Setando upgrades para 0
		this.numAtkUpgrades = 0;
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade

	}

	@Override
	public int attack () {
		return atkDamage;
	}
	@Override
	public int defend () {
		return 10 % maxHp;
	}

	@Override
	public int useItem () {
		return 0;
	}

	public void chooseTrait() {
		Window.setDisplayText("Escolha uma habilidade: ");
		System.out.println("(1) " + atkUpgrades[0]);
		System.out.println("(2) " + atkUpgrades[1]);
		System.out.println("(3) " + atkUpgrades[2]);
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

	}
}
