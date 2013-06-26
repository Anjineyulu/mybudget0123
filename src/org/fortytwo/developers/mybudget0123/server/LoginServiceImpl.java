package org.fortytwo.developers.mybudget0123.server;

import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.LoginService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static Logger logger = Logger.getLogger(LoginServiceImpl.class.toString());
	
	@Override
	public boolean isLoggedIn() {
		return true;
	}

	@Override
	public String getRegisterID() {
		return "test@gmail.com";
	}

}
