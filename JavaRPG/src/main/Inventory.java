package main;

import gui.Window;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static boolean isAvailable = true;

    public static HashMap<Integer, String> inventory = new HashMap<Integer, String>() {
        {
            put(1, "Escudo");
            put(2, "Êxtase de Éter");
            put(3, "Estimulante");
            //put(4, "Mega Ímã");
            //put(5, "Flipper Zero");

        }
    };

    public static void setAvailable(boolean value) {
        isAvailable = value;
    }

    public static String printInventory() {
        if (!isAvailable) {
            return "O inventário não está disponível no momento.";
        } else if (inventory.isEmpty()) {
            return "Você não possui itens no inventário.";
        } else {
            StringBuilder inventoryBuilder = new StringBuilder();
            for (Map.Entry<Integer, String> entry : inventory.entrySet()) {
                inventoryBuilder.append("\n").append(entry.getKey()).append(". ").append(entry.getValue());
            }
            return inventoryBuilder.toString();
        }
    }

    public static String chooseItem() {
        if (isAvailable) {
            String itemMsg = "";
            String userInput = Window.getUserInput();
            int index;
            try {
                index = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                return "Opção inválida!\n";
            }
            if (inventory.containsKey(index)) {
                if (index == 1) {
                    // defesa
                    double defensePoints = GameLogic.player.increaseDefense();
                    itemMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n\n";
                    removeItem(1);
                } else if (index == 2) {
                    // aumenta força
                    double damagePoints = GameLogic.player.increaseStrength();
                    itemMsg += "Você usou êxtase de éter e ganhou " + damagePoints + " pontos de ataque!\n";
                    removeItem(2);
                } else if (index == 3) {
                    // uso do estimulante
                    double hpPoints = GameLogic.player.increaseHp();
                    itemMsg += "\nVocê usou o estimulante e ganhou " + hpPoints + " de vida!\n";
                    removeItem(3);
                } else if (index == 4) {
                    // uso do estimulante
                    GameLogic.currentEnemy.hp -= GameLogic.player.atkDamage * 3;
                    itemMsg += "\nVocê usou o mega ímã causando "+ GameLogic.player.atkDamage * 3 +"\n";
                    removeItem(4);
                } else if (index == 5) {
                    // uso do estimulante
                    GameLogic.currentEnemy.currentDefensePoints = 0;
                    itemMsg += "\nVocê usou o flipper zero e removeu totalmente as defesas do inimigo\n";
                    removeItem(5);
                } else {
                    return "Opção inválida!\n";
                }
            } else {
                return "Opção inválida!\n";
            }
            return itemMsg;
        } else {
            return "";
        }
    }

    public static String addEnemyItem(String droppedItem) {
        // generate a unique index for the new item

        String enemyItemMsg = "";       

        int newIndex = inventory.size() + 1;

        // add the item to the Inventory map
        inventory.put(newIndex, droppedItem);

        // display a message
        enemyItemMsg += droppedItem + " foi adicionado ao seu inventário!";

        return enemyItemMsg;

    }



    public static void removeItem(int index) {
        inventory.remove(index);

    }
}
