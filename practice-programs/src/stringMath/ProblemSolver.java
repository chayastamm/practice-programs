package stringMath;

import javax.swing.JOptionPane;

public class ProblemSolver {

	private String mathProblem;

	public ProblemSolver(String mathProblem) {
		this.mathProblem = mathProblem;
	}

	public int solve() throws Exception {

		// initialize variables
		boolean foundOperand = false;
		/*
		 * The method must keep track of when an operand has been found. If
		 * there is an operand followed by a negative sign, the negative must
		 * become part of the number that follows it, and is not a minus sign.
		 * So, if foundOperand is true, the following character will
		 * automatically be part of the following number.
		 */
		String prevOperand = "";
		int sum = 0;
		String currNum = mathProblem.charAt(0) + "";
		// begin looping through the string, processing each char
		for (int i = 1; i < mathProblem.length(); i++) {
			// if not up to adding or subtracting
			if (foundOperand || mathProblem.charAt(i) != '-'
					&& mathProblem.charAt(i) != '+') {
				// add the char to the current number
				currNum += mathProblem.charAt(i);
				foundOperand = false;
			} else {
				try {
					if (prevOperand.compareTo("+") == 0) {
						// add
						sum += Integer.parseInt(currNum);
					} else if (prevOperand.compareTo("-") == 0) {
						// subtract
						sum -= Integer.parseInt(currNum);
					} else {
						// no prevOperand yet
						sum += Integer.parseInt(currNum);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null,
							"Number incorrectly formatted");
				}
				// reset variables
				prevOperand = mathProblem.charAt(i) + "";
				currNum = "";
				foundOperand = true;
			}
		}
		// exhausted string, last number has been completely found, just add or
		// subtract the last number and return the sum
		try {
			if (prevOperand.compareTo("+") == 0) {
				return sum += Integer.parseInt(currNum);
			} else if (prevOperand.compareTo("-") == 0) {
				return sum -= Integer.parseInt(currNum);
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Number incorrectly formatted");
		}
		return sum;
	}
}
