/*
Main application class for HANGMAN project in JAVA
Author:	Leszek Dubicki
email:	Leszek.Dubicki@student.ncirl.ie
ID:	x14125439
*/
//import GuessMe.GuessMe;
import java.util.Scanner;
public class Hangman{
	public static void main(String args[]){
		Executioner E= new Executioner();
		System.out.println(E.hang(7));
		WordsCollection W = new WordsCollection();

		String word;
		GuessWord Guesser;
		//main application loop:
		char answer = 'y';
		char letter;
		Scanner ScanObj = new Scanner(System.in);
		while (answer == 'y'){
			word = W.getRandomWord(); //get random word from collection class
			System.out.println(word);
			Guesser = new GuessWord(word); //initialize new guessing manager
			while (Guesser.isAlive()){
			System.out.print("Type a letter: ");
			letter = ScanObj.next(".").charAt(0); //take exactly one char:
			System.out.println(letter);
			Guesser.takeAGuess(letter);
			System.out.println(Guesser.displayStatus());

			}

		}

	}
}