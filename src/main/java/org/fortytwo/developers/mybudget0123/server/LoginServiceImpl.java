package org.fortytwo.developers.mybudget0123.server;

import org.fortytwo.developers.mybudget0123.client.LoginService;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static final long serialVersionUID = -1471829329563178417L;

	@Override
	public boolean isUserLogged() {
		UserService userService = UserServiceFactory.getUserService();
		return userService.isUserLoggedIn();
	}
}
