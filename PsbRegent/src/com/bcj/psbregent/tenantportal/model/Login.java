package com.bcj.psbregent.tenantportal.model;


/**
 * This is the entity class. It is designed to hold user login credentials.
 * @author Bootcamp User 021
 *
 */
public class Login {
	
	//Properties
	private String loginId;
	private String userId;
	private String password;

	//Constructor
	public Login() {

	}

	//Parameterized Constructor
	public Login(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	//Setters and Getters for the properties
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}
