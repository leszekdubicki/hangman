/*
Main application class for HANGMAN project in JAVA
Author:	Leszek Dubicki
email:	Leszek.Dubicki@student.ncirl.ie
ID:	x14125439
*/
//import GuessMe.GuessMe;
public class Hangman{
	public static void main(String args[]){
		Executioner E= new Executioner();
		System.out.println(E.hang(7));
		WordsCollection W = new WordsCollection();
		System.out.println(W.getRandomWord());
	}
}