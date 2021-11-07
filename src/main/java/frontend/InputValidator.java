package frontend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);
    private Logger logger = LoggerFactory.getLogger(InputValidator.class);


    int retrievesInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.reset();
                scanner.nextLine();
                System.out.println(Color.RED + " \nPlease enter a number using only the digits 1 to 4");
                logger.info("Input Mismatch Exception");
            }
        }
    }

    String retrieveAndValidateLocation() {
        while (true) {
            scanner.nextLine();
            String location = scanner.nextLine();
            location = location.replaceAll(" ", "+");
            if (location.matches("[a-zA-Z+]+") || location.length() <= 2) {
                return location;
            } else {
                System.out.println(Color.RED + " \nPlease enter a letters only");
                logger.info("Input Mismatch Exception");
            }
        }
    }
}