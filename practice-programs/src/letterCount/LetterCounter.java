package letterCount;

public class LetterCounter {

	private char[] text;
	private int[] numberOfOccurrences;

	public LetterCounter(String text) {
		this.text = text.toCharArray();
		numberOfOccurrences = new int[256];
		sortLetters();
	}

	public void sortLetters() {
		for (char letter : text) {
			numberOfOccurrences[letter]++;
		}

	}

	@Override
	public String toString() {
		String letterCount = "";
		// caps
		for (char i = 'A'; i < 'Z'; i++) {
			if (numberOfOccurrences[i] > 0) {
				letterCount += i + "->" + numberOfOccurrences[i] + "\n";
			}
		}
		// lower case
		for (char i = 'a'; i < 'z'; i++) {
			if (numberOfOccurrences[i] > 0) {
				letterCount += i + "->" + numberOfOccurrences[i] + "\n";
			}
		}
		return letterCount;
	}
}
