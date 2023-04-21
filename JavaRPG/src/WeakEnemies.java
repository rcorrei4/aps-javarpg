import java.util.Random;

public class WeakEnemies extends Enemies {
    public int numAtkUpgrades, numDefUpgrades;

    // Arrays para guardar os atributos/habilidades
    public static String[] enemieAction = { "Ataque", "Defender", "Especial" };

    public WeakEnemies(String name, int maxHp, boolean shield) {
        super(name, maxHp, shield);

    }

    public void chooseTraitsEnemies() {

        Random random = new Random();
        int Choose = random.nextInt(3);
        if (Choose == 1) {
            System.out.println("Inimigo Ataca! " + enemieAction[0]);

        } else if (Choose == 2) {
            System.out.println("Inimigo Defendeu! " + enemieAction[1]);
        } else
            System.out.println("Inimigo usou Especial! " + enemieAction[2]);

        GameLogic.anythingToContinue();
        GameLogic.clearConsole();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }

    @Override
    public int skills() {
        return 0;
    }
}
