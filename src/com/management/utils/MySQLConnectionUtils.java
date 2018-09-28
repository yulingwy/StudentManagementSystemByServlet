package com.management.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MySQLConnectionUtils {

	// 用于连接数据库的工具类
	public static ResultSet mySQLResult(String sql) {
		String path = MySQLConnectionUtils.class.getClassLoader().getResource("db.properties").getPath();
		FileInputStream in = null;
		Properties properties = new Properties();
		
		try {
			in = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			properties.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String user = properties.getProperty("jdbc.user");
		String password = properties.getProperty("jdbc.password");
		String driverClass = properties.getProperty("jdbc.driverClass");
		String url = properties.getProperty("jdbc.jdbcUrl");
		ResultSet rs = null;

		try {
			Class.forName(driverClass);
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(sql);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public static Connection mySQLConnection() {

		String path = MySQLConnectionUtils.class.getClassLoader().getResource("db.properties").getPath();
		FileInputStream in = null;
		Properties properties = new Properties();
		
		try {
			in = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			properties.load(in);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String user = properties.getProperty("jdbc.user");
		String password = properties.getProperty("jdbc.password");
		String driverClass = properties.getProperty("jdbc.driverClass");
		String url = properties.getProperty("jdbc.jdbcUrl");

		Connection connection = null;

		try {

			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}