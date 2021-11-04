package backend.Controllers;

import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;
import backend.Model.CurrentWeather;


public class CurrentWeatherService {
    private final OpenWeatherClient openWeatherClient;
    private final WeatherBitClient weatherBitClient;
    private final WeatherStackClient weatherStackClient;
    private final CurrentWeather currentWeather;

    public CurrentWeatherService(OpenWeatherClient openWeatherClient, WeatherBitClient weatherBitClient, WeatherStackClient weatherStackClient, CurrentWeather currentWeather) {
        this.openWeatherClient = openWeatherClient;
        this.weatherBitClient = weatherBitClient;
        this.weatherStackClient = weatherStackClient;
        this.currentWeather = currentWeather;
    }

    public String getOpenWeatherCurrentWeather(String cityName) {
        return openWeatherClient.getOpenWeatherCurrentWeather(cityName);
    }

    public String getWeatherBitCurrentWeather(String cityName) {
        return weatherBitClient.getWeatherBitCurrentWeather(cityName);
    }

    public String getWeatherStackCurrentWeather(String cityName) {
        return weatherStackClient.getWeatherStackCurrentWeather(cityName);
    }

    public void save() {
        currentWeather.setOWDescription(openWeatherClient.getDescription());
        currentWeather.setOWCity(openWeatherClient.getName());
        currentWeather.setAVGTemperature(calculateAverageTemperature());
        currentWeather.setAVGHumidity(calculateAverageHumidity());
        currentWeather.setAVGPressure(calculateAveragePressure());
        currentWeather.setAVGWindSpeed(calculateAverageWindSpeed());
        currentWeather.setAVGWindDirection(calculateAverageWindDirection());
    }

    public float calculateAverageTemperature() {
        float averageTemperature =
                (openWeatherClient.getTemperature() +
                        weatherBitClient.getTemperature() +
                        weatherStackClient.getTemperature()) / 2;
        return averageTemperature;
    }

    public float calculateAverageHumidity() {
        float averageHumidity =
                (openWeatherClient.getHumidity() +
                        weatherBitClient.getHumidity() +
                        weatherStackClient.getHumidity()) / 2 ;
        return averageHumidity;
    }

    public float calculateAveragePressure() {
        float averagePressure =
                (openWeatherClient.getPressure() +
                        weatherBitClient.getPressure() +
                        weatherStackClient.getPressure()) / 2;
        return averagePressure;
    }

    public float calculateAverageWindSpeed() {
        float averageWindSpeed =
                (openWeatherClient.getWindSpeed() +
                        weatherBitClient.getWindSpeed() +
                        weatherStackClient.getWindSpeed()) / 2;
        return averageWindSpeed;
    }

    public float calculateAverageWindDirection() {
        float averageWindDirection =
                (openWeatherClient.getWindDirection() +
                        weatherBitClient.getWindDirection() +
                        weatherStackClient.getWindDirection()) / 2;
        return averageWindDirection;
    }

    public String currentWeatherDescription(){
        String currentDescription = openWeatherClient.getDescription();
        return currentDescription;
    }
}
