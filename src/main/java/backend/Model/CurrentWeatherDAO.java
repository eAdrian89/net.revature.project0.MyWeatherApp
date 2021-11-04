package backend.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static backend.Controllers.Configuration.*;

public class CurrentWeatherDAO {

    private final CurrentWeather currentWeather;
    Logger logger = LoggerFactory.getLogger(CurrentWeatherDAO.class);


    public CurrentWeatherDAO(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    private final String TABLE_CREATION = "CREATE TABLE IF NOT EXISTS WeatherHistory(" +
            "Id BIGINT NOT NULL AUTO_INCREMENT," +
            "Date DATETIME, " +
            "OWDescription VARCHAR(255)," +
            "OWCity VARCHAR(255)," +
            "AVGTemperature FLOAT(53)," +
            "AVGHumidity FLOAT(53)," +
            "AVGPressure FLOAT(53)," +
            "AVGWindSpeed FLOAT(53)," +
            "AVGWindDirection FLOAT(53)," +
            "PRIMARY KEY (Id)" +
            ");";

    private final String CREATE_WEATHER_QUERY = "INSERT INTO WeatherHistory(" +
            "Date, OWDescription, OWCity," +
            "AVGTemperature, AVGHumidity, AVGPressure, AVGWindSpeed, AVGWindDirection)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

    private final String FIND_SEARCH_HISTORY = "SELECT * From WeatherHistory ORDER BY Id DESC;";

    public void saveCurrentWeather() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_WEATHER_QUERY);
            preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(2, currentWeather.getOWDescription());
            preparedStatement.setString(3, currentWeather.getOWCity());
            preparedStatement.setFloat(4, currentWeather.getAVGTemperature());
            preparedStatement.setFloat(5, currentWeather.getAVGHumidity());
            preparedStatement.setFloat(6, currentWeather.getAVGPressure());
            preparedStatement.setFloat(7, currentWeather.getAVGWindSpeed());
            preparedStatement.setFloat(8, currentWeather.getAVGWindDirection());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            logger.error("Could not update data into Data Base");
        }
    }

    public List<CurrentWeather> checkSearchHistory() {
        List<CurrentWeather> searchHistory = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SEARCH_HISTORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CurrentWeather currentWeather = new CurrentWeather();
                currentWeather.setDate(resultSet.getString(2));
                currentWeather.setOWDescription(resultSet.getString(3));
                currentWeather.setOWCity(resultSet.getString(4));
                currentWeather.setAVGTemperature(resultSet.getFloat(5));
                currentWeather.setAVGHumidity(resultSet.getFloat(6));
                currentWeather.setAVGPressure(resultSet.getFloat(7));
                currentWeather.setAVGWindSpeed(resultSet.getFloat(8));
                currentWeather.setAVGWindDirection(resultSet.getFloat(9));
                searchHistory.add(currentWeather);
            }
        } catch (SQLException e) {
            logger.error("Could not receive data from Data Base");
        }
        return searchHistory;
    }
}
