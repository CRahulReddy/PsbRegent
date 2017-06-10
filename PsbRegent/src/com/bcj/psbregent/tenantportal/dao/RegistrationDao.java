package com.bcj.psbregent.tenantportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bcj.psbregent.tenantportal.model.Company;
import com.bcj.psbregent.tenantportal.model.Login;
import com.bcj.psbregent.tenantportal.model.Tenant;
import com.bcj.psbregent.tenantportal.utilities.DbUtil;

/**
 * This class is used to connect to the database and perform some search,update
 * operations and returns the result back to the Service layer
 * 
 * @author Bootcamp User 021
 *
 */
public class RegistrationDao {
	
	
	final static Logger logger = Logger.getLogger(RegistrationDao.class);


	public static Connection dbConnection;
	public static String dbconnectionType = "properties";

	/**
	 * Here we are getting the dbConnection based on the dbConnectionType.
	 * 
	 * @param dbconnectionType
	 */
	public static void setDbConnectionType(String dbConnectionType) {
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("This is info : " + dbconnectionType);
		
		if (dbConnectionType.equals("properties"))
			dbConnection = DbUtil.getConnectionByDbProperties();
		if (dbConnectionType.equals("dbhardcode"))
			dbConnection = DbUtil.getConnectionByHardCode();
		if (dbConnectionType.equals("datasource"))
			dbConnection = DbUtil.getConnectionByDataSource();

	}

	/**
	 * This method contains SQL queries to store the tenant details in the
	 * database.
	 * 
	 * @param companyDetails
	 * @param tenantDetails
	 * @param loginDetials
	 * @return
	 */
	public int registerTenant(Company companyDetails, Tenant tenantDetails, Login loginDetials) {

		int companyAdressId = 0, tenantAddressId = 0, loginId = 0, tenantId = 0;

		try {
			RegistrationDao.setDbConnectionType("properties");

			String sql1 = "insert into Address(AddressLine1,AddressLine2,City,State,Zip) values(?,?,?,?,?)";
			PreparedStatement stmt1 = dbConnection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

			stmt1.setString(1, companyDetails.getCompanyAddress().getAddressLine1());
			stmt1.setString(2, companyDetails.getCompanyAddress().getAddressLine2());
			stmt1.setString(3, companyDetails.getCompanyAddress().getCity());
			stmt1.setString(4, companyDetails.getCompanyAddress().getState());
			stmt1.setString(5, companyDetails.getCompanyAddress().getZip());
			stmt1.executeUpdate();

			ResultSet rs1 = stmt1.getGeneratedKeys();

			if (rs1 != null && rs1.next()) {

				companyAdressId = rs1.getInt(1);

			}

			String sql2 = "insert into Login(UserId,Password) values(?,?)";
			PreparedStatement stmt2 = dbConnection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);

			stmt2.setString(1, loginDetials.getUserId());
			stmt2.setString(2, loginDetials.getPassword());
			stmt2.executeUpdate();

			ResultSet rs2 = stmt2.getGeneratedKeys();
			if (rs2 != null && rs2.next()) {
				loginId = rs2.getInt(1);
			}

			/*
			 * String sql3=
			 * "insert into Address(AddressLine1,AddressLine2,City,State,Zip) values(?,?,?,?,?)"
			 * ; PreparedStatement stmt3=dbConnection.prepareStatement(sql3,
			 * Statement.RETURN_GENERATED_KEYS);
			 * stmt3.setString(1,tenantDetails.getTenantAddress().
			 * getAddressLine1());
			 * stmt3.setString(2,tenantDetails.getTenantAddress().
			 * getAddressLine2());
			 * stmt3.setString(3,tenantDetails.getTenantAddress().getCity());
			 * stmt3.setString(4,tenantDetails.getTenantAddress().getState());
			 * stmt3.setString(5,tenantDetails.getTenantAddress().getZip());
			 * stmt3.executeUpdate();
			 * 
			 * ResultSet rs3 = stmt3.getGeneratedKeys(); if (rs3 != null &&
			 * rs3.next()) { tenantAddressId = rs3.getInt(1); }
			 */

			String sql4 = "insert into tenant (TenantFirstName,TenantLastName,TenantEmail,TenantPhone) values(?,?,?,?)";
			PreparedStatement stmt4 = dbConnection.prepareStatement(sql4, Statement.RETURN_GENERATED_KEYS);

			stmt4.setString(1, tenantDetails.getTenantfirstName());
			stmt4.setString(2, tenantDetails.getTenantLastName());
			stmt4.setString(3, tenantDetails.getTenantEmail());
			stmt4.setString(4, tenantDetails.getTenantPhone());
			// stmt4.setInt(5,tenantAddressId);
			stmt4.executeUpdate();

			ResultSet rs4 = stmt4.getGeneratedKeys();

			if (rs4 != null && rs4.next()) {

				tenantId = rs4.getInt(1);

			}

			String sql5 = "insert into company (CompanyName,CompanyEmail,CompanyPhone,Aid,Tid,Lid) values(?,?,?,?,?,?)";
			PreparedStatement stmt5 = dbConnection.prepareStatement(sql5, Statement.RETURN_GENERATED_KEYS);

			stmt5.setString(1, companyDetails.getCompanyName());
			stmt5.setString(2, companyDetails.getCompanyEmail());
			stmt5.setString(3, companyDetails.getCompanyPhone());
			stmt5.setInt(4, companyAdressId);
			stmt5.setInt(5, tenantId);
			stmt5.setInt(6, loginId);
			stmt5.executeUpdate();

			ResultSet rs5 = stmt5.getGeneratedKeys();
			if (rs5 != null && rs5.next()) {
				return (int) rs5.getInt(1);
			}

		} catch (Exception e) {

			System.out.println(e);
			logger.error("This is error : " , e);
		} /*finally {

			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/

		return 0;

	}

}
