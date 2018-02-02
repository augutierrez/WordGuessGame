/**
 *
 * @author Student Name
 * @version 1.0
 * @since -DATE FINISHED-
 * Hangman.java
 *
 * This program allows a user to play Hangman with the computer.
 * --EXPLAIN THE RULES--
 * 
 */
import java.util.*;
import java.lang.*;

public class Hangman 
{

	static String movieList[] = {"Star Wars: The Last Jedi","The Matrix","Avatar"}; 
	// add more to this list by adding more String Literals separated by commas


	/**
	 * Entry point of the program
	 * 
	 * @param args input arguments
 	 * 
  	 */
	public static void main(String[] args)
	{
		// This code snippet just shows you how to use Stringbuilder. 
		// Change the code as you see fit.
		StringBuilder currentGuess = new StringBuilder(movieList[0].length());
		System.out.println(movieList[0]);
		

	}
}
