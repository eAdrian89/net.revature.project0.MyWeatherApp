package frontend;

import backend.Controllers.CurrentWeatherService;
import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;
import java.util.concurrent.TimeUnit;


public class UserInterface {
    private InputValidator inputValidator;
    private OpenWeatherClient openWeatherClient;
    private WeatherBitClient weatherBitClient;
    private WeatherStackClient weatherStackClient;
    private CurrentWeatherService currentWeatherService;

    private final String CHECK_CURRENT_WEATHER = "Enter City Name to check current weather";
    private final String CHECK_5_DAY_FORECAST = "Enter City Name to check 5 day forecast";
    private final String CHECK_PREVIOUS_REQUESTS = "Previous server responses";
    private final String CLOSE_APP_MESSAGE = "\nThank you for your time \n" + "Good Bay!";
    private final String WELCOME_MESSAGE = "\n" +
            "==================================================================== \n" +
            "Welcome to the [ϟϟϟ WEATHER SERVICE ϟϟϟ], what would you like to do? \n" +
            "====================================================================";

    private final String MAIN_MENU = "\n" +
            Color.BLUE + "1 => Check current Weather \n" + Color.RESET +
            Color.BLUE + "2 => Check 5 day forecast \n" + Color.RESET +
            Color.BLUE + "3 => Check search history \n" + Color.RESET +
            Color.RED + "4 => Close the application \n" + Color.RESET +
            Color.RESET + "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " + "\n";

    public UserInterface(InputValidator inputValidator, OpenWeatherClient openWeatherClient, WeatherBitClient weatherBitClient, WeatherStackClient weatherStackClient, CurrentWeatherService currentWeatherService) {
        this.inputValidator = inputValidator;
        this.openWeatherClient = openWeatherClient;
        this.weatherBitClient = weatherBitClient;
        this.weatherStackClient = weatherStackClient;
        this.currentWeatherService = currentWeatherService;
    }

    public void showMainMenu(){
        System.out.println(WELCOME_MESSAGE);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println(MAIN_MENU);
            int userInput = inputValidator.retrievesInteger();

            switch (userInput){
                case 1:
                   checkCurrentWeather();
                    break;
                case 2:
                    checkFiveDayForecast();
                    break;
                case 3:
                    checkSearchHistory();
                    break;
                case 4:
                    System.out.println(CLOSE_APP_MESSAGE);
                    return;
            }
        }
    }

    private void checkSearchHistory() {
    }

    private void checkFiveDayForecast() {
    }

    private void checkCurrentWeather() {
        System.out.println(CHECK_CURRENT_WEATHER);
        String cityName = inputValidator.retrieveAndValidateLocation();
        System.out.print("Checking current weather please wait");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".\n\n");
        String current = currentWeatherService.getOpenWeatherCurrentWeather(cityName) + currentWeatherService.getWeatherStackCurrentWeather(cityName) + currentWeatherService.getWeatherBitCurrentWeather(cityName);
        System.out.println(current);
    }


}

