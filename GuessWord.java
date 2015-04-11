public class GuessWord{
    private String word; //word passed to the object
    private StringBuffer whatWasGused; //stringbuffer to manipulate displayed status of word guessing, should be array probably
    private Executioner kat; //instance of Executoner class (kat means executioner in Polish)
    private int livesLost;
    private int attempts;
    private boolean guessed[];//array of which indexes of word are already guessed
    private boolean lettersUsed[]; //what letters were passed to the object so far - to avoid repetition
    public GuessWord(String word){
        this.word = word;
        livesLost = 0;
        attempts = 0;
        kat = new Executioner(); //instance of an Executioner class.
        guessed = new boolean[word.length()];
        whatWasGused = new StringBuffer();
        for (int i=0;i<word.length();i++){
            whatWasGused.append("_"); //all positions of this variable are set to notguessed/unknown
            guessed[i]=false; //nothing was guessed on init
        }
    }
    public boolean takeAGuess(char letter){
        boolean sthWasGuessed = false;
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
