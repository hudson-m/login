package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import login.main;

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
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost/databasename", "hudson", "admin");
			// the mysql insert statement

			// create the mysql insert preparedstatement
			PreparedStatement ps2 = dbCon.prepareStatement(" insert into " + "user"
					+ " (nome, sobrenome, username, password, cpf)" + " values (?, ?, ?, ?, ?)");
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
		prepareStatement.main(null);

	}

	public void login() {
		System.out.println("User:");
		username = in.nextLine();

		System.out.println("Pass:");
		password = in.nextLine();

		String sql = "select * from user where username=? and password=?";
		try {
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost/databasename", "hudson", "admin");
			PreparedStatement ps3 = dbCon.prepareStatement(sql);
			ps3.setString(1, username);
			ps3.setString(2, password);
			ResultSet rs = ps3.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "username and password matched");
				System.out.println("Nome: "+rs.getString(2)+" "+rs.getString(3)+" \nUsuário: "+rs.getString(4)+" \nCPF: "+rs.getString(6));

			} else {
				JOptionPane.showMessageDialog(null, "username and password do not matched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
