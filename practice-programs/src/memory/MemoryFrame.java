package memory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MemoryFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int number;
	private ButtonsPanel buttonsPanel;
	private JPanel topPanel;
	private JButton newGame;
	private JButton giveUp;

	public MemoryFrame(int number) {
		this.number = number;
		setSize(800, 850);
		setTitle("Memory");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		addTopPanel();
		addTopPanel();
		addButtonsPanel();
		setVisible(true);
	}

	private void addButtonsPanel() {
		buttonsPanel = new ButtonsPanel(number);
		add(buttonsPanel, BorderLayout.CENTER);
	}

	public void addTopPanel() {
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		addTopPanelButtons();
		add(topPanel, BorderLayout.NORTH);
	}

	public void addTopPanelButtons() {
		newGame = new JButton("New Game");
		giveUp = new JButton("Give Up");
		newGame.setBackground(Color.WHITE);
		giveUp.setBackground(Color.WHITE);
		newGame.addMouseListener(new ButtonListener());
		giveUp.addMouseListener(new ButtonListener());
		topPanel.add(newGame);
		topPanel.add(giveUp);
	}

	public void reset() {
		this.remove(buttonsPanel);
		addButtonsPanel();
		revalidate();
	}

	public void reveal() {
		buttonsPanel.reveal();
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
			JButton button = (JButton) arg0.getSource();
			if (button == newGame) {
				reset();
			} else if (button == giveUp) {
				reveal();
			}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}

}
