import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    private static DataSource datasource;
    private static Connections instance;

    static Connections getInstance() {
        if (instance == null) {
            synchronized (Connections.class) {
                if (instance == null) {
                    instance = new Connections();
                }
            }
        }
        return instance;
    }


    Connection getConnection() throws SQLException {
        String location = "jdbc:mysql://127.0.0.1:3306/test";
        String user = "root";
        String pass = "1234";
        return DriverManager.getConnection(location, user, pass);
    }

    Connection getConnection2() throws SQLException {
        if (datasource == null) {
            String connectionString = "jdbc:mysql://127.0.0.1:3306/test";
            String username = "root";
            String password = "1234";
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(connectionString);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);
            basicDataSource.setMaxTotal(5);
            basicDataSource.setInitialSize(3);
            basicDataSource.setMaxWaitMillis(5000);

            datasource = basicDataSource;
        }
        return datasource.getConnection();
    }
}
