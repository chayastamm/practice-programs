package stringMath;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

public class StringMathMain {

	public static void main(String[] args) throws HeadlessException, Exception {
		String mathProblem = JOptionPane
				.showInputDialog("Enter a math problem such as 3+2-1");
		ProblemSolver problemSolver = new ProblemSolver(mathProblem);
		JOptionPane.showMessageDialog(null, problemSolver.solve());

	}

}
