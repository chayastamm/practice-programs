package memory;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class MemoryButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Color color;
	private int number;

	public MemoryButton(int number, Color color, int fontSize) {
		this.setColor(color);
		this.setNumber(number);
		this.setBorder(new LineBorder(Color.PINK, 5, true));
		this.setBackground(Color.RED);
		this.setFont(new Font("Tahoma", 1, fontSize));
		this.setText("Memory");
	}

	public void setPressed() {
		this.setEnabled(false);
		this.setBackground(color);
		this.setText(number + "");
	}

	public void setUnpressed() {
		this.setEnabled(true);
		this.setBackground(Color.RED);
		this.setText("Memory");
	}

	public boolean isPressed() {
		if (this.getText().compareTo("Memory") == 0) {
			return false;
		}
		return true;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
