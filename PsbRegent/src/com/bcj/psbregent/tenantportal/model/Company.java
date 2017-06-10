package com.bcj.psbregent.tenantportal.model;

/**
 * This is the Company entity class
 * 
 * @author Bootcamp User 021
 */
public class Company {

	private String companyId;
	private String companyName;
	private String companyEmail;
	private String companyPhone;
	private Address companyAddress;

	// Default Constructor
	public Company() {

	}

	// Parameterized Constructor
	public Company(String companyName, String companyEmail, String companyPhone, Address companyAddress) {

		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;

	}

	/* Setters and Getters for the properties */
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
