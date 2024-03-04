import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        String playAgain;

        // Game loop
        do {
            // Initial roll
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            // Display roll result
            System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum);

            // Check initial roll outcome
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("Point is set to " + sum);
                int point = sum;

                // Subsequent rolls until a win or loss
                while (true) {
                    int roll1 = rnd.nextInt(6) + 1;
                    int roll2 = rnd.nextInt(6) + 1;
                    int rollSum = roll1 + roll2;

                    // Display subsequent roll result
                    System.out.println("Roll: Die 1 = " + roll1 + ", Die 2 = " + roll2 + ", Sum = " + rollSum);

                    if (rollSum == point) {
                        System.out.println("Made point! You win!");
                        break;
                    } else if (rollSum == 7) {
                        System.out.println("Seven out! You lose!");
                        break;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }

            // Prompt the user to play again
            System.out.println("Do you want to play again? (Y/N)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        scanner.close();
    }
}
