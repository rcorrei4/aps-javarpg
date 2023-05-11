package main;

import gui.Window;

public class Inventory {

    public static String[] items = { "(1) Escudo", "(2) Droga p/ aumento de força", "(3) Estimulante\n" };

    public static void printInventory() {
        String inventory = "";
        for (int i = 0; i < items.length; i++) {
            inventory += "\n" + items[i];
        }
        Window.setDisplayText(inventory);
    }

    public static void chooseItem() {
        String itemMsg = "";
        if (Window.getUserInput().equals("1")) {
            // defesa
            double defensePoints = GameLogic.player.increaseDefense();
            System.out.println(defensePoints);
            itemMsg += "Você usou o escudo e ganhou " + defensePoints + " pontos de defesa!\n";
            removeItem(0);
        } else if (Window.getUserInput().equals("2")) {
            // aumenta força
            double damagePoints = GameLogic.player.increaseStrength();
            System.out.println(damagePoints);
            itemMsg += "Você usou durateston e ganhou " + damagePoints + " pontos de ataque!\n";
            removeItem(1);
        } else if (Window.getUserInput().equals("3")) {
            // uso do estimulante
            double hpPoints = GameLogic.player.increaseHp();
            System.out.println(hpPoints);
            itemMsg += "Você usou o estimulante e ganhou " + hpPoints + " de vida!\n";
            removeItem(2);
        } else if (Window.getUserInput().equals("4")) {
            Window.setDisplayText("Qual item você deseja remover?");
            int index = Integer.parseInt(Window.getUserInput()) - 1;
            removeItem(index);
            return;
        }
        Window.setDisplayText(itemMsg);
    }

    public static void addItem(String item) {
        String[] newItems = new String[items.length + 1]; // new array with the new items
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        newItems[newItems.length - 1] = item;
        items = newItems;
        Window.setDisplayText(item + " foi adicionado ao seu inventário!");
    }

    public static void removeItem(int index) {
        // checking if the index is within the bounds of the array
        if (index >= 0 && index < items.length) {
            String removedItem = items[index]; // adding in a removed items string
            String[] newItems = new String[items.length - 1]; // string with the item removed
            int j = 0;
            for (int i = 0; i < items.length; i++) {
                if (i != index) {
                    newItems[j] = items[i];
                    j++;
                }
            }
            items = newItems;
            Window.setDisplayText(removedItem + " foi removido do inventário!");
        } else {
            Window.setDisplayText("O item selecionado não existe!");
        }
    }

}
