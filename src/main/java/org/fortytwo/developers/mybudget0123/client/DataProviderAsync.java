package org.fortytwo.developers.mybudget0123.client;

import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterData;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataProviderAsync {
	void getRegisterData(RegisterID registerID, AsyncCallback<List<RegisterData>> callback);

	void addRegisterData(RegisterData data, AsyncCallback<Void> callback);

	void generateData(AsyncCallback<Void> callback);
}
