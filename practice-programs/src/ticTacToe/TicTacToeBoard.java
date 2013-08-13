package ticTacToe;

import java.awt.Point;
import java.util.ArrayList;

public class TicTacToeBoard {

	private char[][] board;
	private Point start;

	public TicTacToeBoard() {
		board = new char[3][3];
		this.setStart(new Point());
	}

	public TicTacToeBoard(TicTacToeBoard oldBoard) {
		board = new char[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				board[row][col] = oldBoard.getBoard()[row][col];
			}
		}
		this.setStart(oldBoard.getStart());
	}

	public boolean checkWin() {
		if (winDiagonal() || winHorizontal() || winVertical()) {
			return true;
		}
		return false;
	}

	public boolean compareTo(TicTacToeBoard board) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (this.getBoard()[row][col] != board.getBoard()[row][col]) {
					return false;
				}
			}
		}
		return true;
	}

	public char[][] getBoard() {
		return board;
	}

	public ArrayList<Point> getEmptySpots() {
		ArrayList<Point> spots = new ArrayList<Point>();
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] == 'x' || board[row][col] == 'o') {
					continue;
				} else {
					Point p = new Point(row, col);
					spots.add(p);
				}
			}
		}
		return spots;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		String info = "";
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				info += board[row][col] + "|";
			}
		}
		return info;
	}

	public boolean winDiagonal() {
		char first = board[0][0];
		if ((first == 'o' || first == 'x') && board[1][1] == first
				&& board[2][2] == first) {
			return true;
		}
		first = board[0][2];
		if ((first == 'o' || first == 'x') && board[1][1] == first
				&& board[2][0] == first) {
			return true;
		}
		return false;
	}

	public boolean winHorizontal() {
		for (int row = 0; row < 3; row++) {
			char first = board[row][0];
			if ((first == 'o' || first == 'x') && board[row][1] == first
					&& board[row][2] == first) {
				return true;
			}
		}
		return false;
	}

	public boolean winVertical() {
		for (int col = 0; col < 3; col++) {
			char first = board[0][col];

			if ((first == 'o' || first == 'x') && board[1][col] == first
					&& board[2][col] == first) {
				return true;
			}
		}
		return false;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}
}