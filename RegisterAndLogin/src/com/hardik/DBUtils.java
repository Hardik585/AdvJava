package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";

	private static final String DB_USER = "hardik";

	private static final String DB_PASS = "Hardik@123";

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
}
