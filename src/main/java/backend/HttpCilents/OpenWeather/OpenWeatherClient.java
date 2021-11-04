package backend.HttpCilents.OpenWeather;


import backend.HttpCilents.HttpClientConnector;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenWeatherClient {
    private Logger logger = LoggerFactory.getLogger(OpenWeatherClient.class);

    private final Gson gson;
    private final HttpClientConnector httpClientConnector;
    private final OpenWeatherDTO openWeatherDTO;
    private final String apiKey = "d2523d4ce5199ce659dcad17ce29e5ed";
    private String name;
    private float temperature;
    private float pressure;
    private float humidity;
    private float windSpeed;
    private float windDirection;
    private String description;


    public String getName() {
        return name;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindDirection() {
        return windDirection;
    }

    public String getDescription() {
        return description;
    }

    public OpenWeatherClient(Gson gson, HttpClientConnector httpClientConnector, OpenWeatherDTO openWeatherDTO){
        this.gson = gson;
        this.httpClientConnector = httpClientConnector;
        this.openWeatherDTO = openWeatherDTO;
    }

    public String getOpenWeatherCurrentWeather(String cityName){
        String URL = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s", cityName, apiKey);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);

        OpenWeatherDTO openWeatherDTO = gson.fromJson(responseBody, OpenWeatherDTO.class);
        String name = openWeatherDTO.getName();
        float temperature = openWeatherDTO.getMain().getTemp();
        float pressure = openWeatherDTO.getMain().getPressure();
        float humidity = openWeatherDTO.getMain().getHumidity();
        float windSpeed = openWeatherDTO.getWind().getSpeed();
        float windDirection = openWeatherDTO.getWind().getDeg();
        String description = openWeatherDTO.getWeather().get(0).getDescription();

        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.description = description;

        if(name == null){
            logger.error("Cannot connect to OpenWeather API");
        }

        return null;
    }
}
