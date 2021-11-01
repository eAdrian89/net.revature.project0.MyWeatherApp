package backend.HttpCilents.WeatherStack;

import lombok.Data;

@Data
public class WeatherStackDTO {
    private Current current;
    private Location location;

    @Data
    class Location {
        private String name;
    }

    @Data
    class Current {
        private float temperature;
        private float wind_speed;
        private float wind_degree;
        private float pressure;
        private float humidity;
    }

}
