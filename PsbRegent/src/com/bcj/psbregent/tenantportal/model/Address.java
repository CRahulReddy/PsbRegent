package com.bcj.psbregent.tenantportal.model;

/**
 * This class is an entity class which contains properties for Address.
 * @author Bootcamp User 021
 */
public class Address {

	// Properties
	private String addressId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;

	// Default Constructor
	public Address() {

	}

	// Parameterized Constructor
	public Address(String addressLine1, String addressLine2, String city, String state, String zip) {

		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/* Setters and Getters for the properties */
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

}
