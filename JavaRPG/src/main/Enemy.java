package main;

public class Enemy extends Character {

    // Chances de cada ação que o inimigo pode fazer
    private static final double ATTACK_WEIGHT = 0.6;
    private static final double DEFENSE_WEIGHT = 0.3;

    public Enemy(String name, int hp, int maxHp, int xp, double atkDamage) {
        super(name, hp, maxHp, xp, atkDamage);
    }

    public int randomAction() {
        double rand = Math.random();
        if (rand < ATTACK_WEIGHT) {
            return 1;
        } else if (rand < ATTACK_WEIGHT + DEFENSE_WEIGHT) {
            return 2;
        } else {
            return 3;
        }
    }

    @Override
    public double attack() {
        return atkDamage;
    }

    @Override
    public double increaseDefense() {
        currentDefensePoints += 5 % maxHp;
        return 1 % maxHp;
    }

    @Override
    public double increaseStrength() {

        return 0;
    }

    @Override
    public double increaseHp() {
        return 0;
    }
}