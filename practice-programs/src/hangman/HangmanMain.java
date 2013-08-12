package hangman;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class HangmanMain {

	public static void main(String[] args) throws FileNotFoundException {
		int num = 0;
		do {
			String input = JOptionPane
					.showInputDialog(null,
							"How long do you want the words to be? Enter a number from 2-13");
			num = Integer.parseInt(input);
		} while (num < 2 || num > 13);
		HangmanFrame hangman = new HangmanFrame(num);
	}
}
