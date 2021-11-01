package backend.HttpCilents.OpenWeather;


import backend.HttpCilents.HttpClientConnector;
import com.google.gson.Gson;

public class OpenWeatherClient {
    private Gson gson;
    private HttpClientConnector httpClientConnector;
    private OpenWeatherDTO openWeatherDTO;
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

        String forecastMessage = String.format("\nCurrent weather OPENWEATHER for %s are %s \n" +
                        "↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ " +
                        "\n temperature: %s,\n pressure: %s,\n humidity: %s,\n wind speed: %s,\n wind direction: %s %s",
                cityName.toUpperCase(), description, temperature, pressure, humidity, windSpeed, windDirection, arrow);


        return forecastMessage;
    }
}
