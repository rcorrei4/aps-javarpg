package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.GameLogic;
import main.Inventory;

public class Window implements ActionListener {
	public static JFrame frame;
	public static JTextArea displayText;
	public static JTextField input;
	public static String userInput;
	public static boolean isChoosingItem = false;

	public Window() {
		frame = new JFrame("JavaRPG");
		displayText = new JTextArea();
		input = new JTextField();
	}

	public void createWindow() {
		displayText.setBounds(15, 15, 450, 280);
		displayText.setWrapStyleWord(true);
		displayText.setLineWrap(true);
		displayText.setEditable(false);
		displayText.setMargin(new Insets(5, 5, 5, 5));
		frame.add(displayText);
		frame.getContentPane().setBackground(new Color(50, 50, 50));

		input.setBounds(15, 300, 450, 50);
		input.setMargin(new Insets(5, 5, 5, 5));
		input.addActionListener(this);

		frame.add(input);

		frame.setResizable(false);
		frame.setSize(500, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			userInput = input.getText();
			input.setText("");

			if (getUserInput().equals("menu")) {
				GameLogic.characterInfo();
			} else if (getUserInput().equals("tutorial")) {
				GameLogic.tutorial();
			} else if (getUserInput().equals("i")) {
				Window.setDisplayText(Inventory.printInventory());
				isChoosingItem = true;
			} else if (isChoosingItem) {
				Window.setDisplayText(Inventory.chooseItem());
				isChoosingItem = false;
			} else if (getUserInput().equals("save")) {
				GameLogic.saveWriter();
				Window.setDisplayText("Jogo salvo com sucesso");
			} else if (getUserInput().equals("load")){
				GameLogic.loadData();
			} else {
				GameLogic.handleUserInput();
			}
		}

		input.requestFocus();
	}

	// Add typewriter effect later
	public static void setDisplayText(String text) {
		displayText.setText(text);
	}

	public static String getUserInput() {
		return userInput;
	}

}
