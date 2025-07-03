package com.hardik;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProcWithOutInOut {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASSWORD = "Hardik@123";
	private static final String PROC_CALL = "call getBookData()";

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		CallableStatement calStmt = con.prepareCall(PROC_CALL);
		ResultSet rs = calStmt.executeQuery(PROC_CALL);
		while (rs.next()) {
			System.out.print("BOOK id is : " + rs.getInt(1));
			System.out.print("  BOOK name is : " + rs.getString(2));
			System.out.print("  BOOK price is : " + rs.getFloat(3));
			System.out.println();
		}
		con.close();
	}
}
