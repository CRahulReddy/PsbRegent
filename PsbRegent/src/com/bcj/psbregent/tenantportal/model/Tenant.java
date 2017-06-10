package com.bcj.psbregent.tenantportal.model;


/**
 * This is the entity class. It contains properties to hold the Tenant details.
 * @author Bootcamp User 021
 *
 */
public class Tenant {

	//Properties
	private String tenantId;
	private String tenantfirstName;
	private String tenantLastName;
	private String tenantEmail;
	private String tenantPhone;
	private Address tenantAddress;

	
	//Constructor
	public Tenant() {

	}

	//Parameterized Constructor
	public Tenant(String tenantfirstName, String tenantLastName, String tenantEmail, String tenantPhone,
			Address tenantAddress) {
		
		this.tenantfirstName = tenantfirstName;
		this.tenantLastName = tenantLastName;
		this.tenantEmail = tenantEmail;
		this.tenantPhone = tenantPhone;
		this.tenantAddress = tenantAddress;
	}

	/* Setters and Getters for the properties */
	public String getTenantfirstName() {
		return tenantfirstName;
	}

	public void setTenantfirstName(String tenantfirstName) {
		this.tenantfirstName = tenantfirstName;
	}

	public String getTenantLastName() {
		return tenantLastName;
	}

	public void setTenantLastName(String tenantLastName) {
		this.tenantLastName = tenantLastName;
	}

	public String getTenantEmail() {
		return tenantEmail;
	}

	public void setTenantEmail(String tenantEmail) {
		this.tenantEmail = tenantEmail;
	}

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

	public Address getTenantAddress() {
		return tenantAddress;
	}

	public void setTenantAddress(Address tenantAddress) {
		this.tenantAddress = tenantAddress;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
