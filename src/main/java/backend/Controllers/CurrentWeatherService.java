package backend.Controllers;

import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;


public class CurrentWeatherService {
    private OpenWeatherClient openWeatherClient;
    private WeatherBitClient weatherBitClient;
    private WeatherStackClient weatherStackClient;


    public CurrentWeatherService(OpenWeatherClient openWeatherClient, WeatherBitClient weatherBitClient, WeatherStackClient weatherStackClient) {
        this.openWeatherClient = openWeatherClient;
        this.weatherBitClient = weatherBitClient;
        this.weatherStackClient = weatherStackClient;
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




    public String getAverageCurrentWeather() {
        String avgHumidity = String.valueOf(calculateAverageHumidity());
        String avgPressure = String.valueOf(calculateAveragePressure());
        String avgTemperature = String.valueOf(calculateAverageTemperature());
        String avgWindDirection = String.valueOf(calculateAverageWindDirection());
        String avgWindSpeed = String.valueOf(calculateAverageWindSpeed());


        return "avgHumidity " + avgHumidity + "avgPressure " + avgPressure + "avgTemperature " + avgTemperature + "avgWindDirection " + avgWindDirection + "avgWindSpeed " + avgWindSpeed;
    }

    public String currentWeatherDescription(){
        String currentDescription = openWeatherClient.getDescription();
        return currentDescription;
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



}
