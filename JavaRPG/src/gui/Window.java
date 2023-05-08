package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.GameLogic;

public class Window implements ActionListener {
	public static JFrame frame;
	public static JTextArea displayText;
	public static JTextField input;
	public static String userInput;

	public Window() {
		frame = new JFrame("JavaRPG");
		displayText = new JTextArea();
		input = new JTextField();
	}

	public void createWindow() {
		displayText.setBounds(15, 15, 450, 200);
		displayText.setWrapStyleWord(true);
		displayText.setLineWrap(true);
		displayText.setEditable(false);
		displayText.setMargin(new Insets(5, 5, 5, 5));
		frame.add(displayText);
		frame.getContentPane().setBackground(new Color(50, 50, 50));

		input.setBounds(15, 230, 450, 50);
		input.setMargin(new Insets(5, 5, 5, 5));
		input.addActionListener(this);

		frame.add(input);

		frame.setSize(500, 450);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == input) {
			userInput = input.getText();
			input.setText("");
			if (getUserInput().equals("menu")) {
				GameLogic.characterInfo();
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
