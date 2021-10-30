package frontend;

import backend.WeatherClient;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class UserInterface {

    public void ui() throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Welcome to MyWeather!");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("What do you want to do?");

        Scanner scanner = new Scanner(System.in);
        String menu = "1 - Check current weather\n"
                + "2 - Check daily forecast\n"
                + "3 - Close application\n";

        char response;
        do {
            System.out.println(menu);
            response = scanner.next().charAt(0);
            switch (response) {
                case '1':
                    checkWeather();
                    break;
                case '2':
                    //TODO
                    break;
                case '3':
                    System.out.println("Closing Down Bye Bye");
                    System.exit(0);
                default:
                    System.out.print("Incorrect input, try again \n \n");
                    TimeUnit.SECONDS.sleep(1);
            }
        } while (response != 1 || response != 2 || response != 3);

    }

    public void checkWeather() throws InterruptedException, URISyntaxException, IOException {
        System.out.println("Enter City");
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();
        city = city.replaceAll(" ", "+");
        if ((Pattern.matches("[a-zA-Z+]+", city) || city.length() <= 2)) {
            System.out.print("Checking current weather please wait");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".\n\n");

            WeatherClient weatherClient = new WeatherClient();
            weatherClient.currentWeatherClient(city);

        } else
            System.out.println("Entered value is not valid try again");
    }
}

