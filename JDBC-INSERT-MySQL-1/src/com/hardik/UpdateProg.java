package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateProg {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";

	private static final String DB_USER = "hardik";

	private static final String DB_PASS = "Hardik@123";

	private static final String UPDATE_SQL = "UPDATE BOOKS SET book_name='AIML' WHERE book_id=102";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

		Statement stmt = con.createStatement();

		int count = stmt.executeUpdate(UPDATE_SQL);

		System.out.println("Rows Affected is :: " + count);

		con.close();
	}
}
