package view;
import java.util.Scanner;
import login.main;
import models.users;

import java.util.Scanner;

public class telas {
	Scanner in = new Scanner(System.in);
	String username, nome, sobrenome, password;
	long cpf;
	public void cadastro(){

		
		System.out.println("Informe o teu nome:");
		nome = in.nextLine();
		
		System.out.println("Sobrenome");
		sobrenome = in.nextLine();
		
		System.out.println("CPF");
		cpf = in.nextLong();
		
		System.out.println("usuario");
		username = in.nextLine();
		
		System.out.println("password");
		password = in.nextLine();
		
		System.out.println("cabô!");
			
	}
	
	public void login() {
		System.out.println("User:");
		username = in.nextLine();
		
		System.out.println("Pass:");
		password = in.nextLine();
		
		users check = new users(username, password);
		
		if(check.auth()) // Se auth der boa, gg
		{
			System.out.println("Logadasso!");
			System.out.println("Informaçoes dos users");
		}
	}
	
}
