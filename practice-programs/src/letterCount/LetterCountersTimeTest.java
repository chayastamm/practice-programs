package letterCount;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LetterCountersTimeTest {

	@Test
	public void testCountersSpeed() {
		// calculate how long LetterCounter takes
		long startTime1 = System.nanoTime();
		LetterCounter counter1 = new LetterCounter("This is a sentence");
		counter1.toString();
		long endTime1 = System.nanoTime();
		long time1 = endTime1 - startTime1;
		// calculate how long LetterCounter2 takes
		long startTime2 = System.nanoTime();
		LetterCounter2 counter2 = new LetterCounter2("This is a sentence");
		counter2.toString();
		long endTime2 = System.nanoTime();
		long time2 = endTime2 - startTime2;

		assertTrue(time1 < time2);
	}

}
