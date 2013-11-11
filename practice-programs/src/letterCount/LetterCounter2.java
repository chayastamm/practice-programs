package letterCount;

import java.util.HashMap;

public class LetterCounter2 {

	private HashMap<Character, Integer> list;
	private String text;

	public LetterCounter2(String text) {
		list = new HashMap<Character, Integer>();
		this.text = text;
		sortLetters();
	}

	public void sortLetters() {
		for (int i = 0; i < text.length(); i++) {
			char currChar = text.charAt(i);
			if (list.containsKey(currChar)) {
				list.put(currChar, list.get(currChar) + 1);
			} else {
				list.put(currChar, 1);
			}
		}
	}

	@Override
	public String toString() {
		String letterCount = "";
		// upper case
		for (char i = 'A'; i < 'Z'; i++) {
			if (list.containsKey(i)) {
				letterCount += i + "->" + list.get(i) + "\n";
			}
		}
		// lower case
		for (char i = 'a'; i < 'z'; i++) {
			if (list.containsKey(i)) {
				letterCount += i + "->" + list.get(i) + "\n";
			}
		}
		return letterCount;
	}
}
