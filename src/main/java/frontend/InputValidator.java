package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private Scanner scanner = new Scanner(System.in);
    private final String WARNING_ONLY_LETTERS = Color.RED + ">>> Please type letter only with first being Capital! <<<" + Color.RESET;

    int retrievesInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.reset();
                scanner.nextLine();
                System.err.println(Color.RED + " \nPlease enter a number using only the digits 1 to 4");
            }
        }
    }

    String retrieveAndValidateLocation() {
        while (true) {
            String location = scanner.next();
            if (location.matches("[a-zA-Z+]+") || location.length() <= 2) {
                return location;
            } else {
                System.out.println(Color.RED + " \nPlease enter a letters only");
            }
        }
    }
}


