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

    public String getOpenWeatherCurrentWeather(String cityName){
        return openWeatherClient.getOpenWeatherCurrentWeather(cityName);
    }

    public String getWeatherBitCurrentWeather(String cityName){
        return weatherBitClient.getWeatherBitCurrentWeather(cityName);
    }

    public String getWeatherStackCurrentWeather(String cityName){
        return weatherStackClient.getWeatherStackCurrentWeather(cityName);
    }



    private float calculateAverageTemperature(){
        float averageTemperature =
                openWeatherClient.getTemperature() + weatherBitClient.getTemperature() + weatherStackClient.getTemperature() /3;
        return averageTemperature;
    }

    private float calculateAverageHumidity(){
        float averageHumidity =
                openWeatherClient.getHumidity() + weatherBitClient.getHumidity() + weatherStackClient.getHumidity() /3;
        return averageHumidity;
    }

    private float calculateAveragePressure(){
        float averagePressure =
                openWeatherClient.getPressure() + weatherBitClient.getPressure() + weatherStackClient.getPressure() /3;
        return averagePressure;
    }

    private float calculateAverageWindSpeed(){
        float averageWindSpeed =
                openWeatherClient.getWindSpeed() + weatherBitClient.getWindSpeed() + weatherStackClient.getWindSpeed() /3;
        return averageWindSpeed;
    }

    private float calculateAverageWindDirection(){
        float averageWindDirection =
                openWeatherClient.getWindDirection() + weatherBitClient.getWindDirection() + weatherStackClient.getWindDirection() /3;
        return averageWindDirection;
    }

}
