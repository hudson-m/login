package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import login.connection;
import login.main;
import view.telas;

public class users extends telas{

	telas username;
	String password;

//	public boolean auth() { // pelo amor de deus, como que faz a verifica��o se ta certo
//		String sql = "select * from login where username=? and password=?";
//		try {
//			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost/testsql", "root", "");
//			PreparedStatement ps3 = dbCon.prepareStatement(sql);
//			ps3.setString(1, username);
//			ps3.setString(2, password);
//			ResultSet rs = ps3.executeQuery();
//			if (rs.next()) {
//				JOptionPane.showMessageDialog(null, "username and password matched");
//
//			} else {
//				JOptionPane.showMessageDialog(null, "username and password do not matched");
//			}
//		} catch (SQLException | HeadlessException ex) {
//			JOptionPane.showMessageDialog(null, ex);
//		}
//	}
}
