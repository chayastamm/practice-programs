package telephonePuzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WordBag {
	private ArrayList<String> words;

	public WordBag() {

		File file = new File("dic.txt");
		Scanner readFromFile;
		try {
			readFromFile = new Scanner(file);
			this.words = new ArrayList<String>();
			while (readFromFile.hasNextLine()) {
				String word = readFromFile.nextLine();
				words.add(word);
			}
			readFromFile.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error");
		}

	}

	public String getWord() {
		Random random = new Random();
		int num = random.nextInt(this.words.size());
		return words.get(num);
	}

}
