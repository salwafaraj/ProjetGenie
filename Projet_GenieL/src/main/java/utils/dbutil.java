package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutil {

    private static final String URL = "jdbc:mysql://localhost:3306/genielogiciel";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static dbutil instance;
    private Connection connection;

    private dbutil() throws SQLException {

         this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static dbutil getInstance() throws SQLException {

                if (instance == null) {
                    instance = new dbutil();
                }
                return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("connection etablie");
        return conn;
    }
}
