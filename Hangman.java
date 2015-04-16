
/*
Main application class for HANGMAN project in JAVA
Author:	Leszek Dubicki
email:	Leszek.Dubicki@student.ncirl.ie
ID:	x14125439
*/

import java.util.Scanner;
public class Hangman{
	private static void clearscreen(){
		for (int i=0;i<50;i++){
			System.out.print("\n");
			//I'm clearing screen by displaying a lot of empty lines
		}
	}
	public static char nextChar(Scanner Sc){
		//takes nex char from the user
		//it's actually missing method from Scanner class
		//it will use scanner instance already initialized in main
		String c;
		int len;
		do{
			c = Sc.next();//get string
			len = c.length(); //get length of it
			if (len>1){
				System.out.println("Please provide only one character!");
			}
			else if (((int)c.charAt(0) < 97) || ((int)c.charAt(0) > 97+26)){
				System.out.println("Please provide lowercase letter!"); //so it should be called nextLetter() :)
			}
		} while (len > 1); //Scanner already takes care of providing nothing at input
		return c.charAt(0);
	}
	public static void main(String args[]){
		Executioner E= new Executioner();
		WordsCollection W = new WordsCollection();
		char letter; //variable for letters the user will input
		Scanner ScanObj = new Scanner(System.in);

		String word;
		GuessWord Guesser;
		//main application loop:
		char answer = 'y';
		do {
			word = W.getRandomWord(); //get random word from collection class
			//System.out.println(word); //print the word for testing purpose
			Guesser = new GuessWord(word); //initialize new guessing manager
			while ((Guesser.isAlive()) && (!Guesser.won()) ){
				//only loop asking for letters if the player alives and the game is not won yet.
				clearscreen();
				System.out.println(Guesser.displayStatus());
				System.out.print("\nType a letter: ");
				letter = nextChar(ScanObj);
				//but it

				while (Guesser.checkLetter(letter)) {
					System.out.println("This letter was already used, try different one...");
					letter = nextChar(ScanObj);
				};
				Guesser.takeAGuess(letter);

			}
			if (Guesser.won()){
				System.out.println("You've won, do you want to play again?");
			}
			else {
				System.out.println("You've lost, do you want to play again?");
			}

			answer = nextChar(ScanObj);
			while ((answer != 'y') && (answer != 'n') ){
				System.out.println("Please provide 'y' or 'n' !");
				answer = nextChar(ScanObj);
			}

		} while (answer == 'y');

	}
}