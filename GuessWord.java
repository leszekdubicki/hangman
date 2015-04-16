public class GuessWord{
    private String word; //word passed to the object
    private StringBuffer whatWasGused; //stringbuffer to manipulate displayed status of word guessing, should be array probably
    private Executioner kat; //instance of Executoner class (kat means executioner in Polish)
    private int livesLost;
    private int attempts;
    private boolean guessed[];//array of which indexes of word are already guessed
    private boolean lettersUsed[]; //what letters were passed to the object so far - to avoid repetition
    public GuessWord(String word){
		//class instance constructor
        this.word = word; //word to guess, has to be provided on init
        livesLost = 0; //how many lives are lost, initially 0 of course
        attempts = 0; //how many attempts were made to guess
        kat = new Executioner(); //instance of an Executioner class (which displays hanging man).
        guessed = new boolean[word.length()];
        whatWasGused = new StringBuffer();
        for (int i=0;i<word.length();i++){
            whatWasGused.append("_"); //all positions of this variable are set to notguessed/unknown
            guessed[i]=false; //nothing was guessed on init
        }
        //initialize array of used letters:
        lettersUsed = new boolean[26];
        for (int i=0; i<lettersUsed.length; i++){
			lettersUsed[i] = false; //just in case, probably on init it's false anyway
			//of course for mobile app I should not do it just in case.
		}
    }
    public boolean checkLetter(char letter){
		//checks if letter was already used (true if used false if not)
		//sets the letter as used if not
		//I will use ascii character code to convert into index of my array of boleeans of used letters
		int index = (int)letter - 97;
		boolean returnValue = true; //I assume it was used already and will check if it's true in the next step.
		if (lettersUsed[index] != true){
			//lettersUsed[index] = true; //not very clever, I'll rather set it aomewhere else
			returnValue = false;
		}
		return returnValue;
	}
	public String getLettersUsed(){
		//returns string with all the letters that were already used:
		StringBuffer letters = new StringBuffer(); //temporary stringBuffer to store the letters
		for (int i=0;i<lettersUsed.length;i++){
			if (lettersUsed[i] == true){
				letters.append((char)(i+97));
			}
		}
		return letters.toString();
	}
	private void markLetterAsUsed(char letter){
		//this method marks letter as used
		int index = (int)letter - 97; //convert char into our array index
		lettersUsed[index] = true; //set proper array value into true.
	}
    public boolean takeAGuess(char letter){
		boolean sthWasGuessed = false;
        //if letter wasn't used than check if it is in the word and other stuff:
        if (!checkLetter(letter)){
			markLetterAsUsed(letter); //set this letter to used so it won't be processed next time.
        	attempts+=1;
	        for (int i=0;i<word.length();i++){
	            if (word.charAt(i) == letter){
	                sthWasGuessed = true; //something guessed, no life will be taken
	                //set whatWasGused at this index to relevant letter:
	                whatWasGused.replace(i,i+1, Character.toString(letter));
	                //set guessed at this index to true:
	                guessed[i]=true;
	            }
	        }
        	if (!sthWasGuessed){
        	    livesLost+=1;
        	}
		}
        //return if sth was guessed or not
        //if the letter was already guessed it will still return false but no life will be taken
	    return sthWasGuessed;
	}
    public boolean isAlive(){
        if (livesLost>6){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean won(){
		//method that returns true only if the guesser is won:
		boolean isWon = true; //initialy true, let's check if it's true:
		for (int i=0; i<guessed.length; i++){
			if (!guessed[i]){
				isWon = false;
				//no point to keep looping:
				break; //I know we didn't have it during classes but I know this instruction from python already.
			}
		}
		return isWon;
	}
    public String displayStatus(){
        //returns string to be displayed when asked for status of the game for this particular word
        StringBuffer status;
        status = new StringBuffer();
        status.append(kat.hang(livesLost));//the gallows :)
        status.append("\n\n");
        status.append("        Lives: "+Integer.toString(7-livesLost)+"\n"); //how many lives has left
        status.append("         Word: "+whatWasGused+"\n"); //disp hidden and guessed letters
        status.append("     Attempts: "+ Integer.toString(attempts)+"\n"); //additionally - how many attempts were made
        status.append(" Letters used: "+ getLettersUsed()+"\n");
        return status.toString();
    }
}//end of class
