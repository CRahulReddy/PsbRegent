package com.bcj.psbregent.tenantportal.service;

import com.bcj.psbregent.tenantportal.dao.PaymentDao;
import com.bcj.psbregent.tenantportal.model.CreditCard;


/**This class is used to pass the entity object to DAO layer and gives the response got from DAO layer back to Servlet
 * 
 * @author Bootcamp User 021
 *
 */
public class PaymentService {

	public static int processPayment(CreditCard creditCardDetails) {

		return PaymentDao.processPayment(creditCardDetails);

	}

}
