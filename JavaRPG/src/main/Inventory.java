package main;

import gui.Window;

import java.util.HashMap;

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
        if (Window.getUserInput().equals("1")) {
            // defesa
            double defensePoints = GameLogic.player.increaseDefense();
            System.out.println(defensePoints);
            itemMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n";
            removeItem(1);
        } else if (Window.getUserInput().equals("2")) {
            // aumenta força
            double damagePoints = GameLogic.player.increaseStrength();
            System.out.println(damagePoints);
            itemMsg += "Você usou durateston e ganhou " + damagePoints + " pontos de ataque!\n";
            removeItem(2);
        } else if (Window.getUserInput().equals("3")) {
            // uso do estimulante
            double hpPoints = GameLogic.player.increaseHp();
            System.out.println(hpPoints);
            itemMsg += "Você usou o estimulante e ganhou " + hpPoints + " de vida!\n";
            removeItem(3);
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

    public static void removeItem(int index) {
        // checking if the index is within the bounds of the array
        /*
         * if (items.cotainsKey(index)) {
         * String item = items.get(index);
         * GameLogic.player.items.remove(item);
         * items.remove(index);
         * }
         */

    }

}
