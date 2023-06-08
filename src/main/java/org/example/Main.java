package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Strawberry");
        fruits.add("Grape");
        fruits.add("Watermelon");
        fruits.add("Pineapple");
        fruits.add("Mango");
        fruits.add("Cherry");
        fruits.add("Pear");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Fruits Guessing Game!");

            System.out.println("Fruits List:");
            displayFruitList(fruits);

            int randomIndex = random.nextInt(fruits.size());
            String selectedFruit = fruits.get(randomIndex);
            int remainingGuesses = 3;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the fruit!");

            while (remainingGuesses > 0) {
                System.out.print("Enter your guess: ");
                String guess = scanner.nextLine();

                if (guess.equalsIgnoreCase(selectedFruit)) {
                    // Correct guess
                    System.out.println("Congratulations! You guessed it right.");
                    fruits.remove(randomIndex);
                    guessedCorrectly = true;
                    break;
                } else {
                    // Incorrect guess
                    remainingGuesses--;

                    if (remainingGuesses == 2) {
                    // Provide clue – first letter of the word
                        System.out.println("Incorrect guess. Here’s a clue: The word starts with ‘" + selectedFruit.charAt(0) + "‘.");
                    } else if (remainingGuesses == 1) {
                        // Provide clue – number of letters in the word
                        System.out.println("Incorrect guess. Here’s another clue: The word has " + selectedFruit.length() + " letters.");
                    }

                    System.out.println("Remaining guesses: " + remainingGuesses);
                }
            }

            if (!guessedCorrectly) {
            // No more guesses left
                System.out.println("Sorry, you ran out of guesses. The word was: " + selectedFruit);
            }

            // Display the number of fruits remaining
            System.out.println("Fruits remaining in the list: " + fruits.size());

            // Ask the user if they want to play again
            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.nextLine();

            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            System.out.println();
        }

        System.out.println("Thank you for playing the Fruits Guessing Game!");
    }

    // Method to display the fruit list in a tabular format
    private static void displayFruitList(ArrayList<String> fruitList) {
        for (int i = 0; i < fruitList.size(); i++) {
            System.out.printf("%-15s", fruitList.get(i));

            if ((i + 1) % 3 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}