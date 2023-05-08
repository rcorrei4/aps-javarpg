package main;
public abstract class Character {

	// Variáveis / Atributos que todos os personagens devem ter

	public String name;
	public int maxHp;
	public int hp;
	public int xp;
	public double atkDamage;
	public double currentDefensePoints;
	public double currentAttackPoints;

	// Construtor para os personagens
	public Character(String name, int hp, int maxHp, int xp, double atkDamage) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
		this.atkDamage = atkDamage;
		this.currentDefensePoints = 0;
		this.currentAttackPoints = 0;
	}

	// Métodos que todos os personagens devem ter
	public abstract double attack();
	public abstract double increaseDefense();
	public abstract double increaseStrength();
	public abstract double increaseHp();
	public abstract int useItem();

}