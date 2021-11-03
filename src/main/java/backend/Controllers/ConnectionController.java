package backend.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import static backend.Controllers.Configuration.*;

public class ConnectionController {

    public void createConnectionToDB() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "CREATE TABLE IF NOT EXISTS WeatherHistory(" +
                "Id BIGINT NOT NULL," +
                "Date DATETIME, " +
                "OWDescription VARCHAR(255)," +
                "OWCity VARCHAR(255)," +
                "OWTemperature FLOAT(53)," +
                "OWHumidity FLOAT(53)," +
                "OWPressure FLOAT(53)," +
                "OWWindSpeed FLOAT(53)," +
                "OWWindDirection FLOAT(53)," +
                "WBTemperature FLOAT(53)," +
                "WBHumidity FLOAT(53)," +
                "WBPressure FLOAT(53)," +
                "WBWindSpeed FLOAT(53)," +
                "WBWindDirection FLOAT(53)," +
                "WSTemperature FLOAT(53)," +
                "WSHumidity FLOAT(53)," +
                "WSPressure FLOAT(53)," +
                "WSWindSpeed FLOAT(53)," +
                "WSWindDirection FLOAT(53)," +
                "AVGTemperature FLOAT(53)," +
                "AVGHumidity FLOAT(53)," +
                "AVGPressure FLOAT(53)," +
                "AVGWindSpeed FLOAT(53)," +
                "AVGWindDirection FLOAT(53)" +
                ");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
