public abstract class Character {
	
	// Variáveis / Atributos que todos os personagens devem ter
	
	public String name;
	public int maxHp, hp, xp;
	
	// Construtor para os personagens
	public Character(String name, int maxHp, int xp) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
	}
	
	// Métodos que todos os personagens devem ter
	public abstract int attack();
	public abstract int defend();
}