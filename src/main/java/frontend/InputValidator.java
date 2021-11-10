package frontend;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);


    int retrievesInteger() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.reset();
                scanner.nextLine();
                System.out.println(Color.RED + " \nPlease enter a number using only the digits 1 to 4");
                log.info("Input Mismatch Exception");
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
                log.info("Input Mismatch Exception");
            }
        }
    }
}