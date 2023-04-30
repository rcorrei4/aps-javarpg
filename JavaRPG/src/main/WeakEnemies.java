package main;
import java.util.Random;

public class WeakEnemies extends Enemy {

    public WeakEnemies(String name, int hp, int maxHp, int xp) {
        super(name, hp, maxHp, xp);
    }

    public int numAtkUpgrades, numDefUpgrades;

    // Arrays para guardar os atributos/habilidades
    public static String[] enemieAction = { "Bomba", "Escudo", "Auto Explosão" };

    public void chooseTraitsEnemies() {
        Random random = new Random();
        int Choose = random.nextInt(3);
        if (Choose == 1) {
            System.out.println("Inimigo ataca! " + enemieAction[0]);
            GameLogic.player.hp -= 30;
            System.out.println("Você tomou 30 de dano!");
        } else if (Choose == 2) {
            System.out.println("Inimigo Defendeu! " + enemieAction[1]);
        } else {
            System.out.println("Inimigo usou Especial! " + enemieAction[2]);
            GameLogic.player.hp -= 60;
            System.out.println("Você tomou 60 de dano!");
        }

        GameLogic.anythingToContinue();
        GameLogic.clearConsole();
    }

}
