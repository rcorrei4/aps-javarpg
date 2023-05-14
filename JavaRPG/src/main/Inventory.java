package main;

import gui.Window;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public static HashMap<Integer, String> map = new HashMap<Integer, String>() {
        {
            put(1, "Escudo");
            put(2, "Droga");
            put(3, "Estimulante");
        }
    };

    public static String printInventory() {
        String inventory = "";
        for (Integer key : map.keySet()) {
            inventory += "\n" + key + ". " + map.get(key);
        }
        return inventory;
    }

    public static String chooseItem() {
        String itemMsg = "";
        String userInput = Window.getUserInput();
        int index;
        try {
            index = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return "Opção inválida!\n";
        }
        if (index < 1) {
            return "Opção inválida!\n";
        }
        if (index == 1) {
            // defesa
            double defensePoints = GameLogic.player.increaseDefense();
            System.out.println(defensePoints);
            itemMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n\n";
            removeItem("Escudo");
        } else if (index == 2) {
            // aumenta força
            double damagePoints = GameLogic.player.increaseStrength();
            System.out.println(damagePoints);
            itemMsg += "Você usou durateston e ganhou " + damagePoints + " pontos de ataque!\n";
            removeItem("Droga");
        } else if (index == 3) {
            // uso do estimulante
            double hpPoints = GameLogic.player.increaseHp();
            System.out.println(hpPoints);
            itemMsg += "Você usou o estimulante e ganhou " + hpPoints + " de vida!\n";
            removeItem("Estimulante");
        }
        return itemMsg;
    }

    public static void addEnemyItem(String droppedItem) {
        /*
         * String[] newItems = new String[items.length + 1]; // new array with the new
         * items
         * for (int i = 0; i < items.length; i++) {
         * newItems[i] = items[i];
         * }
         * newItems[newItems.length - 1] = item;
         * items = newItems;
         */

    }

    public static void addItem(Player player, String itemName) {
        player.items.add(itemName);

        Window.setDisplayText(itemName + " foi adicionado ao seu inventário!");
    }

    public static void removeItem(String itemName) {
        int index = -1;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(itemName)) {
                index = entry.getKey();
                break;
            }
        }
        if (index != -1) {
            map.remove(index);
        }
    }

}
