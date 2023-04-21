public abstract class Enemies {
    public String name;
    public int maxHp, hp;
    public boolean shield;

    // Construtor para os inimigos
    public Enemies(String name, int maxHp, boolean shield) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.shield = shield;

    }

    // Métodos que todos os inimigos devem ter
    public abstract int attack();

    public abstract int defend();

    public abstract int skills();

    public abstract void chooseTraitsEnemies();
}
