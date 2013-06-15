package org.fortytwo.developers.mybudget0123.client;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("dataprovider")
public interface DataProvider extends RemoteService {
	List<RegisterData> getRegisterData(Date date);
}
