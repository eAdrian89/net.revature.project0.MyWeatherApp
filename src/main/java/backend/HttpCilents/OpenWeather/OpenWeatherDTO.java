package backend.HttpCilents.OpenWeather;
import lombok.*;
import java.util.ArrayList;


@Data
public class OpenWeatherDTO {
    private ArrayList<Weather> weather = new ArrayList<>();
    private Main main;
    private Wind wind;
    private String name;

    @Data
    class Weather {
        private String description;
    }

    @Data
    class Main {
        private float temp;
        private float pressure;
        private float humidity;
    }

    @Data
    class Wind {
        private float speed;
        private float deg;
    }

}
