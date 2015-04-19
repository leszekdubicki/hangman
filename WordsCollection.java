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
	private boolean[] usedWords; //what words were used in this instance of a class already
	private void setWords(){
		//method to store words into memory
		//to be called in constructor/
		String words2[] = {"programming","exhaustive","violin","selection","repetition","serendipity","coding",
		"condition","java","python","class","function","string","char","boolean","file","system","collection","array",
		"list","bicycle","service","page","visual","basic","ruby","javascript","database","connection","query"};
		this.words = new String[words2.length];
		this.words = words2;
		this.usedWords = new boolean[this.words.length];
	}
	public WordsCollection(){
		setWords(); //initialize words
        flushUsedWords(); //set all to false there
	}
	private void flushUsedWords(){
		//method for erasing all from used words array
		for (int i=0;i<usedWords.length; i++){
            usedWords[i] = false;
        }
	}
    /* turned out it's not needed
	private boolean checkWord(String word){
        boolean retval = false;
		for (int i=0;i<words.length; i++){
                if (words[i].equals(word)){
                    //check if usedWords at the same index if true:
                    if (usedWords[i]) {
                        retval = true;
                    }
                    break;
                }
		}
        return retval;
	}*/
	private boolean checkAllWordsUsed(){
		/*method to check if all words were already used
		(which basicly means if all indexes are set as true in usedWords array*/
        boolean retval = true;
		for (int i=0;i<words.length; i++){
                if (!usedWords[i]){
                    //check if usedWords at the same index if true:
                    retval = false;
                    break;
                }
		}
        return retval;
	}
	public String getRandomWord(){
		//retrieves random word from the list:
        if (checkAllWordsUsed()){
            flushUsedWords(); //mark all as unused.
        }; //check if all words were used already:
		Random R = new Random();
		//get random index from the table
		int num;
        do{
		num = R.nextInt(words.length); // I'm using Random class, it's easier (although probably more CPU/memeory consuming)
        } while (usedWords[num] == true);
        usedWords[num] = true; //set this word as already used.
		return words[num];
	}
}
