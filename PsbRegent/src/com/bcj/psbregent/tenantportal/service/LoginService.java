package com.bcj.psbregent.tenantportal.service;

import com.bcj.psbregent.tenantportal.dao.LoginDao;
import com.bcj.psbregent.tenantportal.model.Login;



/**This class passess the entitiy object to DAO layer and gives the response got from DAO layer  back to Servlet.
 * 
 * @author Bootcamp User 021
 *
 */
public class LoginService {

	public static boolean authenticateUser(Login loginDetails) {

		return LoginDao.authenticateUser(loginDetails);

	}

}
