package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data")
public interface DataProvider extends RemoteService {
	void generateData();

	List<RegisterInfo> getRegisterList(String email);

	void addRegisterData(Double amount, boolean isGive, Date date, RegisterInfo info);
}
