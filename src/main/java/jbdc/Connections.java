package jbdc;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    private static Connections instance;

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static DataSource datasource;

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


   protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

   protected Connection getConnection2() throws SQLException {
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
