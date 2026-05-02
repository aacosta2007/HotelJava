package hotel.infraestructure.out.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionMySQL {
    private final Connection connection;
    private static DataBaseConnectionMySQL intance;

    private static final  String URL = "jdbc:mysql://localhost:3306/hotel_java";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private DataBaseConnectionMySQL(){
        try {
            connection = DriverManager.getConnection(URL,USER, PASSWORD);

        }catch (SQLException e){
            throw new RuntimeException("Error connecting database");
        }
    }


    public static synchronized DataBaseConnectionMySQL getInstance(){
        if (intance == null){
            intance = new DataBaseConnectionMySQL();
        }
        return intance;
    }

    public Connection getConnection(){
        return connection;
    }
}
