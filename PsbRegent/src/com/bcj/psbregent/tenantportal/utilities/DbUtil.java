package com.bcj.psbregent.tenantportal.utilities;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbUtil {
	private static Connection dbConnection = null;

	public static Connection getConnectionByDataSource() {
		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {

				Context initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("mydb");
				dbConnection = ds.getConnection();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;
		}
	}

	public static Connection getConnectionByDbProperties() {

		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
				

				InputStream inputStream = new FileInputStream(System.getenv("CATALINA_HOME")
						+"\\lib\\db.properties");
				Properties properties = new Properties();

				properties.load(inputStream);

				String dbDriver = properties.getProperty("dbDriver");
				String connectionUrl = properties.getProperty("connectionUrl");
				String userName = properties.getProperty("userName");
				String password = properties.getProperty("password");

				Class.forName(dbDriver).newInstance();
				dbConnection = DriverManager.getConnection(connectionUrl, userName, password);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;

		}

	}

	public static Connection getConnectionByHardCode() {

		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/psbregent", "root",
						"system");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;
		}
	}

}
