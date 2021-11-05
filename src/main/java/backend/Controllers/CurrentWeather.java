package backend.Controllers;

import lombok.Data;

@Data
public class CurrentWeather {

    private String Date;
    private String OWDescription;
    private String OWCity;

    //Average variables
    private float AVGTemperature;
    private float AVGHumidity;
    private float AVGPressure;
    private float AVGWindSpeed;
    private float AVGWindDirection;

}
