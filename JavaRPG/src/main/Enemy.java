package main;
public class Enemy extends Character {
    public Enemy(String name, int hp, int maxHp, int xp) {
        super(name, hp, maxHp, xp);
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

}