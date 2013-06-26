package org.fortytwo.developers.mybudget0123.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.fortytwo.developers.mybudget0123.client.DataProvider;
import org.fortytwo.developers.mybudget0123.server.data.PMF;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.CashFlow.Type;
import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DataProviderImpl extends RemoteServiceServlet implements DataProvider {
	private static final Logger logger = Logger.getLogger(DataProviderImpl.class.toString());
	
	
	@Override
	public void addRegisterData(Double amount, boolean isGive, Date date, RegisterInfo register) {
		logger.info("Storing " + data.toString());
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.currentTransaction().begin();
			pm.makePersistent(data);
			pm.currentTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			pm.currentTransaction().rollback();
		} finally {
			pm.close();
		}
	}
	
	@Override
	public void generateData() {
		logger.info("generating 100 fake data");
		Random rand = new Random();
		for (int i = 0; i < 1; ++i) {
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

	@Override
	public List<RegisterInfo> getRegisterList(String email) {
		ArrayList<RegisterInfo> list = new ArrayList<RegisterInfo>();
		
		
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			ArrayList<Filter> filters = new ArrayList<Filter>();
			filters.add(new FilterPredicate("owner", FilterOperator.EQUAL, email));
			filters.add(new FilterPredicate("authorized", FilterOperator.IN, email));
			Query query = pm.newQuery("RegisterInfo");
			query.setFilter("owner == " + email);
			
			
			/*for (RegisterData data : (List<RegisterData>) query.execute()) {
				
			}*/
		} finally {
			
		}
				
				
		return list;
	}
	
}
