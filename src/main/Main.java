package main;

import javax.swing.UIManager;
import java.awt.Font;

public class Main {

	/**
	 * @param args
	 */
	//creates a new game and sets the game font to courier because it is monospace
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new Font("Courier", Font.BOLD, 14));
		View j = new View();

	}

}
