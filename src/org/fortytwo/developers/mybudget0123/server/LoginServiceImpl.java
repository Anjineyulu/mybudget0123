package org.fortytwo.developers.mybudget0123.server;

import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.LoginService;
import org.fortytwo.developers.mybudget0123.shared.exception.UserUnauthenticatedException;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static Logger logger = Logger.getLogger(LoginServiceImpl.class.toString());
	
	private static final boolean D = true;
	
	@Override
	public boolean isLoggedIn() {
		UserService us = UserServiceFactory.getUserService();
		return us.isUserLoggedIn() || D;
	}

	@Override
	public String getRegisterID() throws UserUnauthenticatedException {
		if (D)
			return "test@gmail.com";
		
		UserService us = UserServiceFactory.getUserService();
		if (!us.isUserLoggedIn() || D)
			throw new UserUnauthenticatedException();
		else
			return us.getCurrentUser().getEmail();
	}

}
