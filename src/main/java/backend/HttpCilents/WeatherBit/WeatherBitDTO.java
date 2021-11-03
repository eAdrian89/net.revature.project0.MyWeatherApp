package backend.HttpCilents.WeatherBit;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class WeatherBitDTO {
    private ArrayList<Data> data = new ArrayList<>();

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    class Data{
        private String city_name;
        private String valid_date;
        private float temp;
        private float wind_spd;
        private float wind_dir;
        private float slp;
        private float rh;

    }


}
