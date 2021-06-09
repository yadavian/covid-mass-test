package com.covid.util;

import java.sql.*;

public class DBConnectionUtil {
	public static final String URL = "jdbc:mysql://localhost:3306/covid_mass_test?useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static Connection connection = null;

	public static Connection openConnection() throws SQLException, ClassNotFoundException {
		if (connection != null) {
			return connection;
		} else {
			Class.forName(DRIVER);
			System.out.println("loaded");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connected");
		}
		return connection;
	}
}
