package org.fortytwo.developers.mybudget0123.client;

import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterData;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data")
public interface DataProvider extends RemoteService {
	List<RegisterData> getRegisterData(RegisterID registerID);

	void addRegisterData(RegisterData data);

	void generateData();
}
