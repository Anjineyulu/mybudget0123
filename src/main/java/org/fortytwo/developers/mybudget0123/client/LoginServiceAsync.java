package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	void isLoggedIn(AsyncCallback<Boolean> callback);
	void getRegisterID(AsyncCallback<RegisterID> callback);
}
