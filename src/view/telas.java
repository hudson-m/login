package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import login.connection;
import login.main;
import models.users;

public class telas extends main {
	
	main prepareStatement = new main();
	Scanner in = new Scanner(System.in);
	String username, nome, sobrenome, password, cpf;

	public void cadastro() {

		System.out.println("Informe o teu nome:");
		nome = in.nextLine();

		System.out.println("Sobrenome");
		sobrenome = in.nextLine();

		System.out.println("usuario");
		username = in.nextLine();

		System.out.println("password");
		password = in.nextLine();

		System.out.println("CPF");
		cpf = in.nextLine();

		System.out.println("cab�!");

		try {
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost/?user=hudson&password=admin");
			// the mysql insert statement

			// create the mysql insert preparedstatement
			PreparedStatement ps2 = dbCon.prepareStatement(" insert into " + "user" + " (nome, sobrenome, username, password, cpf)"
					+ " values (?, ?, ?, ?, ?)");
			ps2.setString(1, nome);
			ps2.setString(2, sobrenome);
			ps2.setString(3, username);
			ps2.setString(4, password);
			ps2.setString(5, cpf);
			ps2.executeUpdate();
		      
			dbCon.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

	public void login() {
		System.out.println("User:");
		username = in.nextLine();

		System.out.println("Pass:");
		password = in.nextLine();

		users check = new users(username, password);

		if (check.auth()) // Se auth der boa, gg
		{
			System.out.println("Logadasso!");
			System.out.println("Informa�oes dos users");
		}
	}

}
