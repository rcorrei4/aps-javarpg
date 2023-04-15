public abstract class Character {
<<<<<<< HEAD
	
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
=======
	String fullname;
	int healthPoints;
	int strength;

	public abstract  void Walk();
>>>>>>> c0d7369e6ae332dcbf86dfa763ef652eabecb655
}