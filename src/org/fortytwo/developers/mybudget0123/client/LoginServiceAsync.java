package org.fortytwo.developers.mybudget0123.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void isLoggedIn(AsyncCallback<Boolean> callback);
	void getRegisterID(AsyncCallback<String> callback);
}
