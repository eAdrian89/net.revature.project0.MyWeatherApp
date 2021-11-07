package backend.HttpCilents.WeatherStack;

import backend.HttpCilents.HttpClientConnector;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherStackClient {

    private Logger logger = LoggerFactory.getLogger(WeatherStackClient.class);

    private Gson gson;
    private HttpClientConnector httpClientConnector;
    private WeatherStackDTO weatherStackDTO;
    private final String apiKey = "b5d3bdbf00429e7c87e9c48760877732";
    private String name;
    private float temperature;
    private float pressure;
    private float humidity;
    private float windSpeed;
    private float windDirection;


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

    public WeatherStackClient(Gson gson, HttpClientConnector httpClientConnector, WeatherStackDTO weatherStackDTO) {
        this.gson = gson;
        this.httpClientConnector = httpClientConnector;
        this.weatherStackDTO = weatherStackDTO;
    }

    public String getWeatherStackCurrentWeather(String cityName) {
        String URL = String.format("http://api.weatherstack.com/current?access_key=%s&query=%s&units=m", apiKey, cityName);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);


        WeatherStackDTO weatherStackDTO = gson.fromJson(responseBody, WeatherStackDTO.class);
        String name = weatherStackDTO.getLocation().getName();
        float temperature = weatherStackDTO.getCurrent().getTemperature();
        float pressure = weatherStackDTO.getCurrent().getPressure();
        float humidity = weatherStackDTO.getCurrent().getHumidity();
        float windSpeed = weatherStackDTO.getCurrent().getWind_speed();
        float windDirection = weatherStackDTO.getCurrent().getWind_degree();


        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;

        if(name == null){
            logger.error("Cannot connect to WeatherStack API");
        } else if (name != null){
        logger.info("Downloaded Data from WeatherStack API");
    }

        return null;
    }
}