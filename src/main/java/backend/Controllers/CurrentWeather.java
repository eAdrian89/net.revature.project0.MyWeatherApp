package backend.Controllers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrentWeather {



    private Long id;
    private LocalDateTime localDateTime;

    //OpenWeather variables
    private String OWDescription;
    private String OWCity;
    private float OWTemperature;
    private float OWHumidity;
    private float OWPressure;
    private float OWWindSpeed;
    private float OWWindDirection;

    //WeatherBit variables
    private float WBTemperature;
    private float WBHumidity;
    private float WBPressure;
    private float WBWindSpeed;
    private float WBWindDirection;

    //WeatherStack variables
    private float WSTemperature;
    private float WSHumidity;
    private float WSPressure;
    private float WSWindSpeed;
    private float WSWindDirection;

    //Average variables
    private float AVGTemperature;
    private float AVGHumidity;
    private float AVGPressure;
    private float AVGWindSpeed;
    private float AVGWindDirection;
}
