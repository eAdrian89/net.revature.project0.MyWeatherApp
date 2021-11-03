package frontend;

import backend.Controllers.ConnectionController;
import backend.Controllers.CurrentWeatherService;
import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherBit.WeatherBitForecastClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;


public class UserInterface{
    private InputValidator inputValidator;
    private OpenWeatherClient openWeatherClient;
    private WeatherBitClient weatherBitClient;
    private WeatherStackClient weatherStackClient;
    private CurrentWeatherService currentWeatherService;
    private WeatherBitForecastClient weatherBitForecastClient;

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

    public UserInterface(InputValidator inputValidator, OpenWeatherClient openWeatherClient, WeatherBitClient weatherBitClient, WeatherStackClient weatherStackClient, CurrentWeatherService currentWeatherService, WeatherBitForecastClient weatherBitForecastClient) {
        this.inputValidator = inputValidator;
        this.openWeatherClient = openWeatherClient;
        this.weatherBitClient = weatherBitClient;
        this.weatherStackClient = weatherStackClient;
        this.currentWeatherService = currentWeatherService;
        this.weatherBitForecastClient = weatherBitForecastClient;
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

    private void checkSearchHistory(){

        ConnectionController connectionController = new ConnectionController();
        connectionController.createConnectionToDB();
    }

    private void checkFiveDayForecast() {
        System.out.println(CHECK_5_DAY_FORECAST);
        String cityName = inputValidator.retrieveAndValidateLocation();
        System.out.print("Checking 5 days weather please wait");
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
         weatherBitForecastClient.getWeatherBitForecastWeather(cityName);


        String dateToday = weatherBitForecastClient.getDateToday();
        String dateTodayPlusOne = weatherBitForecastClient.getDateTodayPlusOne();
        String dateTodayPlusTwo = weatherBitForecastClient.getDateTodayPlusTwo();
        String dateTodayPlusThree = weatherBitForecastClient.getDateTodayPlusThree();
        String dateTodayPlusFour = weatherBitForecastClient.getDateTodayPlusFour();

        float temperatureToday = weatherBitForecastClient.getTemperatureToday();
        float temperatureTodayPlusOne = weatherBitForecastClient.getTemperatureTodayPlusOne();
        float temperatureTodayPlusTwo = weatherBitForecastClient.getTemperatureTodayPlusTwo();
        float temperatureTodayPlusThree = weatherBitForecastClient.getTemperatureTodayPlusThree();
        float temperatureTodayPlusFour = weatherBitForecastClient.getTemperatureTodayPlusFour();

        float pressureToday = weatherBitForecastClient.getPressureToday();
        float pressureTodayPlusOne = weatherBitForecastClient.getPressureTodayPlusOne();
        float pressureTodayPlusTwo = weatherBitForecastClient.getPressureTodayPlusTwo();
        float pressureTodayPlusThree = weatherBitForecastClient.getPressureTodayPlusThree();
        float pressureTodayPlusFour = weatherBitForecastClient.getPressureTodayPlusFour();

        float humidityToday = weatherBitForecastClient.getHumidityToday();
        float humidityTodayPlusOne = weatherBitForecastClient.getHumidityTodayPlusOne();
        float humidityTodayPlusTwo = weatherBitForecastClient.getHumidityTodayPlusTwo();
        float humidityTodayPlusThree = weatherBitForecastClient.getHumidityTodayPlusThree();
        float humidityTodayPlusFour = weatherBitForecastClient.getHumidityTodayPlusFour();

        float windSpeedToday =weatherBitForecastClient.getWindSpeedToday();
        float windSpeedTodayPlusOne = weatherBitForecastClient.getWindSpeedTodayPlusOne();
        float windSpeedTodayPlusTwo = weatherBitForecastClient.getWindSpeedTodayPlusTwo();
        float windSpeedTodayPlusThree = weatherBitForecastClient.getWindSpeedTodayPlusThree();
        float windSpeedTodayPlusFour = weatherBitForecastClient.getWindSpeedTodayPlusFour();

        float windDirectionToday = weatherBitForecastClient.getWindDirectionToday();
        float windDirectionTodayPlusOne = weatherBitForecastClient.getWindDirectionTodayPlusOne();
        float windDirectionTodayPlusTwo = weatherBitForecastClient.getWindDirectionTodayPlusTwo();
        float windDirectionTodayPlusThree = weatherBitForecastClient.getWindDirectionTodayPlusThree();
        float windDirectionTodayPlusFour = weatherBitForecastClient.getWindDirectionTodayPlusFour();


        String arrowToday = null;
        if (windDirectionToday >= 337.5 && windDirectionToday <= 22.5) {
            arrowToday = "↑";
        }
        if (windDirectionToday >= 67.5 && windDirectionToday <= 112.5) {
            arrowToday = "→";
        }
        if (windDirectionToday >= 157.5 && windDirectionToday <= 202.5) {
            arrowToday = "↓";
        }
        if (windDirectionToday >= 247.5 && windDirectionToday <= 292.5) {
            arrowToday = "←";
        }
        if (windDirectionToday > 22.5 && windDirectionToday < 67.5) {
            arrowToday = "↗";
        }
        if (windDirectionToday > 112.5 && windDirectionToday < 157.5) {
            arrowToday = "↘";
        }
        if (windDirectionToday > 202.5 && windDirectionToday < 247.5) {
            arrowToday = "↙";
        }
        if (windDirectionToday > 292.5 && windDirectionToday < 337.5) {
            arrowToday = "↖";
        }

        String arrowTodayPlusOne = null;
        if (windDirectionTodayPlusOne >= 337.5 && windDirectionTodayPlusOne <= 22.5) {
            arrowTodayPlusOne = "↑";
        }
        if (windDirectionTodayPlusOne >= 67.5 && windDirectionTodayPlusOne <= 112.5) {
            arrowTodayPlusOne = "→";
        }
        if (windDirectionTodayPlusOne >= 157.5 && windDirectionTodayPlusOne <= 202.5) {
            arrowTodayPlusOne = "↓";
        }
        if (windDirectionTodayPlusOne >= 247.5 && windDirectionTodayPlusOne <= 292.5) {
            arrowTodayPlusOne = "←";
        }
        if (windDirectionTodayPlusOne > 22.5 && windDirectionTodayPlusOne < 67.5) {
            arrowTodayPlusOne = "↗";
        }
        if (windDirectionTodayPlusOne > 112.5 && windDirectionTodayPlusOne < 157.5) {
            arrowTodayPlusOne = "↘";
        }
        if (windDirectionTodayPlusOne > 202.5 && windDirectionTodayPlusOne < 247.5) {
            arrowTodayPlusOne = "↙";
        }
        if (windDirectionTodayPlusOne > 292.5 && windDirectionTodayPlusOne < 337.5) {
            arrowTodayPlusOne = "↖";
        }

        String arrowTodayPlusTwo = null;
        if (windDirectionTodayPlusTwo >= 337.5 && windDirectionTodayPlusTwo <= 22.5) {
            arrowTodayPlusTwo = "↑";
        }
        if (windDirectionTodayPlusTwo >= 67.5 && windDirectionTodayPlusTwo <= 112.5) {
            arrowTodayPlusTwo = "→";
        }
        if (windDirectionTodayPlusTwo >= 157.5 && windDirectionTodayPlusTwo <= 202.5) {
            arrowTodayPlusTwo = "↓";
        }
        if (windDirectionTodayPlusTwo >= 247.5 && windDirectionTodayPlusTwo <= 292.5) {
            arrowTodayPlusTwo = "←";
        }
        if (windDirectionTodayPlusTwo > 22.5 && windDirectionTodayPlusTwo < 67.5) {
            arrowTodayPlusTwo = "↗";
        }
        if (windDirectionTodayPlusTwo > 112.5 && windDirectionTodayPlusTwo < 157.5) {
            arrowTodayPlusTwo = "↘";
        }
        if (windDirectionTodayPlusTwo > 202.5 && windDirectionTodayPlusTwo < 247.5) {
            arrowTodayPlusTwo = "↙";
        }
        if (windDirectionTodayPlusTwo > 292.5 && windDirectionTodayPlusTwo < 337.5) {
            arrowTodayPlusTwo = "↖";
        }

        String arrowTodayPlusThree = null;
        if (windDirectionTodayPlusThree >= 337.5 && windDirectionTodayPlusThree <= 22.5) {
            arrowTodayPlusThree = "↑";
        }
        if (windDirectionTodayPlusThree >= 67.5 && windDirectionTodayPlusThree <= 112.5) {
            arrowTodayPlusThree = "→";
        }
        if (windDirectionTodayPlusThree >= 157.5 && windDirectionTodayPlusThree <= 202.5) {
            arrowTodayPlusThree = "↓";
        }
        if (windDirectionTodayPlusThree >= 247.5 && windDirectionTodayPlusThree <= 292.5) {
            arrowTodayPlusThree = "←";
        }
        if (windDirectionTodayPlusThree > 22.5 && windDirectionTodayPlusThree < 67.5) {
            arrowTodayPlusThree = "↗";
        }
        if (windDirectionTodayPlusThree > 112.5 && windDirectionTodayPlusThree < 157.5) {
            arrowTodayPlusThree = "↘";
        }
        if (windDirectionTodayPlusThree > 202.5 && windDirectionTodayPlusThree < 247.5) {
            arrowTodayPlusThree = "↙";
        }
        if (windDirectionTodayPlusThree > 292.5 && windDirectionTodayPlusThree < 337.5) {
            arrowTodayPlusThree = "↖";
        }

        String arrowTodayPlusFour = null;
        if (windDirectionTodayPlusFour >= 337.5 && windDirectionTodayPlusFour <= 22.5) {
            arrowTodayPlusFour = "↑";
        }
        if (windDirectionTodayPlusFour >= 67.5 && windDirectionTodayPlusFour<= 112.5) {
            arrowTodayPlusFour = "→";
        }
        if (windDirectionTodayPlusFour >= 157.5 && windDirectionTodayPlusFour <= 202.5) {
            arrowTodayPlusFour= "↓";
        }
        if (windDirectionTodayPlusFour >= 247.5 && windDirectionTodayPlusFour <= 292.5) {
            arrowTodayPlusFour = "←";
        }
        if (windDirectionTodayPlusFour > 22.5 && windDirectionTodayPlusFour < 67.5) {
            arrowTodayPlusFour = "↗";
        }
        if (windDirectionTodayPlusFour > 112.5 && windDirectionTodayPlusFour < 157.5) {
            arrowTodayPlusFour = "↘";
        }
        if (windDirectionTodayPlusFour > 202.5 && windDirectionTodayPlusFour < 247.5) {
            arrowTodayPlusFour = "↙";
        }
        if (windDirectionTodayPlusFour > 292.5 && windDirectionTodayPlusFour < 337.5) {
            arrowTodayPlusFour= "↖";
        }

        DecimalFormat df = new DecimalFormat("0.00");
        String forecastMessageToday = String.format("\nWeather forecast for %s \n at %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s\n",
                cityName.toUpperCase(), dateToday, df.format(temperatureToday), df.format(pressureToday), df.format(humidityToday), df.format(windSpeedToday), df.format(windDirectionToday), arrowToday);

        String forecastMessageTodayPlusOne = String.format("\n at %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s\n",
                dateTodayPlusOne, df.format(temperatureTodayPlusOne), df.format(pressureTodayPlusOne), df.format(humidityTodayPlusOne), df.format(windSpeedTodayPlusOne), df.format(windDirectionTodayPlusOne), arrowTodayPlusOne);

        String forecastMessageTodayPlusTwo = String.format("\n at %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s\n",
                dateTodayPlusTwo, df.format(temperatureTodayPlusTwo), df.format(pressureTodayPlusTwo), df.format(humidityTodayPlusTwo), df.format(windSpeedTodayPlusTwo), df.format(windDirectionTodayPlusTwo), arrowTodayPlusTwo);

        String forecastMessageTodayPlusThree = String.format("\n at %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s\n",
                dateTodayPlusThree, df.format(temperatureTodayPlusThree), df.format(pressureTodayPlusThree), df.format(humidityTodayPlusThree), df.format(windSpeedTodayPlusThree), df.format(windDirectionTodayPlusThree), arrowTodayPlusThree);

        String forecastMessageTodayPlusFour = String.format("\n at %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s\n",
                dateTodayPlusFour, df.format(temperatureTodayPlusFour), df.format(pressureTodayPlusFour), df.format(humidityTodayPlusFour), df.format(windSpeedTodayPlusFour), df.format(windDirectionTodayPlusFour), arrowTodayPlusFour);


        System.out.println(forecastMessageToday + forecastMessageTodayPlusOne + forecastMessageTodayPlusTwo + forecastMessageTodayPlusThree + forecastMessageTodayPlusFour);
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
        currentWeatherService.getOpenWeatherCurrentWeather(cityName);
        //currentWeatherService.getWeatherStackCurrentWeather(cityName);
        currentWeatherService.getWeatherBitCurrentWeather(cityName);

        String description = currentWeatherService.currentWeatherDescription();
        float temperature = currentWeatherService.calculateAverageTemperature();
        float humidity = currentWeatherService.calculateAverageHumidity();
        float pressure = currentWeatherService.calculateAveragePressure();
        float windSpeed = currentWeatherService.calculateAverageWindSpeed();
        float windDirection = currentWeatherService.calculateAverageWindDirection();

        String arrow = null;
        if (windDirection >= 337.5 && windDirection <= 22.5) {
            arrow = "↑";
        }
        if (windDirection >= 67.5 && windDirection <= 112.5) {
            arrow = "→";
        }
        if (windDirection >= 157.5 && windDirection <= 202.5) {
            arrow = "↓";
        }
        if (windDirection >= 247.5 && windDirection <= 292.5) {
            arrow = "←";
        }
        if (windDirection > 22.5 && windDirection < 67.5) {
            arrow = "↗";
        }
        if (windDirection > 112.5 && windDirection < 157.5) {
            arrow = "↘";
        }
        if (windDirection > 202.5 && windDirection < 247.5) {
            arrow = "↙";
        }
        if (windDirection > 292.5 && windDirection < 337.5) {
            arrow = "↖";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        String forecastMessage = String.format("\nCurrent Average weather for %s are %s \n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s",
                cityName.toUpperCase(), description.toUpperCase(), df.format(temperature), df.format(pressure), df.format(humidity), df.format(windSpeed), df.format(windDirection), arrow);

        System.out.println(forecastMessage);

    }


}

