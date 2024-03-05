import java.util.Scanner;

public class Input {
    public static String getInput(Scanner scanner, String message) {
        while (true) {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();
            // Check if the input is empty or contains a decimal number
            if (input.isEmpty() || input.matches(".*\\d+\\.\\d+.*")) {
                System.err.println("Invalid input. Please enter a valid string.");
            } else {
                return (input); // Exit the loop if input is valid
            }
        }
    }

    // Function to get an int input
    public static int getIntInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter an integer.");
            }
        }
    }

    // Function to get a double input
    public static double getDoubleInput(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}