
import backend.Controllers.Configuration;
import backend.Controllers.CurrentWeatherService;
import backend.HttpCilents.HttpClientConnector;
import backend.HttpCilents.HttpClientConnectorImpl;
import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.OpenWeather.OpenWeatherDTO;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherBit.WeatherBitDTO;
import backend.HttpCilents.WeatherBit.WeatherBitForecastClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;
import backend.HttpCilents.WeatherStack.WeatherStackDTO;
import backend.Controllers.CurrentWeather;
import backend.Controllers.CurrentWeatherDAO;
import com.google.gson.Gson;
import frontend.InputValidator;
import frontend.UserInterface;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyWeatherApp {

    static {
        InputValidator inputValidator = new InputValidator();
        HttpClientConnector httpClientConnector = new HttpClientConnectorImpl();
        Gson gson = new Gson();
        OpenWeatherDTO openWeatherDTO = new OpenWeatherDTO();
        WeatherBitDTO weatherBitDTO = new WeatherBitDTO();
        WeatherStackDTO weatherStackDTO = new WeatherStackDTO();
        OpenWeatherClient openWeatherClient = new OpenWeatherClient(gson, httpClientConnector, openWeatherDTO);
        WeatherBitClient weatherBitClient = new WeatherBitClient(gson, httpClientConnector, weatherBitDTO);
        WeatherStackClient weatherStackClient = new WeatherStackClient(gson, httpClientConnector, weatherStackDTO);
        WeatherBitForecastClient weatherBitForecastClient = new WeatherBitForecastClient(gson, httpClientConnector, weatherBitDTO);
        CurrentWeather currentWeather = new CurrentWeather();
        CurrentWeatherDAO currentWeatherDAO = new CurrentWeatherDAO(currentWeather);
        CurrentWeatherService currentWeatherService = new CurrentWeatherService(openWeatherClient, weatherBitClient, weatherStackClient, currentWeather);
        UserInterface userInterface = new UserInterface(inputValidator, currentWeatherService, weatherBitForecastClient, currentWeather, currentWeatherDAO);
        userInterface.showMainMenu();

    }

    public static void main(String[] args) {


    }

}
