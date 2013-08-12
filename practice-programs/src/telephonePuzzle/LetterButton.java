package telephonePuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class LetterButton extends JButton {

	private static final long serialVersionUID = 1L;

	private ArrayList<Character> possibleLetters;
	private Character correctLetter;
	private int upTo;

	public LetterButton(Character correctLetter) {
		setFont(new Font("Arial", 1, 22));
		setMargin(new Insets(0, 0, 0, 0));
		addMouseListener(new ButtonListener());
		setBorder(new LineBorder(Color.ORANGE, 5, false));
		this.possibleLetters = new ArrayList<Character>();
		this.correctLetter = correctLetter;
		this.upTo = 0;
		//until user clicks, set text to placeholder
		this.setText("???");
		setList();
	}

	public void setList() {
		switch (correctLetter) {
		case 'a':
		case 'b':
		case 'c':
			possibleLetters.add('a');
			possibleLetters.add('b');
			possibleLetters.add('c');
			break;
		case 'd':
		case 'e':
		case 'f':
			possibleLetters.add('d');
			possibleLetters.add('e');
			possibleLetters.add('f');
			break;
		case 'g':
		case 'h':
		case 'i':
			possibleLetters.add('g');
			possibleLetters.add('h');
			possibleLetters.add('i');
			break;
		case 'j':
		case 'k':
		case 'l':
			possibleLetters.add('j');
			possibleLetters.add('k');
			possibleLetters.add('l');
			break;
		case 'm':
		case 'n':
		case 'o':
			possibleLetters.add('m');
			possibleLetters.add('n');
			possibleLetters.add('o');
			break;
		case 'p':
		case 'q':
		case 'r':
		case 's':
			possibleLetters.add('p');
			possibleLetters.add('q');
			possibleLetters.add('r');
			possibleLetters.add('s');
			break;
		case 't':
		case 'u':
		case 'v':
			possibleLetters.add('t');
			possibleLetters.add('u');
			possibleLetters.add('v');
			break;
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			possibleLetters.add('w');
			possibleLetters.add('x');
			possibleLetters.add('y');
			possibleLetters.add('z');
			break;
		}
	}

	public void getNextLetter() {
		if (upTo == possibleLetters.size()) {
			//go back to the beginning
			upTo = 0;
		}
		this.setText(possibleLetters.get(upTo) + "");
		upTo++;
	}

	private class ButtonListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			getNextLetter();
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
