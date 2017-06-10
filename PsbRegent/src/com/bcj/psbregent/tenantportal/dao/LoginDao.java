package com.bcj.psbregent.tenantportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bcj.psbregent.tenantportal.model.Login;
import com.bcj.psbregent.tenantportal.utilities.DbUtil;

/**
 * This class is used to connect to the database and perform some search,update
 * operations and returns the result back to the Service layer
 * 
 * @author Bootcamp User 021
 *
 */
public class LoginDao {
	
	final static Logger logger = Logger.getLogger(LoginDao.class);
	public static Connection dbConnection;
	public String dbconnectionType = "properties";

	/**
	 * Here we are getting the dbConnection based on the dbConnectionType.
	 * 
	 * @param dbconnectionType
	 */
	public static void setDbConnectionType(String dbconnectionType) {
		
		PropertyConfigurator.configure("log4j.properties");

		if (dbconnectionType.equals("properties"))
			dbConnection = DbUtil.getConnectionByDbProperties();
		if (dbconnectionType.equals("dbhardcode"))
			dbConnection = DbUtil.getConnectionByHardCode();
		if (dbconnectionType.equals("datasource"))
			dbConnection = DbUtil.getConnectionByDataSource();

	}

	/**
	 * 
	 * This method contains a SQL query to check whether the given logindetails
	 * present in the database or not.
	 * 
	 * @param loginDetails
	 * @return
	 */
	public static boolean authenticateUser(Login loginDetails) {

		try {
			PropertyConfigurator.configure("log4j.properties");
			
			LoginDao.setDbConnectionType("properties");
			String query1 = "select Password from login where UserId=?";

			PreparedStatement stmt1 = dbConnection.prepareStatement(query1);
			stmt1.setString(1, loginDetails.getUserId());

			ResultSet rs = stmt1.executeQuery();
			logger.info("This is info : rahul" );

			if (rs.next())
				if (loginDetails.getPassword().equals(rs.getString("Password")))
					return true;

			return false;

		}

		catch (Exception e) {

			System.out.println(e);
			logger.error("This is info : " , e);
			return false;

		}

		/*finally {

			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		}

	}


