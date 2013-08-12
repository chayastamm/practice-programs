package hangman;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class WordPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private String word;
	private JButton[] buttons;
	private int lettersFound;

	public WordPanel(String word) {
		this.word = word;
		this.setButtons(new JButton[word.length()]);
		this.lettersFound = 0;
		setSize(500, 400);
		setLayout(new GridLayout(3, 1));
		setBorder();
		fillWithButtons();
	}

	public void setBorder() {
		TitledBorder border = new TitledBorder("Word is:");
		border.setTitleColor(Color.BLUE);
		this.setBorder(border);
	}

	public void fillWithButtons() {
		JPanel panel = new JPanel(new GridLayout(1, word.length()));
		panel.setSize(500, 300);
		for (int i = 0; i < word.length(); i++) {
			JButton button = new JButton();
			button.setEnabled(false);
			button.setAlignmentX(0);
			buttons[i] = button;
			panel.add(button);
		}
		this.add(new JPanel());
		this.add(panel);
		this.add(new JPanel());
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void pressButtons(char letter) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				Font font = new Font("Arial", 1, 22);
				buttons[i].setFont(font);
				buttons[i].setText(letter + "");
				lettersFound++;
			}
		}
	}

	public boolean won() {
		return (lettersFound == word.length());
	}
}
