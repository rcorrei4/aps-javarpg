package main;

import java.util.Random;

public class Enemy extends Character {
    private Random random;

    public Enemy(String name, int hp, int maxHp, int xp, double atkDamage) {
        super(name, hp, maxHp, xp, atkDamage);
        random = new Random();
    }

    public int randomAction () {
       int action = random.nextInt(3);
       if(action == 0) {
            return 1;
       } else if (action == 1) {
            return 2;
       } else {
            return 3;
       }
    }

    @Override
    public double attack () {
        return atkDamage;
    }

    @Override
    public double increaseDefense () {
        currentDefensePoints += 5 % maxHp;
        return 1 % maxHp;
    }

    @Override
    public int useItem () {
        return 0;
    }
}