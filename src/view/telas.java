package view;

import java.sql.Statement;
import java.util.Scanner;
import login.connection;
import models.users;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class telas extends connection {
	Connection con;

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
			// the mysql insert statement
			String query = " insert into " + dbName + " (nome, sobrenome, username, password, cpf)"
					+ " values (?, ?, ?, ?, ?)";

			// create the mysql insert preparedstatement
			PreparedStatement prestmt = con.prepareStatement(query);
			prestmt.setString(1, nome);
			prestmt.setString(2, sobrenome);
			prestmt.setString(3, username);
			prestmt.setString(4, password);
			prestmt.setString(5, cpf);
			prestmt.execute();
		      
		    con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (prestmt != null) {
				try {
					prestmt.close();
				} catch (Exception ignored) {
				}
			}
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
