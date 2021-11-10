package backend.HttpCilents.WeatherBit;

import backend.HttpCilents.HttpClientConnector;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class WeatherBitClient {


    private final Gson gson;
    private final HttpClientConnector httpClientConnector;
    private final WeatherBitDTO weatherBitDTO;
    private final String apiKey = "9943b74d5df149679b49dec61891605a";
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

    public WeatherBitClient(Gson gson, HttpClientConnector httpClientConnector, WeatherBitDTO weatherBitDTO) {
        this.gson = gson;
        this.httpClientConnector = httpClientConnector;
        this.weatherBitDTO = weatherBitDTO;
    }

    public String getWeatherBitCurrentWeather(String cityName) {
        String URL = String.format("https://api.weatherbit.io/v2.0/current?&city=%s&key=%s", cityName, apiKey);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);

        WeatherBitDTO weatherBitDTO = gson.fromJson(responseBody, WeatherBitDTO.class);
        String name = weatherBitDTO.getData().get(0).getCity_name();
        float temperature = weatherBitDTO.getData().get(0).getTemp();
        float pressure = weatherBitDTO.getData().get(0).getSlp();
        float humidity = weatherBitDTO.getData().get(0).getRh();
        float windSpeed = weatherBitDTO.getData().get(0).getWind_spd();
        float windDirection = weatherBitDTO.getData().get(0).getWind_dir();

        this.name = name;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;

        if(name == null){
            log.error("Cannot connect to WeatherBit API");
        } else if (name != null){
        log.info("Downloaded Data from WeatherBit API");
    }

        return null;
    }
}

