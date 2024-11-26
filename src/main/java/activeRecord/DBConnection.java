package activeRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private String userName = "root";
    private static String password = "";
    private static String serverName = "127.0.0.1";
    private static String portNumber = "3306";
    private static String tableName = "personne";
    private static String dbName = "testpersonne";
    private String urlDB;
    private static Connection instance;


    private DBConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        urlDB = "jdbc:mysql://" + serverName + ":";
        urlDB += portNumber + "/" + dbName;
        instance = DriverManager.getConnection(urlDB, connectionProps);
    }

    public static synchronized Connection getConnection() {
        if (instance==null){
            try{
                new DBConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static void setNomDB(String nomDB) {
        instance = null;
        dbName = nomDB;
    }
}
