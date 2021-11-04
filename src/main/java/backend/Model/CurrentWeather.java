package backend.Model;

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


//   List<CurrentWeather> weatherList = currentWeatherDAO.checkSearchHistory();
//    for (int i = 0; i < weatherList.size(); i++) {
//       System.out.println("Forecast checked at: " +  weatherList.get(i).getDate() + ", For City " + weatherList.get(i).getOWCity() + ", Conditions " + weatherList.get(i).getOWDescription() + ", Temperature " + weatherList.get(i).getAVGTemperature() + ", Humidity " + weatherList.get(i).getAVGHumidity() + ", Pressure " + weatherList.get(i).getAVGPressure() + ", Wind Speed " + weatherList.get(i).getAVGWindSpeed() + ", Wind Direction " + weatherList.get(i).getAVGWindDirection());
//   }