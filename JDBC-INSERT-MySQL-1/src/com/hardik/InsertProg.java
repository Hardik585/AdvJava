package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class InsertProg {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASSWORD = "Hardik@123";
	private static final String INSERT = "INSERT INTO BOOKs VALUES(104 , 'Tester' , 50.95)";

	public static void main(String[] args) throws Exception {
		// Step-1 load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step-2 create the connection with the help of DriverManager class
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		// Step-3 create statement
		Statement stmt = con.createStatement();

		// step-4 execute query
		int noOFRowAffected = stmt.executeUpdate(INSERT);

		// step-5 count the no of rows affected
		System.out.println("no of rows Affected is :: " + noOFRowAffected);

		// step-6 close the connection
		con.close();

	}
}
