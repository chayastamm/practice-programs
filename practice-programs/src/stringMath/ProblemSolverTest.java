package stringMath;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProblemSolverTest {
	private ProblemSolver one = new ProblemSolver("3+2-1");// 4
	private ProblemSolver two = new ProblemSolver("3-2+1");// 2
	private ProblemSolver three = new ProblemSolver("-3+5-1");// 1
	private ProblemSolver four = new ProblemSolver("356+222-1");// 577
	private ProblemSolver five = new ProblemSolver("7-2+3--4+1+-4");// 9
	private ProblemSolver six = new ProblemSolver("- 7-2+3-*-4+1+-4");//

	@Test
	public void testOneAndTwo() throws Exception {
		assertEquals(4, one.solve());
		assertEquals(2, two.solve());
	}

	@Test
	public void testThreeAndFour() throws Exception {
		assertEquals(1, three.solve());
		assertEquals(577, four.solve());
	}

	@Test
	public void testFive() throws Exception {
		assertEquals(9, five.solve());
	}

	@Test
	public void testSix() throws Exception {
		try {
			assertEquals(9, six.solve());
		} catch (NumberFormatException e) {
			// expected
		}

	}
}
