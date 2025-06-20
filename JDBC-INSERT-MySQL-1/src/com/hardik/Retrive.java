package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Retrive {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASS = "Hardik@123";
//	private static final String RETRIVE_SQL = "SELECT *  FROM BOOKS WHERE book_id=103";
	private static final String RETRIVE_SQL = "SELECT *  FROM BOOKS ";

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(RETRIVE_SQL);

//	  For single retrieval
//		if (rs.next()) {
//			int book_id = rs.getInt("book_id");
//			String book_name = rs.getString("book_name");
//			double book_price = rs.getDouble("book_price");
//			System.out.println(book_id + " | " + book_name + " | " + book_price);
//		} else {
//			System.out.println("no rec found");
//		}

//	   For multiple retrieval
		while (rs.next()) {
			int book_id = rs.getInt("book_id");
			String book_name = rs.getString("book_name");
			double book_price = rs.getDouble("book_price");
			System.out.println(book_id + " | " + book_name + " | " + book_price);
		}

		con.close();

	}

}
