package telephonePuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class DisplayButton extends JButton {

	private static final long serialVersionUID = 1L;
	private String letters;
	private Character correctLetter;
	private JLabel numberLabel;

	public DisplayButton(Character correctLetter) {
		setMargin(new Insets(0, 0, 0, 0));
		setBorder(new LineBorder(Color.MAGENTA, 5, false));
		setLayout(new GridLayout(2, 1));
		setEnabled(false);
		this.letters = "";
		this.correctLetter = correctLetter;
		setUpNumberLabel();
		setUpLettersLabel();
	}

	public void setUpNumberLabel(){
		numberLabel = new JLabel();
		numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberLabel.setFont(new Font("Arial", 1, 15));
		setList();
		this.add(numberLabel);
	}
	
	public void setUpLettersLabel() {
		JLabel lettersLabel = new JLabel(letters);
		lettersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lettersLabel.setFont(new Font("Arial", 1, 15));
		this.add(lettersLabel);
	}
	
	public void setList() {
		switch (correctLetter) {
		case 'a':
		case 'b':
		case 'c':
			numberLabel.setText(2 + "");
			letters += 'a';
			letters += 'b';
			letters += 'c';
			break;
		case 'd':
		case 'e':
		case 'f':
			numberLabel.setText(3 + "");
			letters += 'd';
			letters += 'e';
			letters += 'f';
			break;
		case 'g':
		case 'h':
		case 'i':
			numberLabel.setText(4 + "");
			letters += 'g';
			letters += 'h';
			letters += 'i';
			break;
		case 'j':
		case 'k':
		case 'l':
			numberLabel.setText(5 + "");
			letters += 'j';
			letters += 'k';
			letters += 'l';
			break;
		case 'm':
		case 'n':
		case 'o':
			numberLabel.setText(6 + "");
			letters += 'm';
			letters += 'n';
			letters += 'o';
			break;
		case 'p':
		case 'q':
		case 'r':
		case 's':
			numberLabel.setText(7 + "");
			letters += 'p';
			letters += 'q';
			letters += 'r';
			letters += 's';
			break;
		case 't':
		case 'u':
		case 'v':
			numberLabel.setText(8 + "");
			letters += 't';
			letters += 'u';
			letters += 'v';
			break;
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			numberLabel.setText(9 + "");
			letters += 'w';
			letters += 'x';
			letters += 'y';
			letters += 'z';
			break;
		}
	}
}
