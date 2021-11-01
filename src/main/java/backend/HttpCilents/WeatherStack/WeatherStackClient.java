package backend.HttpCilents.WeatherStack;

import backend.HttpCilents.HttpClientConnector;

import com.google.gson.Gson;

public class WeatherStackClient {

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

        String forecastMessage = String.format("\nCurrent weather WEATHERSTACK for %s\n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s",
                cityName.toUpperCase(), temperature, pressure, humidity, windSpeed, windDirection, arrow);


        return forecastMessage;
    }
}