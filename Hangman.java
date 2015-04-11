/*
Main application class for HANGMAN project in JAVA
Author:	Leszek Dubicki
email:	Leszek.Dubicki@student.ncirl.ie
ID:	x14125439
*/
//import GuessMe.GuessMe;
import java.util.Scanner;
public class Hangman{
	private static void clearscreen(){
		for (int i=0;i<50;i++){
			System.out.print("\n");
			//I'm clearing screen by displaying a lot of empty lines
		}
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
		while (answer == 'y'){
			word = W.getRandomWord(); //get random word from collection class
			//System.out.println(word); //print the word for testing purpose
			Guesser = new GuessWord(word); //initialize new guessing manager
			while (Guesser.isAlive()){

				System.out.print("Type a letter: ");
				letter = ScanObj.next(".").charAt(0); //take exactly one char:
				clearscreen();
				// System.out.println(letter); //print the letter for testing purpose
				Guesser.takeAGuess(letter);
				System.out.println(Guesser.displayStatus());
			}

		}

	}
}