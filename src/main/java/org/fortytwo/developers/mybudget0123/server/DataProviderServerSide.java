package org.fortytwo.developers.mybudget0123.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.fortytwo.developers.mybudget0123.client.DataProvider;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DataProviderServerSide extends RemoteServiceServlet implements DataProvider {
	private static final long serialVersionUID = 5581643226217941175L;

	@Override
	public List<RegisterData> getRegisterData(Date date) {
		ArrayList<RegisterData> data = new ArrayList<RegisterData>();
		
		Random rand = new Random();
		for (int i = 0; i < 100; ++i) {
			data.add(new RegisterData(new CashFlow(rand.nextBoolean() ? Type.GIVE : Type.TAKE, rand.nextDouble() * 100), new Date(), null, "this is a test entry"));
		}
		
		return data;
	}

}
