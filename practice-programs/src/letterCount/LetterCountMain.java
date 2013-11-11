package letterCount;

import javax.swing.JOptionPane;

public class LetterCountMain {

	public static void main(String[] args) {
		String text = JOptionPane.showInputDialog("Enter some text");

		LetterCounter letterCounter = new LetterCounter(text);
		JOptionPane.showMessageDialog(null, letterCounter.toString());

	}

}
