package ticTacToe;

import java.awt.Color;

import javax.swing.JButton;

public class XOButton extends JButton {

	private static final long serialVersionUID = 1L;
	private int i;
	private int j;
	private char xo;

	public XOButton(int i, int j) {
		this.i = i;
		this.j = j;
		this.setBackground(Color.WHITE);
	}

	public void setXO(int turn) {
		if (turn % 2 == 0) {
			xo = 'o';
		} else {
			xo = 'x';
		}
		this.setText(xo + "");
	}

	public char getXO() {
		return xo;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

}
