import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Set maximum number of guesses to 6
    final int maxGuess = 6;

    // Number of wrong guesses from the user
    int numWrongGuesses = 0;

    // Count the number of letters the user has guessed in the word
    // If the user has guessed all the letters, output winning message
    int numLettersGuessed = 0;

    // Stores the value of the user's guess
    String userGuess = "";

    Scanner in = new Scanner(System.in);
    Random rand = new Random();

    // Create array list
    ArrayList<String> words = new ArrayList<>();
    words.add("tree");
    words.add("rain");
    words.add("bear");
    words.add("encourage");
    words.add("promise");
    words.add("soup");
    words.add("chess");
    words.add("insurance");
    words.add("pancakes");
    words.add("stream");

    System.out.println("Welcome, let's play hangman!");

      // Get random integer for index
      int index = rand.nextInt(words.size()-1);

      // Get word to guess using index generated
      String wordToGuess = words.get(index);

      // Split the word to guess into a character array
      String[] wordToGuessSplit = wordToGuess.split("");

      // Print out number of blanks for word to guess so user knows
      // how long is the word
      System.out.print("\nHere is the word I am thinking of: ");
      for(int i=0; i<wordToGuessSplit.length; i++){
        System.out.print(" _ ");
      }

      // Declare new array to hold the correct guesses from the user so far
      String[] guessSoFar = new String[wordToGuessSplit.length];
      System.out.println("\n");

    do {
        System.out.print("Enter letter or word guess: ");
        userGuess = in.nextLine();

        // If user enters a word
        if(userGuess.length() > 1) {
          // If guess is the word
          if (wordToGuess.equalsIgnoreCase(userGuess)) {
            System.out.println("You've won! The word was " + wordToGuess + ".");
            break; // Break out of the loop
          }
          // Else add 1 to number of wrong guesses
          else{
            numWrongGuesses++;
            System.out.println("You have guessed incorrectly " + numWrongGuesses + "/" + maxGuess + " times.");
          }
        }

        // If user enters a letter
        else {
          int letterExists = 0;

          // Loop through character array to see if the letter the user
          // guessed is in the array
          for (int i = 0; i < wordToGuessSplit.length; i++) {
            if (wordToGuessSplit[i].equalsIgnoreCase(userGuess)) {
              guessSoFar[i] = userGuess.toLowerCase();
              letterExists++;
              numLettersGuessed++;
            }
          }

          if(numLettersGuessed == wordToGuess.length()){
            System.out.println("You've won! The word was " + wordToGuess + ".");
            break; // Break out of the loop
          }

          // If no letters were found matching the guess, then letterExists
          // would still be zero
          if (letterExists == 0) {
            numWrongGuesses++;
            System.out.println("You have guessed incorrectly " + numWrongGuesses + "/" + maxGuess + " times.");
          }
        }

        // If the max number of wrong guesses have been reached
        if(numWrongGuesses == maxGuess){
          System.out.println("Sorry, you have no more guesses left. The word " +
                  "was " + wordToGuess + ".");
          break; // Break out of the loop
        }

        // Else print out the word so far guessed by the user
        System.out.print("Your guess so far: ");
        for (int i = 0; i < guessSoFar.length; i++) {
          if (guessSoFar[i] == null) {
            System.out.print("_ ");
          }
          else {
            System.out.print(guessSoFar[i] + " ");
          }
        }

        System.out.println("\n");

    } while (numWrongGuesses < maxGuess);

    System.out.println("\nThank you for playing!");

  }
}
