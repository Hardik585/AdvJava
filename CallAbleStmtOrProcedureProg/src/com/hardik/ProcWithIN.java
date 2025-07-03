package com.hardik;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProcWithIN {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASSWORD = "Hardik@123";
	private static final String PROC_CALL = "call getEmpRecByDept(?)";

	public static void main(String[] args) throws SQLException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the dept name : ");
		String deptName = sc.nextLine();

		Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		CallableStatement cstmt = con.prepareCall(PROC_CALL);
		cstmt.setString(1, deptName);
		ResultSet rs = cstmt.executeQuery();
		while (rs.next()) {
			System.out.print("Emp id is : " + rs.getInt(1));
			System.out.print("		Emp name : " + rs.getString(2));
			System.out.print("		Emp work_location : " + rs.getString(3));
			System.out.print("		Emp dept is : " + rs.getString(4));
			System.out.print("		Emp gender : " + rs.getString(5));
			System.out.print("		emp address : " + rs.getString(6));
			System.out.print("		emp salary  : " + rs.getFloat(7));
			System.out.println();
		}
		con.close();
		sc.close();

	}
}
