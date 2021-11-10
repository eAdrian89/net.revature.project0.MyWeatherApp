package backend.HttpCilents.WeatherBit;

import backend.HttpCilents.HttpClientConnector;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;



public class WeatherBitForecastClient {

    private final Gson gson;
    private final HttpClientConnector httpClientConnector;
    private final WeatherBitDTO weatherBitDTO;
    private final String apiKey = "9943b74d5df149679b49dec61891605a";
    private String name;
    private String dateToday;
    private String dateTodayPlusOne;
    private String dateTodayPlusTwo;
    private String dateTodayPlusThree;
    private String dateTodayPlusFour;
    private float temperatureToday;
    private float temperatureTodayPlusOne;
    private float temperatureTodayPlusTwo;
    private float temperatureTodayPlusThree;
    private float temperatureTodayPlusFour;
    private float pressureToday;
    private float pressureTodayPlusOne;
    private float pressureTodayPlusTwo;
    private float pressureTodayPlusThree;
    private float pressureTodayPlusFour;
    private float humidityToday;
    private float humidityTodayPlusOne;
    private float humidityTodayPlusTwo;
    private float humidityTodayPlusThree;
    private float humidityTodayPlusFour;
    private float windSpeedToday;
    private float windSpeedTodayPlusOne;
    private float windSpeedTodayPlusTwo;
    private float windSpeedTodayPlusThree;
    private float windSpeedTodayPlusFour;
    private float windDirectionToday;
    private float windDirectionTodayPlusOne;
    private float windDirectionTodayPlusTwo;
    private float windDirectionTodayPlusThree;
    private float windDirectionTodayPlusFour;

    public String getName() {
        return name;
    }

    public String getDateToday() {
        return dateToday;
    }

    public String getDateTodayPlusOne() {
        return dateTodayPlusOne;
    }

    public String getDateTodayPlusTwo() {
        return dateTodayPlusTwo;
    }

    public String getDateTodayPlusThree() {
        return dateTodayPlusThree;
    }

    public String getDateTodayPlusFour() {
        return dateTodayPlusFour;
    }

    public float getTemperatureToday() {
        return temperatureToday;
    }

    public float getTemperatureTodayPlusOne() {
        return temperatureTodayPlusOne;
    }

    public float getTemperatureTodayPlusTwo() {
        return temperatureTodayPlusTwo;
    }

    public float getTemperatureTodayPlusThree() {
        return temperatureTodayPlusThree;
    }

    public float getTemperatureTodayPlusFour() {
        return temperatureTodayPlusFour;
    }

    public float getPressureToday() {
        return pressureToday;
    }

    public float getPressureTodayPlusOne() {
        return pressureTodayPlusOne;
    }

    public float getPressureTodayPlusTwo() {
        return pressureTodayPlusTwo;
    }

    public float getPressureTodayPlusThree() {
        return pressureTodayPlusThree;
    }

    public float getPressureTodayPlusFour() {
        return pressureTodayPlusFour;
    }

    public float getHumidityToday() {
        return humidityToday;
    }

    public float getHumidityTodayPlusOne() {
        return humidityTodayPlusOne;
    }

    public float getHumidityTodayPlusTwo() {
        return humidityTodayPlusTwo;
    }

    public float getHumidityTodayPlusThree() {
        return humidityTodayPlusThree;
    }

    public float getHumidityTodayPlusFour() {
        return humidityTodayPlusFour;
    }

    public float getWindSpeedToday() {
        return windSpeedToday;
    }

    public float getWindSpeedTodayPlusOne() {
        return windSpeedTodayPlusOne;
    }

    public float getWindSpeedTodayPlusTwo() {
        return windSpeedTodayPlusTwo;
    }

    public float getWindSpeedTodayPlusThree() {
        return windSpeedTodayPlusThree;
    }

    public float getWindSpeedTodayPlusFour() {
        return windSpeedTodayPlusFour;
    }

    public float getWindDirectionToday() {
        return windDirectionToday;
    }

    public float getWindDirectionTodayPlusOne() {
        return windDirectionTodayPlusOne;
    }

    public float getWindDirectionTodayPlusTwo() {
        return windDirectionTodayPlusTwo;
    }

    public float getWindDirectionTodayPlusThree() {
        return windDirectionTodayPlusThree;
    }

    public float getWindDirectionTodayPlusFour() {
        return windDirectionTodayPlusFour;
    }

    public WeatherBitForecastClient(Gson gson, HttpClientConnector httpClientConnector, WeatherBitDTO weatherBitDTO) {
        this.gson = gson;
        this.httpClientConnector = httpClientConnector;
        this.weatherBitDTO = weatherBitDTO;
    }

    public ArrayList getWeatherBitForecastWeather(String cityName) {
        String URL = String.format("https://api.weatherbit.io/v2.0/forecast/daily?city=%s&Days=5&key=%s", cityName, apiKey);
        String responseBody = httpClientConnector.initializeHttpConnection(URL);

        WeatherBitDTO weatherBitDTO = gson.fromJson(responseBody, WeatherBitDTO.class);

        JsonParser jsonParser = new JsonParser();
        JsonObject jo = (JsonObject)jsonParser.parse(responseBody);
        JsonArray jsonArray = jo.getAsJsonArray("data");
        ArrayList forecast =gson.fromJson(jsonArray, ArrayList.class);


        //Today
        String name = weatherBitDTO.getData().get(0).getCity_name();
        String dateToday = weatherBitDTO.getData().get(0).getValid_date();
        float temperatureToday = weatherBitDTO.getData().get(0).getTemp();
        float pressureToday = weatherBitDTO.getData().get(0).getSlp();
        float humidityToday = weatherBitDTO.getData().get(0).getRh();
        float windSpeedToday = weatherBitDTO.getData().get(0).getWind_spd();
        float windDirectionToday = weatherBitDTO.getData().get(0).getWind_dir();

        //Today + 1 Day
        String dateTodayPlusOne = weatherBitDTO.getData().get(1).getValid_date();
        float temperatureTodayPlusOne = weatherBitDTO.getData().get(1).getTemp();
        float pressureTodayPlusOne = weatherBitDTO.getData().get(1).getSlp();
        float humidityTodayPlusOne = weatherBitDTO.getData().get(1).getRh();
        float windSpeedTodayPlusOne = weatherBitDTO.getData().get(1).getWind_spd();
        float windDirectionTodayPlusOne = weatherBitDTO.getData().get(1).getWind_dir();

        //Today + 2 Days
        String dateTodayPlusTwo = weatherBitDTO.getData().get(2).getValid_date();
        float temperatureTodayPlusTwo = weatherBitDTO.getData().get(2).getTemp();
        float pressureTodayPlusTwo = weatherBitDTO.getData().get(2).getSlp();
        float humidityTodayPlusTwo = weatherBitDTO.getData().get(2).getRh();
        float windSpeedTodayPlusTwo = weatherBitDTO.getData().get(2).getWind_spd();
        float windDirectionTodayPlusTwo = weatherBitDTO.getData().get(2).getWind_dir();

        //Today + 3 Days
        String dateTodayPlusThree = weatherBitDTO.getData().get(3).getValid_date();
        float temperatureTodayPlusThree = weatherBitDTO.getData().get(3).getTemp();
        float pressureTodayPlusThree = weatherBitDTO.getData().get(3).getSlp();
        float humidityTodayPlusThree = weatherBitDTO.getData().get(3).getRh();
        float windSpeedTodayPlusThree = weatherBitDTO.getData().get(3).getWind_spd();
        float windDirectionTodayPlusThree = weatherBitDTO.getData().get(3).getWind_dir();

        //Today + 4 Days
        String dateTodayPlusFour = weatherBitDTO.getData().get(4).getValid_date();
        float temperatureTodayPlusFour = weatherBitDTO.getData().get(4).getTemp();
        float pressureTodayPlusFour = weatherBitDTO.getData().get(4).getSlp();
        float humidityTodayPlusFour = weatherBitDTO.getData().get(4).getRh();
        float windSpeedTodayPlusFour = weatherBitDTO.getData().get(4).getWind_spd();
        float windDirectionTodayPlusFour = weatherBitDTO.getData().get(4).getWind_dir();


        this.name = name;
        this.dateToday = dateToday;
        this.dateTodayPlusOne = dateTodayPlusOne;
        this.dateTodayPlusTwo = dateTodayPlusTwo;
        this.dateTodayPlusThree = dateTodayPlusThree;
        this.dateTodayPlusFour = dateTodayPlusFour;
        this.temperatureToday = temperatureToday;
        this.temperatureTodayPlusOne = temperatureTodayPlusOne;
        this.temperatureTodayPlusTwo = temperatureTodayPlusTwo;
        this.temperatureTodayPlusThree = temperatureTodayPlusThree;
        this.temperatureTodayPlusFour = temperatureTodayPlusFour;
        this.pressureToday = pressureToday;
        this.pressureTodayPlusOne = pressureTodayPlusOne;
        this.pressureTodayPlusTwo = pressureTodayPlusTwo;
        this.pressureTodayPlusThree = pressureTodayPlusThree;
        this.pressureTodayPlusFour = pressureTodayPlusFour;
        this.humidityToday = humidityToday;
        this.humidityTodayPlusOne = humidityTodayPlusOne;
        this.humidityTodayPlusTwo = humidityTodayPlusTwo;
        this.humidityTodayPlusThree = humidityTodayPlusThree;
        this.humidityTodayPlusFour = humidityTodayPlusFour;
        this.windSpeedToday = windSpeedToday;
        this.windSpeedTodayPlusOne = windSpeedTodayPlusOne;
        this.windSpeedTodayPlusTwo = windSpeedTodayPlusTwo;
        this.windSpeedTodayPlusThree = windSpeedTodayPlusThree;
        this.windSpeedTodayPlusFour = windSpeedTodayPlusFour;
        this.windDirectionToday = windDirectionToday;
        this.windDirectionTodayPlusOne = windDirectionTodayPlusOne;
        this.windDirectionTodayPlusTwo = windDirectionTodayPlusTwo;
        this.windDirectionTodayPlusThree = windDirectionTodayPlusThree;
        this.windDirectionTodayPlusFour = windDirectionTodayPlusFour;

        return forecast;

    }
}
