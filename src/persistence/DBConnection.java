package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	
	private static String host = "localhost";
    private static String user = "root";
    private static String password = "root" ;
    private static String port = "3306";
    private static String database = "db_arqref" ;
    private static Connection connection;

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static PreparedStatement prepareStatement(String sql) {
        try {
            DBConnection.connect();
            return connection.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     public static void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void runSQLScript(String fileName) {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            String line = reader.readLine();
//            String sql = "";
//
//            while(line != null){
//                sql += line;
//                line = reader.readLine();
//            }
//            database = "";
//            connect();
//            Statement stmt = connection.createStatement();
//            String[] script = sql.split(";");
//
//            for (String string : script) {
//                stmt.execute(string);
//            }
//            close();
//            database = "StudioVip";
//            reader.close();
//        } catch (Exception ex) {
//            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
