package main;

import gui.Window;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static boolean isAvailable = true;

    public static HashMap<Integer, String> inventario = new HashMap<Integer, String>() {
        {
            put(1, "Escudo");
            put(2, "Droga");
            put(3, "Estimulante");
        }
    };

    public static void setAvailable(boolean value) {
        isAvailable = value;
    }

    public static String printInventory() {
        if (!isAvailable) {
            return "O inventário não está disponível no momento.";
        } else if (inventario.isEmpty()) {
            return "Você não possui itens no inventário.";
        } else {
            StringBuilder inventory = new StringBuilder();
            for (Map.Entry<Integer, String> entry : inventario.entrySet()) {
                inventory.append("\n").append(entry.getKey()).append(". ").append(entry.getValue());
            }
            return inventory.toString();
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
            if (inventario.containsKey(index)) {
                if (index == 1) {
                    // defesa
                    double defensePoints = GameLogic.player.increaseDefense();
                    System.out.println(defensePoints);
                    itemMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n\n";
                    removeItem(1);
                } else if (index == 2) {
                    // aumenta força
                    double damagePoints = GameLogic.player.increaseStrength();
                    System.out.println(damagePoints);
                    itemMsg += "Você usou durateston e ganhou " + damagePoints + " pontos de ataque!\n";
                    removeItem(2);
                } else if (index == 3) {
                    // uso do estimulante
                    double hpPoints = GameLogic.player.increaseHp();
                    System.out.println(hpPoints);
                    itemMsg += "\nVocê usou o estimulante e ganhou " + hpPoints + " de vida!\n";
                    removeItem(3);
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

    public static void addItem(Player player, String itemName) {
        player.items.add(itemName);

        Window.setDisplayText(itemName + " foi adicionado ao seu inventário!");
    }

    public static String addEnemyItem(String droppedItem) {
        // generate a unique index for the new item

        String enemyItemMsg = "";       

        int newIndex = inventario.size() + 1;

        // add the item to the Inventory map
        inventario.put(newIndex, droppedItem);

        // display a message
        enemyItemMsg += droppedItem + " foi adicionado ao seu inventário!";

        return enemyItemMsg;

    }



    public static void removeItem(int index) {
        inventario.remove(index);

    }
}
