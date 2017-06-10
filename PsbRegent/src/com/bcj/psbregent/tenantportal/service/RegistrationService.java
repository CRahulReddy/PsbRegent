package com.bcj.psbregent.tenantportal.service;

import com.bcj.psbregent.tenantportal.dao.RegistrationDao;
import com.bcj.psbregent.tenantportal.model.Company;
import com.bcj.psbregent.tenantportal.model.Login;
import com.bcj.psbregent.tenantportal.model.Tenant;


/**This class passes the entity objects to the DAO layer and returns the response got from DAO back to the servlet.
 * 
 * @author Bootcamp User 021
 *
 */
public class RegistrationService {

	public String registerTenant(Company companyDetails, Tenant tenantDetails, Login loginDetials) {
		
		
		RegistrationDao registrationDao = new RegistrationDao();

		return String.valueOf((int) registrationDao.registerTenant(companyDetails, tenantDetails, loginDetials));
		
		
	}

}
