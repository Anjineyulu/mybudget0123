package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;
import org.fortytwo.developers.mybudget0123.shared.exception.UserUnauthenticatedException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("data")
public interface DataProvider extends RemoteService {
	List<RegisterInfo> getRegisterList(String email);
	void addRegisterData(Double amount, Type type, Date date, Long register) throws UserUnauthenticatedException;
	List<CashFlow> getRegisterData(Long registerID);
	Long createRegister(String email, String name);
	void deleteRegisters(Set<RegisterInfo> selectedForDeletion, String email);
}
