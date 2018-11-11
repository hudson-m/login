package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class users {

	private String username;
	private String password;
	private String[][] accounts = {{"jesper", "abc123"},{"batata","batata"}};


	

	public users(String user, String pass) {
		username = user;
		password = pass;
	}

	public boolean auth() { // pelo amor de deus, como que faz a verifica��o se ta certo
		if ((username.equals(accounts[0][0])) && (password.equals(accounts[0][1])))
			return true;
		else
			return false;
	}
}
