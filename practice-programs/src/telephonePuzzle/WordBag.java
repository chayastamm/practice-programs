package telephonePuzzle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WordBag {
	private ArrayList<String> words;
	private ArrayList<String> words2;

	public WordBag() {

		File file = new File("dic.txt");
		File file2 = new File("dic2.txt");
		Scanner readFromFile;

		try {
			readFromFile = new Scanner(file);
			words = new ArrayList<String>();
			while (readFromFile.hasNextLine()) {
				String word = readFromFile.nextLine();
				words.add(word);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error with first dic file");
		}
		try {
			readFromFile = new Scanner(file2);
			words2 = new ArrayList<String>();
			while (readFromFile.hasNextLine()) {
				String word = readFromFile.nextLine();
				words2.add(word);
			}
			readFromFile.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error with second file");
		}
	}

	public boolean isContaining(String word) {
		if (words2.contains(word)) {
			return true;
		}
		return false;
	}

	public String getWord() {
		Random random = new Random();
		int num = random.nextInt(words.size());
		return words.get(num);
	}

}
