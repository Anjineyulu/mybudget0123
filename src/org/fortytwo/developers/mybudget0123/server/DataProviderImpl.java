package org.fortytwo.developers.mybudget0123.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;

import org.fortytwo.developers.mybudget0123.client.DataProvider;
import org.fortytwo.developers.mybudget0123.server.data.PMF;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DataProviderImpl extends RemoteServiceServlet implements DataProvider {
	private static final Logger logger = Logger.getLogger(DataProviderImpl.class.toString());
	
	
	@Override
	public void addRegisterData(RegisterData data) {
		logger.info("Storing " + data.toString());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.currentTransaction().begin();
			pm.makePersistent(data);
			pm.currentTransaction().commit();
		} finally {
			pm.close();
		}
	}
	
	@Override
	public void generateData() {
		logger.info("generating 100 fake data");
		Random rand = new Random();
		for (int i = 0; i < 100; ++i) {
			CashFlow cf = new CashFlow(rand.nextBoolean() ? Type.TAKE : Type.GIVE, 100 * rand.nextDouble());
			addRegisterData(new RegisterData(new RegisterID("test123"), cf, new Date(), null, "test data"));
		}
	}
	
	@Override
	public List<RegisterData> getRegisterData(RegisterID registerID) {
		logger.info(null == registerID ? "RegisterID NULL!!" : registerID.getID());
		
		ArrayList<RegisterData> data = new ArrayList<RegisterData>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 100; ++i) {
			CashFlow cf = new CashFlow(rand.nextBoolean() ? Type.TAKE : Type.GIVE, 100 * rand.nextDouble());
			data.add(new RegisterData(registerID, cf, new Date(), null, "test data"));
		}
		
		return data;
	}
	
}
