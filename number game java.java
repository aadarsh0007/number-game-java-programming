import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = generateRandomNumber(minRange, maxRange);
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    score++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("The number is greater than " + userGuess + ".");
                } else {
                    System.out.println("The number is less than " + userGuess + ".");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("You have exhausted all " + maxAttempts + " attempts.");
                System.out.println("The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = sc.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");
        }

        System.out.println("Your final score: " + score + " rounds won.");
        System.out.println("Thanks for playing!");
    }

    private static int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
