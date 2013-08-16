package memory;

import javax.swing.JOptionPane;

public class MemoryMain {

	public static void main(String[] args) {
		String options = "Do you want to play an easy, medium, or hard game? ";
		options += "Enter 1, 2, or 3. Default is hard.";
		String input = JOptionPane.showInputDialog(null, options);
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			number = 3;
		}
		if (number == 1) {
			number = 4;
		} else if (number == 2) {
			number = 6;
		} else {
			number = 8;
		}
		MemoryFrame memory = new MemoryFrame(number);

	}
}
