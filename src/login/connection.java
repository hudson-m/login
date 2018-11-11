package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
    private String jdbcDriver = "com.mysql.jdbc.Driver";
    public String dbName = "user";
    public String table;
    
    public PreparedStatement prestmt;
    private Statement stmt;
    private ResultSet result;
    private Connection con;
	
	public connection(){
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"", "hudson", "admin");
			stmt = con.prepareStatement("INSERT INTO user	VALUES(nome,sobrenome,cpf,username,password)");
			
		}catch(	Exception e)
			{System.out.println(e);}
	}

	private void createDatabase() {
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"", "root", "");
            Statement s = con.createStatement();
            int myResult = s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	
	

    public void createTableCub1() {
    	
        table = "CREATE TABLE IF NOT EXISTS user ( " + 
        		"        idNo INT(64) NOT NULL AUTO_INCREMENT, " + 
        		"        nome VARCHAR(20) NOT NULL," + 
        		"        sobrenome VARCHAR(20) NOT NULL," + 
        		"        username VARCHAR(20) NOT NULL," +
        		"        password VARCHAR(128) NOT NULL," +
        		"        cpf VARCHAR(11) NOT NULL, PRIMARY KEY (`idNo`))";  
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"", "root", "");
            stmt = con.createStatement();
            //The next line has the issue
            stmt.executeUpdate(table);
            System.out.println("Table Created");
        }
        catch (SQLException e ) {
            System.out.println("An error has occurred on Table Creation");
        }
        catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
    }
}
