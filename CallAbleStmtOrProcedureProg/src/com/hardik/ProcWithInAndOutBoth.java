package com.hardik;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcWithInAndOutBoth {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASSWORD = "Hardik@123";
	private static final String PROC_CALL = "call getbooknamebyprice(? , ? )";

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the max price or your budget :  ");
		float bPrice = sc.nextFloat();

		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		CallableStatement cstmt = con.prepareCall(PROC_CALL);
		cstmt.setFloat(1, bPrice);

		cstmt.registerOutParameter(2, Types.VARCHAR);

		ResultSet rs = cstmt.executeQuery();

		while (rs.next()) {
			System.out.println("Book name is : " + rs.getString(1));
		}

		con.close();
		sc.close();
	}
}
