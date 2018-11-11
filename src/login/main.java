package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import view.telas;
import models.users;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		telas roda = new telas();
		int select;
		
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
