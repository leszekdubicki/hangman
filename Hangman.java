
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
		} while (len > 1); //Scanner already takes care of providing nothing at input
		return c.charAt(0);
	}
	public static void main(String args[]){
		Executioner E= new Executioner();
		System.out.println(E.hang(7));
		WordsCollection W = new WordsCollection();
		char letter;
		Scanner ScanObj = new Scanner(System.in);

		String word;
		GuessWord Guesser;
		//main application loop:
		char answer = 'y';
		do {
			word = W.getRandomWord(); //get random word from collection class
			//System.out.println(word); //print the word for testing purpose
			Guesser = new GuessWord(word); //initialize new guessing manager
			while (Guesser.isAlive()){

				System.out.print("Type a letter: ");
				letter = nextChar(ScanObj);
				//but it
				clearscreen();
				// System.out.println(letter); //print the letter for testing purpose
				Guesser.takeAGuess(letter);
				System.out.println(Guesser.displayStatus());
			}

		} while (answer == 'y');

	}
}