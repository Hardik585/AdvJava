package com.hardik;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/AdvJava";
	private static final String DB_USER = "hardik";
	private static final String DB_Pass = "Hardik@123";

	public static Connection getConnection() throws Exception{
		Class.forName(DRIVER);
		return DriverManager.getConnection(DB_URL, DB_USER, DB_Pass);
	}
}
