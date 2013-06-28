package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataProviderAsync {
	void addRegisterData(Double amount, Type type, Date date, Long register, AsyncCallback<Void> callback);
	void getRegisterList(String email, AsyncCallback<List<RegisterInfo>> asyncCallback);
	void getRegisterData(Long registerID, AsyncCallback<List<CashFlow>> callback);
	void createRegister(String email, String name, AsyncCallback<Long> callback);
	void deleteRegisters(Set<RegisterInfo> selectedForDeletion, String email, AsyncCallback<Void> asyncCallback);
}
