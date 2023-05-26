package main;

import java.util.ArrayList;

public class Player extends Character {
	public int numDefUpgrades;
	public ArrayList<String> items;
	public int eletronicComponents;
	public boolean tripleDamage;

	public Player(String name, int hp, int maxHp, int xp, int atkDamage) {
		super(name, hp, maxHp, xp, atkDamage);
		// Setando upgrades para 0
		this.numDefUpgrades = 0;
		// O jogador pode escolher uma habilidade

		items = new ArrayList<String>();
		this.eletronicComponents = 0;
	}

	@Override
	public double attack() {
		return atkDamage;
	}

	@Override
	public double increaseDefense() {
		defenseCount++;
		currentDefensePoints += 2 % maxHp;

		return (2 % maxHp);
	}

	@Override
	public double increaseStrength() {
		double increase = 20; 
		atkDamage += increase;
		return increase;

	}

	@Override
	public double increaseHp() {
		double increase = 50;
		maxHp += increase;
		hp += increase;
		return increase;
	}

	public void removeStats() {
		currentDefensePoints = 0;
	}

}