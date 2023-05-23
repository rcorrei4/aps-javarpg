package tests;

import javax.swing.*;
import java.util.HashMap;

public class tests extends JDialog {
    public static void main(String[] args) {
        HashMap<Integer, String> inventario = new HashMap<Integer, String>() {
            {
                put(1, "Escudo");
                put(2, "Droga");
                put(3, "Estimulante");
            }
        };

        inventario.remove(1);
        inventario.remove(1);
    }
    
}