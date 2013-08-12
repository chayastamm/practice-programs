package telephonePuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GamesPlayedPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private JLabel gamesPlayedLabel;
	private JLabel gamesWonLabel;
	private JLabel gamesLostLabel;

	public GamesPlayedPanel() {
		setLayout(new GridLayout(1, 3));
		this.gamesLost = 0;
		this.gamesPlayed = 0;
		this.gamesWon = 0;
		setUpLabels();
	}

	public void setUpLabels() {
		setUpGamesPlayedLabel();
		setUpGamesWonLabel();
		setUpGamesLostLabel();
	}

	public void setUpGamesLostLabel() {
		this.gamesLostLabel = new JLabel("Games lost: " + gamesLost);
		this.gamesLostLabel.setBorder(new LineBorder(Color.BLACK, 10, false));
		this.gamesLostLabel.setFont(new Font("Arial", 1, 20));
		this.gamesLostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gamesLostLabel);
	}

	public void setUpGamesPlayedLabel(){
		this.gamesPlayedLabel = new JLabel("Games played: " + gamesPlayed);
		this.gamesPlayedLabel.setBorder(new LineBorder(Color.BLACK, 10, false));
		this.gamesPlayedLabel.setFont(new Font("Arial", 1, 20));
		this.gamesPlayedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gamesPlayedLabel);
	}
	
	public void setUpGamesWonLabel(){
		this.gamesWonLabel = new JLabel("Games won: " + gamesWon);
		this.gamesWonLabel.setBorder(new LineBorder(Color.BLACK, 10, false));
		this.gamesWonLabel.setFont(new Font("Arial", 1, 20));
		this.gamesWonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(gamesWonLabel);	
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed() {
		this.gamesPlayed++;
		this.gamesPlayedLabel.setText("Games played: " + gamesPlayed);
	}

	public int getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon() {
		this.gamesWon++;
		this.gamesWonLabel.setText("Games won: " + gamesWon);
	}

	public int getGamesLost() {
		return gamesLost;
	}

	public void setGamesLost() {
		this.gamesLost++;
		this.gamesLostLabel.setText("Games lost: " + gamesLost);
	}

}
