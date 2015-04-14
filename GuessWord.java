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
    private boolean checkLetter(char letter){
		//checks if letter was already used (true if used false if not)
		//sets the letter as used if not
		//I will use ascii character code to convert into index of my array of boleeans of used letters
		int index = (int)letter - 97;
		boolean returnValue = true; //I assume it was used already and will check if it's true in the next step.
		if (lettersUsed[index] != true){
			lettersUsed[index] = true;
			returnValue = false;
		}
		return returnValue;
	}
    public boolean takeAGuess(char letter){
		boolean sthWasGuessed = false;
        //if letter wasn't used than check if it is in the word and other stuff:
        if (!checkLetter(letter)){
			//notice that the method checkLetter already took care of setting proper value in lettersUsed array
			//this can be dangerous, I know, but I use this method only here and I set it to private
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
    public String displayStatus(){
        //returns string to be displayed when asked for status of the game for this particular word
        StringBuffer status;
        status = new StringBuffer();
        status.append(whatWasGused+"\n\n"); //disp hidden and guessed letters
        status.append(kat.hang(livesLost));//the gallows :)
        status.append("\n");
        status.append("You have had "+ Integer.toString(attempts)+" attempts\n");
        status.append("You have lost "+Integer.toString(livesLost)+" lives\n");
        status.append("You have "+Integer.toString(7-livesLost)+" lives left\n");
        return status.toString();
    }
}//end of class
