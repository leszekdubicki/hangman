/**Class to provide random word for guessing
author: Leszek Dubicki
*/

import java.util.Random;
public class WordsCollection{
	private String[] words;
	private void setWords(){
		//method to store words into memory
		//to be called in constructor/
		String words2[] = {"programming","exhaustive","violin","selection","repetition","serendipity"};
		this.words = new String[words2.length];
		this.words = words2;
	}
	public WordsCollection(){
		setWords();
	}
	public String getRandomWord(){
		//retrieves random word from the list:
		Random R = new Random();
		//get random index from the table
		int num;
		num = R.nextInt(words.length);
		System.out.println(num);
		return words[num];
	}
}