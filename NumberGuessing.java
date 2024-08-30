import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_ROUNDS = 3;
    private static int totalScore = 0;
    private static int currentRound = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (currentRound <= MAX_ROUNDS) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + currentRound + ": Guess the number between 1 and 100.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number.");
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            int points = calculatePoints(attempts, guessedCorrectly);
            totalScore += points;
            System.out.println("Points scored this round: " + points);
            System.out.println("Total score: " + totalScore);
            System.out.println("-------------------------------------------------");

            currentRound++;
        }

        System.out.println("Game Over! Your final score: " + totalScore);
    }

    private static int calculatePoints(int attempts, boolean guessedCorrectly) {
        if (guessedCorrectly) {
            return Math.max(0, (MAX_ATTEMPTS - attempts + 1) * 10);
        } else {
            return 0;
        }
    }
}