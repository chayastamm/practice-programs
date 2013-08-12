package telephonePuzzle;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LettersPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private String word;
	private ArrayList<LetterButton> buttons;

	public LettersPanel(String word) {
		this.word = word;
		this.buttons = new ArrayList<LetterButton>();
		setLayout(new GridLayout(2, word.length()));
		addButtons();
	}

	public void addButtons() {
		for (int i = 0; i < word.length(); i++) {
			DisplayButton button = new DisplayButton(word.charAt(i));
			this.add(button);
		}
		for (int i = 0; i < word.length(); i++) {
			LetterButton button = new LetterButton(word.charAt(i));
			buttons.add(button);
			this.add(button);
		}
	}

	public String getWordFromButtons() {
		String word = "";
		for (int i = 0; i < buttons.size(); i++) {
			word += buttons.get(i).getText();
		}
		return word;
	}
}