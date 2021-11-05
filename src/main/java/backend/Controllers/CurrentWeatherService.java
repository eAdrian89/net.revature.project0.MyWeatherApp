package backend.Controllers;

import backend.HttpCilents.OpenWeather.OpenWeatherClient;
import backend.HttpCilents.WeatherBit.WeatherBitClient;
import backend.HttpCilents.WeatherStack.WeatherStackClient;


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
        int avgCounter = 0;
        if(openWeatherClient.getTemperature() != 0){
            avgCounter++;
            if(weatherBitClient.getTemperature() != 0){
                avgCounter++;
                if(weatherStackClient.getTemperature() !=0){
                    avgCounter++;
                }
            }
        }
        float averageTemperature =
                (openWeatherClient.getTemperature() +
                        weatherBitClient.getTemperature() +
                        weatherStackClient.getTemperature()) / avgCounter;
        return averageTemperature;
    }

    public float calculateAverageHumidity() {
        int avgCounter = 0;
        if(openWeatherClient.getHumidity() != 0){
            avgCounter++;
            if(weatherBitClient.getHumidity() != 0){
                avgCounter++;
                if(weatherStackClient.getHumidity() !=0){
                    avgCounter++;
                }
            }
        }
        float averageHumidity =
                (openWeatherClient.getHumidity() +
                        weatherBitClient.getHumidity() +
                        weatherStackClient.getHumidity()) / avgCounter;
        return averageHumidity;
    }

    public float calculateAveragePressure() {
        int avgCounter = 0;
        if(openWeatherClient.getPressure() != 0){
            avgCounter++;
            if(weatherBitClient.getPressure() != 0){
                avgCounter++;
                if(weatherStackClient.getPressure() !=0){
                    avgCounter++;
                }
            }
        }
        float averagePressure =
                (openWeatherClient.getPressure() +
                        weatherBitClient.getPressure() +
                        weatherStackClient.getPressure()) / avgCounter;
        return averagePressure;
    }

    public float calculateAverageWindSpeed() {
        int avgCounter = 0;
        if (openWeatherClient.getWindSpeed() != 0) {
            avgCounter++;
            if (weatherBitClient.getWindSpeed() != 0) {
                avgCounter++;
                if (weatherStackClient.getWindSpeed() != 0) {
                    avgCounter++;
                }
            }
        }
        float averageWindSpeed =
                (openWeatherClient.getWindSpeed() +
                        weatherBitClient.getWindSpeed() +
                        weatherStackClient.getWindSpeed()) / avgCounter;
        return averageWindSpeed;
    }

    public float calculateAverageWindDirection() {
        int avgCounter = 0;
        if (openWeatherClient.getWindDirection() != 0) {
            avgCounter++;
            if (weatherBitClient.getWindDirection() != 0) {
                avgCounter++;
                if (weatherStackClient.getWindDirection() != 0) {
                    avgCounter++;
                }
            }
        }
        float averageWindDirection =
                (openWeatherClient.getWindDirection() +
                        weatherBitClient.getWindDirection() +
                        weatherStackClient.getWindDirection()) / avgCounter;
        return averageWindDirection;
    }

    public String currentWeatherDescription() {
        String currentDescription = openWeatherClient.getDescription();
        return currentDescription;
    }
}
