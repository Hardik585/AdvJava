package com.hardik;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	protected static DataSource ds = null;

	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjava";
	private static final String DB_USER = "hardik";
	private static final String DB_PASS = "Hardik@123";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConncetion() throws SQLException, IOException {

		File file = new File("F:\\Adv JAVA\\Coding\\Pro-01-First-Book_Servlet-App\\src\\main\\java\\db.properties");
		FileInputStream fs = new FileInputStream(file);
		Properties ps = new Properties();
		ps.load(fs);

		String DRIVER2 = ps.getProperty("db.driver");

		if (ds == null) {
			HikariConfig config = new HikariConfig();
			config.setDriverClassName(DRIVER2);
			config.setJdbcUrl(DB_URL);
			config.setUsername(DB_USER);
			config.setPassword(DB_PASS);

			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}

}
