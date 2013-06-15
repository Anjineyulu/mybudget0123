package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataProviderAsync {
	void getRegisterData(Date date, AsyncCallback<List<RegisterData>> asyncCallback);
}
