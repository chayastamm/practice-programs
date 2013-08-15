package mastermind;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AnswerPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<Color> colorList;
	private boolean fillCircles;

	public AnswerPanel() {
		this.setLayout(new GridLayout(2, 2));
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new LineBorder(Color.BLACK));
		colorList = new ArrayList<Color>();
		fillCircles = false;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (fillCircles) {
			drawFullCircles(g);
		} else {
			drawEmptyCircles(g);
		}
		repaint();
	}

	public void drawEmptyCircles(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(0, 0, 42, 42);
		g.drawOval(42, 0, 42, 42);
		g.drawOval(0, 42, 42, 42);
		g.drawOval(42, 42, 42, 42);
	}

	public void drawFullCircles(Graphics g) {
		g.setColor(colorList.get(0));
		g.fillOval(0, 0, 42, 42);
		g.setColor(colorList.get(1));
		g.fillOval(42, 0, 42, 42);
		g.setColor(colorList.get(2));
		g.fillOval(0, 42, 42, 42);
		g.setColor(colorList.get(3));
		g.fillOval(42, 42, 42, 42);
	}

	public ArrayList<Color> getColorList() {
		return colorList;
	}

	public void setColorList(int black, int white) {
		for (int i = 0; i < black; i++) {
			colorList.add(Color.BLACK);
		}
		for (int i = 0; i < white; i++) {
			colorList.add(Color.WHITE);
		}
		while (colorList.size() < 4) {
			colorList.add(Color.LIGHT_GRAY);
		}
		Collections.shuffle(colorList);
		fillCircles = true;
	}
}
