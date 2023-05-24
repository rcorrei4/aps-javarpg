package main;

import java.util.ArrayList;

public class Player extends Character {
	public int numDefUpgrades;
	public ArrayList<String> items;
	public int eletronicComponents;

	public Player(String name, int hp, int maxHp, int xp, int atkDamage) {
		super(name, hp, maxHp, xp, atkDamage);
		// Setando upgrades para 0
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade

		this.defenseMultiplier = 1;

		items = new ArrayList<String>();
		this.eletronicComponents = 0;
	}

	@Override
	public double attack() {
		return atkDamage;
	}

	@Override
	public double increaseDefense() {
		currentDefensePoints += (defenseMultiplier - (defenseMultiplier/3)) % maxHp;
		if (defenseMultiplier <= 3) {
			defenseMultiplier ++;	
		} 
		return (defenseMultiplier-(defenseMultiplier/3)) % maxHp;
	}

	@Override
	public double increaseStrength() {
		double increase = 0.015 * atkDamage; // increase by 1.5% of atkDamage
		atkDamage += increase;
		currentAttackPoints += increase;
		return increase;

	}

	@Override
	public double increaseHp() {
		double increase = 0.01 * maxHp; // increase by 2.5% of maxHP
		currentHpPoints += increase;
		return increase;
	}

	public void removeStats() {
		currentDefensePoints = 0;
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
