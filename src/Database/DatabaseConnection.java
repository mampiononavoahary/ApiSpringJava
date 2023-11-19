package Database ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/"+System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public Connection CreateConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");


        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }
}
