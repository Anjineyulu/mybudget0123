package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataProviderAsync {
	void addRegisterData(Double amount, boolean isGive, Date date, RegisterInfo info, AsyncCallback<Void> callback);

	void generateData(AsyncCallback<Void> callback);

	void getRegisterList(String email, AsyncCallback<List<RegisterInfo>> asyncCallback);
}
