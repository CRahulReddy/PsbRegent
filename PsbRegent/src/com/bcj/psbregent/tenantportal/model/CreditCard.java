package com.bcj.psbregent.tenantportal.model;

/**
 * This is the CreditCard entity class.
 * 
 * @author Bootcamp User 021
 */

public class CreditCard {

	// Properties
	private String nameOnCard;
	private String cardNumber;
	private String cvv;
	private String expirationDate;
	private String rentAmount;

	// Default Constructor
	public CreditCard() {

	}

	// Parameterized Constructor
	public CreditCard(String nameOnCard, String cardNumber, String cvv, String expirationDate, String rentAmount) {

		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.rentAmount = rentAmount;
	}

	// Setters and Getters for the properties

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}

}
