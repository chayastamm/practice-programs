package mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MastermindFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ColorButton[][] colorButtons;
	private ArrayList<Color> colors;
	private JButton goButton;
	private ColorButton[] lastRow;
	private AnswerPanel[] answerPanels;
	private int currentRow;

	public MastermindFrame() {
		setSize(450, 990);
		setTitle("Mastermind");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new GridLayout(11, 5));
		setColors();
		addButtons();
		setVisible(true);
	}

	public void reset() {
		this.dispose();
		new MastermindFrame();
	}

	public void addGoButton() {
		goButton = new JButton();
		goButton.setText("Go!");
		goButton.setBackground(Color.GREEN);
		goButton.addMouseListener(new GoListener());
		goButton.setMargin(new Insets(0, 0, 0, 0));
		this.add(goButton);
	}

	public void addButtons() {
		colorButtons = new ColorButton[11][4];
		answerPanels = new AnswerPanel[10];
		currentRow = 10;
		for (int i = 0; i < 11; i++) {
			if (i != 0) {
				AnswerPanel answerPanel = new AnswerPanel();
				answerPanels[i - 1] = answerPanel;
				this.add(answerPanel);
			} else {
				addGoButton();
			}
			for (int j = 0; j < 4; j++) {
				ColorButton colorButton = new ColorButton();
				colorButton.setEnabled(false);
				this.add(colorButton);
				colorButtons[i][j] = colorButton;
				if (i == 0) {
					setButtonInLastRow(colorButton, j);
				} else if (i == currentRow) {
					colorButton.addMouseListener(new ButtonListener());
				} else {
					colorButton.setEnabled(false);
				}
			}
		}
	}

	public void setButtonInLastRow(ColorButton button, int j) {
		lastRow = new ColorButton[4];
		lastRow[j] = button;
		button.setColor(colors.remove(0));
		button.hide();
	}

	public void changeGoButton() {
		if (goButton.getText().compareTo("Go!") == 0) {
			goButton.setText("New game?");
		} else {
			goButton.setText("Go!");
		}
	}

	public void revealLastRow() {
		for (int i = 0; i < 4; i++) {
			colorButtons[0][i].unhide();
		}
	}

	private void setColors() {
		colors = new ArrayList<Color>();
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.CYAN);
		colors.add(Color.BLUE);
		colors.add(Color.MAGENTA);
		colors.add(Color.PINK);
		Collections.shuffle(colors);
	}

	private class GoListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (goButton.getText().compareTo("Go!") != 0) {
				reset();
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
			if (colorButtons[currentRow][0].getColor() != Color.WHITE
					&& colorButtons[currentRow][1].getColor() != Color.WHITE
					&& colorButtons[currentRow][2].getColor() != Color.WHITE
					&& colorButtons[currentRow][3].getColor() != Color.WHITE) {
				try {
					if (!getAnswer()) {
						setNextRow();
					} else {
						revealLastRow();
						changeGoButton();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * This method loops through the current row, removes the mouselistener
		 * from each button,and checks if any of the colors match exactly. If
		 * they do, the int black is incremented, and the color is added to a
		 * list of colors already found to match. Then the row is looped through
		 * again to check for colors that match but are in the wrong places. If
		 * any exits, the int white is incremented, and the color is added to a
		 * list of colors already found to match.
		 */
		public boolean getAnswer() throws InterruptedException {
			int black = 0;
			int white = 0;
			ArrayList<Color> usedColors = new ArrayList<Color>();
			for (int i = 0; i < 4; i++) {
				for (MouseListener ml : colorButtons[currentRow][i]
						.getMouseListeners()) {
					colorButtons[currentRow][i].removeMouseListener(ml);
				}
				if (colorButtons[currentRow][i].getColor() == colorButtons[0][i]
						.getColor()
						&& !usedColors.contains(colorButtons[currentRow][i]
								.getColor())) {
					black++;
					usedColors.add(colorButtons[currentRow][i].getColor());
				}
			}
			for (int i = 0; i < 4; i++) {
				if ((colorButtons[currentRow][i].getColor() == colorButtons[0][0]
						.getColor()
						|| colorButtons[currentRow][i].getColor() == colorButtons[0][1]
								.getColor()
						|| colorButtons[currentRow][i].getColor() == colorButtons[0][2]
								.getColor() || colorButtons[currentRow][i]
						.getColor() == colorButtons[0][3].getColor())
						&& !usedColors.contains(colorButtons[currentRow][i]
								.getColor())) {
					white++;
					usedColors.add(colorButtons[currentRow][i].getColor());
				}
			}
			answerPanels[--currentRow].setColorList(black, white);
			if (black == 4) {
				JOptionPane.showMessageDialog(null, "You won!");
				return true;
			} else if (currentRow == 0) {
				JOptionPane.showMessageDialog(null, "You lost!");
				return true;
			} else {
				return false;
			}
		}

		public void setNextRow() {
			for (int i = 0; i < 4; i++) {
				colorButtons[currentRow][i].setEnabled(true);
				colorButtons[currentRow][i]
						.addMouseListener(new ButtonListener());
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}
}
