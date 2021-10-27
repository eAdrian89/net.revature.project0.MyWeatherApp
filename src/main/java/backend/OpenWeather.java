package backend;
import lombok.*;
import java.util.ArrayList;


@Data
public class OpenWeather {
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
        private String temp;
        private String pressure;
        private String humidity;
    }

    @Data
    class Wind {
        private String speed;
        private String deg;
    }

}
