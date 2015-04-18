/**
Class for storing all words and for providing random word from the list on request.
@uthor:	Leszek Dubicki
studentID:	x14125439
email:	Leszek.Dubicki@student.ncirl.ie
@date: 10/04/2015
*/
import java.util.Random;
public class WordsCollection{
	private String[] words; //my words array - all words stored in the class (should be in database actualy)
	private String[] usedWords; //what words were used in this instance of a class already
	private void setWords(){
		//method to store words into memory
		//to be called in constructor/
		String words2[] = {"programming","exhaustive","violin","selection","repetition","serendipity","coding",
		"condition","java","python","class","function","string","char","boolean","file","system","collection","array",
		"list","bicycle","service","page","visual","basic","ruby","javascript","database","connection","query"};
		this.words = new String[words2.length];
		this.words = words2;
	}
	public WordsCollection(){
		setWords();
	}
	private void flushUsedWords(){
		//method for erasing all from
	}
	private boolean checkWord(String word){
		/*method to check if word was already used
		(which basicly means if it is in usedWords array*/
		for (int i=0;i<usedWords.length; i++){

		}
	}
	public String getRandomWord(){
		//retrieves random word from the list:
		Random R = new Random();
		//get random index from the table
		int num;
		num = R.nextInt(words.length); // I'm using Random class, it's easier (although probably more CPU/memeory consuming)
		return words[num];
	}
}