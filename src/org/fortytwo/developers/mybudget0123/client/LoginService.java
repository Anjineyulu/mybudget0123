package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.shared.exception.UserUnauthenticatedException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	boolean isLoggedIn();
	String getRegisterID() throws UserUnauthenticatedException;
}
