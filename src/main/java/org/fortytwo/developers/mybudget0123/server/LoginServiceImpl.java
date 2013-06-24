package org.fortytwo.developers.mybudget0123.server;

import org.fortytwo.developers.mybudget0123.client.LoginService;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	@Override
	public boolean isLoggedIn() {
		return true;
	}

	@Override
	public RegisterID getRegisterID() {
		return new RegisterID("test@gmail.com");
	}

}
