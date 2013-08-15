package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;

public class ColorButton extends JButton {

	private static final long serialVersionUID = 1L;
	private Color color;
	private ArrayList<Color> colors;
	private int timesPressed;
	private int hiddenStatus;

	public ColorButton() {
		setBackground(Color.LIGHT_GRAY);
		color = Color.white;
		setColors();
		timesPressed = 0;
		hiddenStatus = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(0, 0, 85, 82);
		if (hiddenStatus == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 90, 90);
		}
		this.setToolTipText(timesPressed + "");
		repaint();
	}

	@Override
	public void hide() {
		hiddenStatus = 1;
	}

	public void unhide() {
		hiddenStatus = 0;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	private void setColors() {
		colors = new ArrayList<Color>();
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.CYAN);
		colors.add(Color.BLUE);
		colors.add(Color.MAGENTA);
		colors.add(Color.PINK);
	}

	public void setPressed() {
		if (timesPressed > 5) {
			timesPressed = 0;
		}
		setColor(colors.get(timesPressed));
		timesPressed++;
	}

}
