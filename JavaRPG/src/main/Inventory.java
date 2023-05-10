package main;

import gui.Window;

public class Inventory {

    public static String[] items = { "Escudo", "Droga p/ aumento de força", "Estimulante" };

    public static void printInventory() {
        String inventory = "";
        for (int i = 0; i < items.length; i++) {
            inventory += "\n" + items[i];
        }
        Window.setDisplayText(inventory);
        if (Window.getUserInput().equals("1")) {
            // defesa
            double defensePoints = GameLogic.player.increaseDefense();
            System.out.println(defensePoints);
            inventory += "Voc^usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n";
        } else if (Window.getUserInput().equals("2")) {
            // aumenta força
            double damagePoints = GameLogic.player.increaseStrength();
            System.out.println(damagePoints);
            inventory += "Você usou o tal e ganhou " + damagePoints + " pontos de ataque!\n";
        } else if (Window.getUserInput().equals("3")) {
            // uso do estimulante
            double hpPoints = GameLogic.player.increaseHp();
            System.out.println(hpPoints);
            inventory += "Você usou o estimulante e ganhou " + hpPoints + " de vida!\n";
        }
    }

    public void removeItem() {

    }

}
