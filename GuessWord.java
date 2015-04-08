public class GuessWord{
    private String word;
    private StringBuffer whatWasGused;
    private Executoner kat;
    private int lives;
    private int attempts;
    private boolean guessed[];//array of which indexes of word are already guessed
    public GuessWord(String word){
        this.word = word;
        livesLost = 0;
        attempts = 0;
        kat = new Executoner(); //instance of an Executioner class.
        //kat means executioner in Polish
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
            if word.charAt(i) == letter{
                sthWasGuessed = true; //something guessed, no life will be taken
                //set whatWasGused at this index to relevant letter:
                whatWasGused.replace(i,letter);
                //set guessed at this index to true:
                guessed[i]=true;
            }
        }
        if !sthWasGuessed{
            livesLost+=1;
        }
        return sthWasGuessed;
    }
    public boolean isAlive(){
        if livesLost>6{
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
        status.append(kat.);//the gallows :)
        status.appenda("You have had "+(str)attempts+" attempts\n");
        status.appenda("You have lost "+(str)livesLost+" lives\n");
        status.appenda("You have "+(str)(7-livesLost)+" lives left\n");
        return status;
    }
}//end of class
