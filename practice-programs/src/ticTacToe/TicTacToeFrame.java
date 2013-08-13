package ticTacToe;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private TicTacToeBoard board;
	private ComputerPlayer computerPlayer;
	private int turn;
	private XOButton[][] buttons;

	public TicTacToeFrame() {
		setLayout(new GridLayout(3, 3));
		setSize(300, 300);
		setTitle("Tic Tac Toe");
		setBoard();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setBoard() {
		board = new TicTacToeBoard();
		computerPlayer = new ComputerPlayer();
		turn = 1;
		buttons = new XOButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				XOButton button = new XOButton(i, j);
				button.addMouseListener(new ClickListener());
				add(button);
				buttons[i][j] = button;
			}
		}
	}

	public void reset() {
		System.exit(0);
	}

	private class ClickListener implements MouseListener {

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
			XOButton button = (XOButton) arg0.getSource();
			button.setXO(turn);
			board.getBoard()[button.getI()][button.getJ()] = button.getXO();
			if (board.checkWin()) {
				JOptionPane.showMessageDialog(null,
						"The winner is " + button.getXO());
				reset();
			} else {
				turn++;
			}
			try {
				Point p = computerPlayer.getNextMove(board);
				board.getBoard()[(int) p.getX()][(int) p.getY()] = computerPlayer
						.getChar(turn);
				buttons[(int) p.getX()][(int) p.getY()].setXO(turn);
				if (board.checkWin()) {
					JOptionPane.showMessageDialog(null, "The winner is "
							+ computerPlayer.getChar(turn));
					reset();
				} else {
					turn++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}
}
