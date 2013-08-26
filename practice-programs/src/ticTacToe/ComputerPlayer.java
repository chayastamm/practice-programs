package ticTacToe;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class ComputerPlayer {

	private Point mustGoHere;

	public ComputerPlayer() {
		mustGoHere = new Point();
	}

	/*
	 * To calculate where to go, the computer first checks: to make sure there
	 * is space left - if not, game ends to make sure no one has one won already
	 * - since for now the player goes first, this is never true; then for a
	 * specific double trap the rest of the logic doesn't prevent; to see if the
	 * board is empty - if it is, it returns the center to see if it is almost
	 * winning - if it is, it will go in that place; to see it it is almost
	 * losing - if it is, it will block the player. Then the computer gets the
	 * char to see if it is x or o and passes the list of spots, the board, and
	 * the char to the checkMove method which returns a list of winning spots.
	 * If the list is empty, then the computer goes into a randomly chosen spot
	 * If the list isn't empty, the computer passes the list to the
	 * getBestWinningSpot method and returns the point it receives back.
	 */
	public Point getNextMove(TicTacToeBoard board) throws Exception {
		ArrayList<Point> spots = board.getEmptySpots();
		ArrayList<Point> winningSpots = new ArrayList<Point>();
		if (spots.size() == 0) {
			return null;
		} else if (spots.size() == 6 && board.getBoard()[0][2] == 'x'
				&& board.getBoard()[2][0] == 'x') {
			return new Point(1, 0);
		} else if (spots.size() == 9) {
			return new Point(1, 1);
		} else if (almostWinning(spots.size(), board)) {
			return mustGoHere;
		} else if (almostLoosing(spots.size() + 1, board)) {
			return mustGoHere;
		}
		char turn = getChar(spots.size());
		winningSpots = checkMove(spots, board, turn);
		if (winningSpots.isEmpty()) {
			Random randomNum = new Random();
			int i = randomNum.nextInt(spots.size());
			return spots.get(i);
		}
		return getBestWinningSpot(winningSpots);
	}

	/*
	 * This method receives a list of empty spots, a board, and the char x or o.
	 * It creates a stack of boards Then, for every empty spot, it creates a new
	 * board using the board copy constructor, sets that empty spot to the char,
	 * and sets the boards starting spot to the empty spot so if it turns out to
	 * be a bad choice it will remember what to remove. Then it adds the board
	 * to the stack. Then it passes the boards and char to the checkMove2
	 * method, which returns a list of winning spots.
	 */
	public ArrayList<Point> checkMove(ArrayList<Point> spots,
			TicTacToeBoard board, char turn) {
		Stack<TicTacToeBoard> boards = new Stack<TicTacToeBoard>();
		for (int i = 0; i < spots.size(); i++) {
			TicTacToeBoard aBoard = new TicTacToeBoard(board);
			aBoard.getBoard()[spots.get(i).x][spots.get(i).y] = turn;
			aBoard.setStart(spots.get(i));
			boards.add(aBoard);
		}
		return checkMove2(boards, turn);
	}

	/*
	 * This method receives a stack of boards and the char x or o that the
	 * computer is, called computersChar. It creates a list of winning spots and
	 * a temporary array of boards. While the stack of boards isn't empty, it
	 * pops one off and calls it aBoard. It gets aBoard's empty spots, figures
	 * our which char goes next, and creates a second temporary array of boards.
	 * Then it loops through aBoard's empty spots, creates a new board, sets
	 * that spot to the current char, and checks if someone has won. If it
	 * has,it checks if the computersChar won. If it has, the initial spot
	 * (getStart) is added to the winning spots list, and it breaks out of the
	 * loop. If not, this initial spot leads to failure, so it is removed, and
	 * it breaks out of the loop. If no one won, but it was possible, the board
	 * is added to tempArray2, if it wasn't possible, it is added to tempArray.
	 * When the for loop is finished, it checks if the tempArray2 is the same
	 * size as there were empty spots. If it is, there wasn't a win or loss, and
	 * the board needs to be checked further, so it is added to the tempArray.
	 * Then, when the stack is empty, if the winning spots list is empty, the
	 * temporary array is not empty, and the boards in the list are not full,
	 * the temporary array is added to the stack and the method is called again.
	 * Otherwise, it returns the winning spots. This logic is hardly perfect and
	 * may lose, but the average player will not win often.
	 */
	public ArrayList<Point> checkMove2(Stack<TicTacToeBoard> boards,
			char computersChar) {
		ArrayList<Point> winningSpots = new ArrayList<Point>();
		ArrayList<TicTacToeBoard> tempArray = new ArrayList<TicTacToeBoard>();
		while (!boards.isEmpty()) {
			TicTacToeBoard aBoard = boards.pop();
			ArrayList<Point> spots = aBoard.getEmptySpots();
			char turn = getChar(spots.size());
			ArrayList<TicTacToeBoard> tempArray2 = new ArrayList<TicTacToeBoard>();
			for (int i = 0; i < spots.size(); i++) {
				TicTacToeBoard board = new TicTacToeBoard(aBoard);
				board.getBoard()[spots.get(i).x][spots.get(i).y] = turn;
				if (spots.size() < 6) {
					if (board.checkWin()) {
						if (turn == computersChar) {
							winningSpots.add(board.getStart());
							break;
						} else {
							if (winningSpots.contains(board.getStart())) {
								winningSpots.remove(board.getStart());
							}
							break;
						}
					} else {
						tempArray2.add(board);
					}
				} else {
					tempArray.add(board);
				}
			}
			if (tempArray2.size() == spots.size()) {
				// didn't break out because of loss or win
				tempArray.addAll(tempArray2);
			}
		}
		if (winningSpots.isEmpty() && !tempArray.isEmpty()
				&& tempArray.get(0).getEmptySpots().size() != 0) {
			boards.addAll(tempArray);
			winningSpots = checkMove2(boards, computersChar);
		}
		return winningSpots;
	}

	/*
	 * This method gets a list of spots. If the list is > 1 long, it creates a
	 * hashmap of the spots and how often they appear. A variable max is set to
	 * 1, and increased if any of the spots appears more times. If none do, the
	 * first spot is returned. Otherwise, it returns the point that appear the
	 * most times. If more than one point has the max, the first is returned. If
	 * the list is only 1 point long, the first point is returned.
	 */
	public Point getBestWinningSpot(ArrayList<Point> spots) {
		if (spots.size() != 1) {
			Map<Point, Integer> points = new HashMap<Point, Integer>();
			Integer max = 1;
			for (int i = 0; i < spots.size(); i++) {
				if (points.containsKey(spots.get(i))) {
					Integer replacement = points.get(spots.get(i)) + 1;
					if (replacement > max) {
						max = replacement;
					}
					points.put(spots.get(i), replacement);
				} else {
					points.put(spots.get(i), 1);
				}
			}
			if (max == 1) {
				return spots.get(0);
			} else {
				for (Map.Entry<Point, Integer> entry : points.entrySet()) {
					Point key = entry.getKey();
					Integer value = entry.getValue();
					if (value == max) {
						return key;
					}
				}
			}
		}
		return spots.get(0);
	}

	public char getChar(int numSpots) {
		if (numSpots % 2 == 0) {
			return 'o';
		} else {
			return 'x';
		}
	}

	/*
	 * checks if the computer is about to win, if true, mustGoHere variable is
	 * set
	 */
	public boolean almostWinning(int turn, TicTacToeBoard board) {
		ArrayList<Point> points = board.getEmptySpots();
		char myTurn = getChar(turn);
		for (int i = 0; i < points.size(); i++) {
			TicTacToeBoard newBoard = new TicTacToeBoard(board);
			newBoard.getBoard()[(int) points.get(i).getX()][(int) points.get(i)
					.getY()] = myTurn;
			if (newBoard.checkWin()) {
				mustGoHere = points.get(i);
				return true;
			}
		}
		return false;
	}

	/*
	 * checks if the computer is about to lose, if true, mustGoHere variable is
	 * set
	 */
	public boolean almostLoosing(int turnPlusOne, TicTacToeBoard board) {
		ArrayList<Point> points = board.getEmptySpots();
		char opponent = getChar(turnPlusOne);
		for (int i = 0; i < points.size(); i++) {
			TicTacToeBoard newBoard = new TicTacToeBoard(board);
			newBoard.getBoard()[(int) points.get(i).getX()][(int) points.get(i)
					.getY()] = opponent;
			if (newBoard.checkWin()) {
				mustGoHere = points.get(i);
				return true;
			}
		}
		return false;
	}

}