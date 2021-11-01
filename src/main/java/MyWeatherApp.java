import backend.Controllers.CurrentWeatherService;
import backend.HttpCilents.HttpClientConnector;
import backend.HttpCilents.HttpClientConnectorImpl;
import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.OpenWeather.OpenWeatherDTO;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherBit.WeatherBitDTO;
import backend.HttpCilents.WeatherStack.WeatherStackClient;
import backend.HttpCilents.WeatherStack.WeatherStackDTO;
import com.google.gson.Gson;
import frontend.InputValidator;
import frontend.UserInterface;




public class MyWeatherApp {
    private static UserInterface userInterface;

    static {
        InputValidator inputValidator = new InputValidator();
        HttpClientConnector httpClientConnector = new HttpClientConnectorImpl();
        Gson gson = new Gson();
        OpenWeatherDTO openWeatherDTO = new OpenWeatherDTO();
        WeatherBitDTO weatherBitDTO = new WeatherBitDTO();
        WeatherStackDTO weatherStackDTO = new WeatherStackDTO();
        OpenWeatherClient openWeatherClient = new OpenWeatherClient(gson,httpClientConnector, openWeatherDTO);
        WeatherBitClient weatherBitClient = new WeatherBitClient(gson,httpClientConnector,weatherBitDTO);
        WeatherStackClient weatherStackClient = new WeatherStackClient(gson, httpClientConnector,weatherStackDTO);
        CurrentWeatherService currentWeatherService = new CurrentWeatherService(openWeatherClient, weatherBitClient, weatherStackClient);
        UserInterface userInterface = new UserInterface(inputValidator,openWeatherClient,weatherBitClient, weatherStackClient, currentWeatherService);
        userInterface.showMainMenu();

    }

    public static void main(String[] args)  {


    }

}
