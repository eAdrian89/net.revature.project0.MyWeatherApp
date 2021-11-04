package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);


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
            scanner.reset();
            String location = scanner.next();
            location = location.replaceAll(" ", "+");
            if (location.matches("[a-zA-Z+]+") || location.length() <= 2) {
                return location;
            } else {
                System.out.println(Color.RED + " \nPlease enter a letters only");
            }
        }
    }
}


