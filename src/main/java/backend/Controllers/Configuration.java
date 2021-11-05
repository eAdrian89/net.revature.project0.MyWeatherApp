package backend.Controllers;

public interface Configuration {
    String URL = "jdbc:mysql://localhost:3306/jdbc_schema?serverTimezone=Europe/Warsaw";
    String USER = "root";
    String PASSWORD = "Master89";

    String PGURL = "jdbc:postgresql://localhost:5432/postgres";
    String PGUSER = "some-postgres";
    String PGPASSWORD = "mysecretpassword";
}
