package main;

import java.util.Random;

public class Enemy extends Character {
    private Random random;

    public Enemy(String name, int hp, int maxHp, int xp, int atkDamage) {
        super(name, hp, maxHp, xp, atkDamage);
        random = new Random();
    }

    public int randomAction () {
       int action = random.nextInt(3);
       if(action == 0) {
            return attack();
       } else if (action == 1) {
            return defend();
       } else {
            return useItem();
       }
    }

    @Override
    public int attack () {
        return atkDamage;
    }

    @Override
    public int defend () {
        return 1;
    }

    @Override
    public int useItem () {
        return 2;
    }
}