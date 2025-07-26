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

	public static Connection getConnection() throws SQLException, IOException {

		if (ds == null) {

			File file = new File("F:\\Adv JAVA\\Coding\\RequestDispatcherApp2\\src\\main\\java\\db.properties");
			FileInputStream fs = new FileInputStream(file);
			Properties ps = new Properties();
			ps.load(fs);
			String driver = ps.getProperty("db.driver");
			String url = ps.getProperty("db.url");
			String userName = ps.getProperty("db.username");
			String pass = ps.getProperty("db.password");
			
			HikariConfig config = new HikariConfig();
			config.setDriverClassName(driver);
			config.setJdbcUrl(url);
			config.setUsername(userName);
			config.setPassword(pass);
			
			ds =new HikariDataSource(config);
		}

		return ds.getConnection();
	}
}
