package backend;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class WeatherClient {

    private final String apiKey = "d2523d4ce5199ce659dcad17ce29e5ed";

    public void currentWeatherClient(String city) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + apiKey))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        OpenWeather openWeather = gson.fromJson(response.body(), OpenWeather.class);

        String currentWeather = "Current weather in: " + openWeather.getName() + "\n"
                + "Temperature: " + openWeather.getMain().getTemp() + " o Celsius\n"
                + "Pressure: " + openWeather.getMain().getPressure() + "hPa\n"
                + "Humidity: " + openWeather.getMain().getHumidity() + " %\n"
                + "Wind speed: " + openWeather.getWind().getSpeed() + "m/s, from direction " + openWeather.getWind().getDeg() + "\n"
                + "Current situation: " + openWeather.getWeather().get(0).getDescription();

        System.out.println(currentWeather);

    }
}
