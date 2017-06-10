package com.bcj.psbregent.tenantportal.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import com.bcj.psbregent.tenantportal.model.CreditCard;

/**
 * This class is used to connect to the database and perform some search,update
 * operations and returns the result back to the Service layer
 * 
 * @author Bootcamp User 021
 *
 */
public class PaymentDao {

	public static BufferedReader bufferReader;

	/**
	 * This method compares the details present in the CreditCard entity class
	 * with details present in the creditCardDetails.txt file. If the details
	 * match it returns 1, if not it returns 0.
	 * 
	 * @param creditCardDetails
	 * @return
	 */
	public static int processPayment(CreditCard creditCardDetails) {
		try {
			String file = System.getenv("CATALINA_HOME")
						+"\\webapps\\creditCardDetails.txt";
			System.out.println(file);
			FileReader fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferReader.readLine()) != null) {
				String feilds[] = line.split(" ");
				for (int i = 0; i < feilds.length; i++) {
					if (creditCardDetails.getNameOnCard().equals(feilds[0])
							&& creditCardDetails.getCardNumber().equals(feilds[1])
							&& creditCardDetails.getCvv().equals(feilds[2])
							&& creditCardDetails.getExpirationDate().equals(feilds[3])
							&& Integer.parseInt(creditCardDetails.getRentAmount()) <= Integer.parseInt(feilds[4])) {
						return 1;
					}
				}

			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		} finally {

			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}