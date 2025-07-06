package com.hardik;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SalaryIncAccToDept {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASSWORD = "Hardik@123";
	private static final String UPDATE_SQL = "call incSalaryAccToDept(? , ? )";

	public static int callProcedure(CallableStatement cstmt, float hikePer, String deptName) throws SQLException {
		cstmt.setFloat(1, hikePer);
		cstmt.setString(2, deptName);
		return cstmt.executeUpdate();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("ENter the hike for the backend dept : ");
		float hikePerForBack = sc.nextFloat();

		System.out.println("ENter the hike for the frontend dept : ");
		float hikePerForFront = sc.nextFloat();

		System.out.println("ENter the hike for the sales dept : ");
		float hikePerForSales = sc.nextFloat();

		System.out.println("ENter the hike for the hr dept : ");
		float hikePerForHr = sc.nextFloat();

		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			CallableStatement cstmt = con.prepareCall(UPDATE_SQL);

			int totalRowAffect = 0;

			if (hikePerForBack > 0) {
				totalRowAffect += callProcedure(cstmt, hikePerForBack, "Backend");
			}

			if (hikePerForFront > 0) {
				totalRowAffect += callProcedure(cstmt, hikePerForFront, "Frontend");
			}
			if (hikePerForSales > 0) {
				totalRowAffect += callProcedure(cstmt, hikePerForSales, "sales");
			}
			if (hikePerForHr > 0) {
				totalRowAffect += callProcedure(cstmt, hikePerForHr, "hr");
			}
			System.out.println("no of rows Affected : " + totalRowAffect);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			sc.close();
		}

	}

}
