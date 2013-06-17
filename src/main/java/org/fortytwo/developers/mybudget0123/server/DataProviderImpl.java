package org.fortytwo.developers.mybudget0123.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.fortytwo.developers.mybudget0123.client.DataProvider;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DataProviderImpl extends RemoteServiceServlet implements DataProvider {

	@Override
	public List<RegisterData> getRegisterData(RegisterID registerID) {
		ArrayList<RegisterData> data = new ArrayList<RegisterData>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 100; ++i) {
			CashFlow cf = new CashFlow(rand.nextBoolean() ? Type.TAKE : Type.GIVE, 100 * rand.nextDouble());
			data.add(new RegisterData(registerID, cf, new Date(), null, "test data"));
		}
		
		return data;
	}
	
}
