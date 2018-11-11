package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import view.telas;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		telas roda = new telas();
		String dbName = "user";
		int select;
		
        String dbURL = "jdbc:mysql://localhost:3306/"+dbName;
        String username ="root";
        String password = "";
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        Statement stmt;
        
        try {
        	
        	Class.forName(jdbcDriver);
            //getting database connection to MySQL server
        	Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost/?user=hudson&password=admin");
        	PreparedStatement ps = dbCon.prepareStatement("CREATE DATABASE IF NOT EXISTS databasename");
        	dbCon = DriverManager.getConnection("jdbc:mysql://localhost/databasename","hudson","admin");
        	ps.executeUpdate();
        	dbCon.prepareStatement("CREATE TABLE IF NOT EXISTS user ( " + 
            		"        idNo INT(64) NOT NULL AUTO_INCREMENT, " + 
            		"        nome VARCHAR(20) NOT NULL," + 
            		"        sobrenome VARCHAR(20) NOT NULL," + 
            		"        username VARCHAR(20) NOT NULL," +
            		"        password VARCHAR(128) NOT NULL," +
            		"        cpf VARCHAR(11) NOT NULL, PRIMARY KEY (`idNo`))");  
        	ps.executeUpdate();
            
            try {
                
                dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName+"", "hudson", "admin");
                stmt = dbCon.createStatement();
                //The next line has the issue
                System.out.println("Table Created");
            }
            catch (SQLException e ) {
                System.out.println("An error has occurred on Table Creation");
            }
            
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);;
        } 

		System.out.println("BORA\nDeseja logar[0] ou registrar[1]?");
		select = in.nextInt();
		
		if(select == 0) {
			roda.login();
		}
		
		if(select == 1) {
			roda.cadastro();
		}
		in.close();
	}

}
