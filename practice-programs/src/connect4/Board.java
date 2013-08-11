package connect4;

import java.awt.Color;

public class Board {

	private Piece[][] pieces;
	private Color winner;

	public Board() {
		this.pieces = new Piece[6][7];
		this.winner = null;
		createBoard();
	}

	public String getWinner() {
		if (this.winner == Color.RED) {
			return "red ";
		} else {
			return "yellow ";
		}
	}

	public void setWinner(Color winner) {
		this.winner = winner;
	}

	public void createBoard() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				this.pieces[i][j] = new Piece(x, y);
				if (x == 600) {
					x = 0;
				} else {
					x += 100;
				}
			}
			if (y == 500) {
				y = 0;
			} else {
				y += 100;
			}
		}
	}

	public boolean isWinner() {
		return (isVerticalWinner() || isHorizontalWinner() || isDiagonalWinnerUp()
				|| isDiagonalWinnerDown());
	}

	public boolean isFull() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (this.pieces[i][j].getColor() == Color.BLACK) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isVerticalWinner() {
		int count = 0;
		Color color = null;
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 6; i++) {
				if (this.pieces[i][j].getColor() == Color.BLACK) {
					break;
				}
				if (color == null) {
					color = this.pieces[i][j].getColor();
					count++;
				} else if (color == this.pieces[i][j].getColor()) {
					count++;
					if (count == 4) {
						this.winner = color;
						return true;
					}
				} else {
					color = this.pieces[i][j].getColor();
					count = 1;
				}
			}
			count = 0;
			color = null;
		}
		return false;
	}

	public boolean isHorizontalWinner() {
		int count = 0;
		Color color = null;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				if (this.pieces[i][j].getColor() == Color.BLACK) {
					count = 0;
				} else if (color == null) {
					color = this.pieces[i][j].getColor();
					count++;
				} else if (color == this.pieces[i][j].getColor()) {
					count++;
					if (count == 4) {
						this.winner = color;
						return true;
					}
				} else if (color != this.pieces[i][j].getColor()) {
					color = this.pieces[i][j].getColor();
					count = 1;
				}
			}
			count = 0;
			color = null;
		}
		return false;
	}

	public boolean isDiagonalWinnerUp() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				Color color = this.pieces[i][j].getColor();
				if (color == Color.BLACK) {
					continue;
				} else {
					if (this.pieces[i + 1][j + 1].getColor() != color) {
						continue;
					}
					if (this.pieces[i + 2][j + 2].getColor() != color) {
						continue;
					}
					if (this.pieces[i + 3][j + 3].getColor() != color) {
						continue;
					} else {
						this.winner = color;
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isDiagonalWinnerDown() {
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				Color color = this.pieces[i][j].getColor();
				if (color == Color.BLACK) {
					continue;
				} else {
					if (this.pieces[i - 1][j + 1].getColor() != color) {
						continue;
					}
					if (this.pieces[i - 2][j + 2].getColor() != color) {
						continue;
					}
					if (this.pieces[i - 3][j + 3].getColor() != color) {
						continue;
					} else {
						this.winner = color;
						return true;
					}
				}
			}
		}
		return false;
	}

	public int getNextSpot(int x) {
		for (int i = 0; i < 6; i++) {
			if (this.pieces[i][x].getColor() == Color.BLACK) {
				return i;
			}
		}
		return -1;
	}

	public Piece[][] getPieces() {
		return this.pieces;
	}

	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

}
