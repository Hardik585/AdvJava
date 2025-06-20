package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DelProg {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASS = "Hardik@123";
	private static final String DELETE_SQL = "DELETE FROM BOOKS WHERE book_id=104";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		Statement stmt = con.createStatement();

		int count = stmt.executeUpdate(DELETE_SQL);
		System.out.println("rows effect : " + count);

	}

}
