package com.hardik;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {

	public static void main(String[] args) throws SQLException {
		HikariConfig config = new HikariConfig();

		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/advjava");
		config.setUsername("root");
		config.setPassword("ROOTA");

		config.setMaximumPoolSize(4);
		config.setMinimumIdle(1);

		DataSource ds = new HikariDataSource(config);

		Connection con = ds.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from employ");
		while (rs.next()) {
			System.out.println(rs.getString(3));
		}
		rs.close();
		con.close();
	}
}
