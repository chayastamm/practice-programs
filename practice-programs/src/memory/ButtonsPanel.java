package memory;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int numRowsCols;
	private ArrayList<MemoryButton> buttons;
	private MemoryButton clickedButton;

	public ButtonsPanel(int numRowsCols) {
		this.numRowsCols = numRowsCols;
		clickedButton = null;
		setLayout(new GridLayout(numRowsCols, numRowsCols));
		addButtons();
	}

	public void addButtons() {
		buttons = new ArrayList<MemoryButton>();
		if (numRowsCols == 4) {
			makeButtons(Color.BLUE, 40);
			makeButtons(Color.GREEN, 40);
		} else if (numRowsCols == 6) {
			makeButtons(Color.BLUE, 25);
			makeButtons(Color.GREEN, 25);
			makeButtons(Color.MAGENTA, 25);
		} else {
			makeButtons(Color.BLUE, 20);
			makeButtons(Color.GREEN, 20);
			makeButtons(Color.MAGENTA, 20);
			makeButtons(Color.YELLOW, 20);
		}
		Collections.shuffle(buttons);
		for (int i = 0; i < buttons.size(); i++) {
			add(buttons.get(i));
		}
	}

	public void makeButtons(Color color, int fontSize) {
		for (int i = 1; i < numRowsCols + 1; i++) {
			MemoryButton memoryButton1 = new MemoryButton(i, color, fontSize);
			MemoryButton memoryButton2 = new MemoryButton(i, color, fontSize);
			buttons.add(memoryButton1);
			buttons.add(memoryButton2);
			memoryButton1.addMouseListener(new ButtonListener());
			memoryButton2.addMouseListener(new ButtonListener());
		}
	}

	public boolean checkMatching(MemoryButton button) {
		if (button.getColor() == clickedButton.getColor()) {
			if (button.getNumber() == clickedButton.getNumber()) {
				return true;
			}
		}
		return false;
	}

	public void reveal() {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setPressed();
		}
	}

	public boolean checkWin() {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).getText().compareTo("Memory") == 0) {
				return false;
			}
		}
		return true;
	}

	private class ButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			MemoryButton button = (MemoryButton) arg0.getSource();
			if (!button.isPressed()) {
				button.setPressed();
				if (clickedButton == null) {
					clickedButton = button;
				} else if (!button.equals(clickedButton)) {
					if (checkMatching(button)) {
						JOptionPane.showMessageDialog(null,
								"You found a match!");
					} else {
						JOptionPane.showMessageDialog(null, "Not a match!");
						button.setUnpressed();
						clickedButton.setUnpressed();
					}
					clickedButton = null;
				}
				if (checkWin()) {
					JOptionPane.showMessageDialog(null,
							"You found all the matches!");
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}

}
