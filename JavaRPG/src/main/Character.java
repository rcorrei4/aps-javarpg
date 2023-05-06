package main;
public abstract class Character {

	// Variáveis / Atributos que todos os personagens devem ter

	public String name;
	public int maxHp;
	public int hp;
	public int xp;
	public int atkDamage;

	// Construtor para os personagens
	public Character(String name, int hp, int maxHp, int xp, int atkDamage) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
		this.atkDamage = atkDamage;
	}

	// Métodos que todos os personagens devem ter
	public abstract int attack();
	public abstract int defend();
	public abstract int useItem();

}