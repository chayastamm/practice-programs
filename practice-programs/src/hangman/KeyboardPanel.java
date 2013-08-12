package hangman;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class KeyboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private WordBag wordBag;
	private WordPanel wordPanel;
	private ManControlPanel manControlPanel;
	private JPanel keys;
	private String word;
	private JButton[] letters;
	private JPanel combo;

	public KeyboardPanel(int length) throws FileNotFoundException {
		this.wordBag = new WordBag(length);
		this.word = wordBag.getWord();
		this.wordPanel = new WordPanel(word);
		this.manControlPanel = new ManControlPanel();
		this.letters = new JButton[26];
		setSize(1000, 800);
		setLayout(new GridLayout(2, 1));
		setUpCombo();
		setUpKeys();
		this.addKeyListener(new KeyboardListen());
		this.setFocusable(true);
	}

	public void reset() throws FileNotFoundException {
		this.removeAll();
		this.word = wordBag.getWord();
		this.wordPanel = new WordPanel(word);
		this.manControlPanel = new ManControlPanel();
		this.letters = new JButton[26];
		setSize(1000, 800);
		setLayout(new GridLayout(2, 1));
		setUpCombo();
		setUpKeys();
		revalidate();
	}

	public void setUpCombo() {
		combo = new JPanel();
		combo.setSize(1000, 800);
		combo.add(wordPanel);
		combo.add(manControlPanel);
		combo.setLayout(new GridLayout(1, 2));
		this.add(combo);
	}

	public void setUpKeys() {
		this.keys = new JPanel();
		keys.setSize(1000, 400);
		keys.setLayout(new GridLayout(3, 8));
		for (int i = 0; i < 26; i++) {
			JButton button = new JButton();
			letters[i] = button;
			char letter = (char) (i + 97);
			Font font = new Font("Arial", 1, 30);
			button.setFont(font);
			button.setText("" + letter);
			button.setEnabled(true);
			button.addMouseListener(new MouseListen());
			keys.add(button);
		}
		this.add(keys);

	}

	private class KeyboardListen implements KeyListener {
		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			char userChoice = arg0.getKeyChar();
			try {
				letters[userChoice - 97].setEnabled(false);
				if (word.contains(userChoice + "")) {
					wordPanel.pressButtons(userChoice);
					if (wordPanel.won()) {
						try {
							JOptionPane.showMessageDialog(null,
									"Great, you won! Word was " + word);
							reset();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				} else {
					manControlPanel.registerMistake();
					if (manControlPanel.getChancesLeft() == 0) {
						try {
							JOptionPane.showMessageDialog(null,
									"Sorry, you lost! Word was " + word);
							reset();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				//ignore
			}

			
		}
	}

	private class MouseListen implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			JButton userChoice = (JButton) arg0.getSource();
			userChoice.setEnabled(false);
			if (word.contains(userChoice.getText())) {
				wordPanel.pressButtons(userChoice.getText().charAt(0));
				if (wordPanel.won()) {
					try {
						JOptionPane.showMessageDialog(null,
								"Great, you won! Word was " + word);
						reset();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			} else {
				manControlPanel.registerMistake();
				if (manControlPanel.getChancesLeft() == 0) {
					try {
						JOptionPane.showMessageDialog(null,
								"Sorry, you lost! Word was " + word);
						reset();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}
}
