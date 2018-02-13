/**
 *
 * @author Antonio Gutierrez
 * @version 1.0
 * @since 2/12/2018
 * Hangman.java
 *
 * This program allows a user to play Hangman with the computer.
 * --EXPLAIN THE RULES--
 * You get 7 mistakes, guess the right letters without reaching the 7 mistakes and you win
 */

import java.util.*;
import java.lang.*;

public class Hangman 
{
	//This is an array of Strings
	static String movieList[] = {"Star Wars: The Last Jedi","The Matrix","Avatar","Lilo and Stitch", "Spider Man", "The Hulk", "Black Panther", "Nacho Libre", "Spy Kids", "It", "Toy Story", "Transformers", "Insidious", "Saving Private Ryan", "Batman Begins"}; 
	
	/**
	 * Entry point of the program
	 * 
	 * @param args input arguments
 	 * 
  	 */

	public static void main(String[] args)
	{
		// I create the variable guesses that keeps track of how many guess the user makes.
		int guesses = 1;
		// scanner created to get user input
		Scanner scan = new Scanner(System.in);
		
		//the string builder, will allow me to replace letters later
		StringBuilder currentGuess = new StringBuilder(movieList[1].length());
		

		//random generator, gets a random index from my list of movies
		Random generator = new Random();
		int number = generator.nextInt(15);
		
		//this appends asterics that fill the length of the movie.
		for (int i = 0; i < movieList[number].length(); i ++){
			currentGuess.append("*");
		}
		// assigning the movie name to the variable 'word'	
		String word = movieList[number].toLowerCase();
		if (word.indexOf(":") >= 0){
			int index2 = word.indexOf(" ");
			while (index2 >= 0) {
   				currentGuess.replace(index2,index2 + 1, ":");
   				index2 = word.indexOf(":", index2 + 1);
   			}
   		}
		// I add the spaces where they should be, that way the user doesn't have to guess for spaces
		int index = word.indexOf(" ");
		while (index >= 0) {
   			currentGuess.replace(index,index + 1, " ");
   			index = word.indexOf(" ", index + 1);
		}
		// start of the game
		System.out.println("--THE RULES-- \n 1) This program allows a user to play Hangman with the computer. \n 2) You get 7 tries, guess the right letters without using up all 7 guesses and you win! \n 3) Enter ONE letter at a time!");

		//prints out the updated asterics string for the user
		System.out.println(currentGuess);

		while (guesses <= 7){
			System.out.println("Guess a letter.");
			// l is the letter they guess
			String l = scan.nextLine();
			// checks if the letter is in the word, if it is, it replaces the asterics with the letter guessed
			int index1 = word.indexOf(l);
			if (word.indexOf(l) >= 0){
				while (index1 >= 0) {
		   			currentGuess.replace(index1,index1 + 1, l);
		   			index1 = word.indexOf(l, index1 + 1);
		   		}
		   		// prints out the updated word
		   		System.out.println(currentGuess);
		   	}
		   	else {
		   		// incase the letter isn't in the title, it outputs this instead
		   		System.out.println(l + " is not in the movie title! This is guess #" + guesses);
		   		guesses++;
		   	}
		   	// checks if you have discovered the whole title, if you have I add to the number of guesses at the end to get out of the while loop!
		   	if (currentGuess.indexOf("*")< 0){
		   		System.out.println("You got it! It took: " + guesses + " tries!");
		   		guesses = guesses + 7;
		   	}
		   }
   	}		
}