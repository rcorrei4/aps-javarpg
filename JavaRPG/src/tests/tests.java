package tests;

import javax.swing.*;

public class tests extends JDialog {

    public tests(JFrame parent, String message) {
        super(parent, "Message", true);

        JLabel label = new JLabel(message);
        getContentPane().add(label);

        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame parent = new JFrame();
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setVisible(true);

        new tests(parent, "Hello, World!");
    }
}