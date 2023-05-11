package main;

import java.util.Random;

public class Enemy extends Character {

    // Chances de cada ação que o inimigo pode fazer
    private static final double ATTACK_WEIGHT = 0.6;
    private static final double DEFENSE_WEIGHT = 0.3;

    // Item drop rate
    private static final double ITEM_DROP_RATE = 0.2;

    // list of possible items to drop
    private static final String[] ITEM_LIST = { "Granada", "Metralhadora kkkkkk", "Espada" };

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

    public String dropItem() {
        Random random = new Random();
        if (random.nextDouble() < ITEM_DROP_RATE) {
            int index = random.nextInt(ITEM_LIST.length);
            String droppedItem = ITEM_LIST[index];
            Inventory.addItem(droppedItem);
            return droppedItem;
        } else {
            return null;
        }
    }
}