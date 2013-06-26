package org.fortytwo.developers.mybudget0123.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
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
	public void addRegisterData(Double amount, CashFlow.Type type, Date date, RegisterInfo register) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.currentTransaction().begin();
			pm.makePersistent(new CashFlow(type, amount, date, register.getKey()));
			pm.currentTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			pm.currentTransaction().rollback();
		} finally {
			pm.close();
		}
	}
	
	@Override
	public List<CashFlow> getRegisterData(Long registerID) {
		ArrayList<CashFlow> data = new ArrayList<CashFlow>();
		
		Random rand = new Random();
		
		for (int i = 0; i < 100; ++i) {
			data.add(new CashFlow(rand.nextBoolean() ? Type.TAKE : Type.GIVE, 100 * rand.nextDouble(), new Date(), registerID));
		}
		
		return data;
	}
	
	@Override
	public Long createRegister(String email, String name) {
		PersistenceManager pm = null;

		try {
			pm = PMF.get().getPersistenceManager();
			
			RegisterInfo regInfo = new RegisterInfo(email, name, null);
			pm.currentTransaction().begin();
			regInfo = pm.makePersistent(regInfo);
			return regInfo.getKey();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			if (pm.currentTransaction().isActive())
				pm.currentTransaction().commit();
			
			pm.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegisterInfo> getRegisterList(String email) {
		PersistenceManager pm = null;
		try {
			pm = PMF.get().getPersistenceManager();
			
			ArrayList<Filter> filters = new ArrayList<Filter>();
			filters.add(new FilterPredicate("owner", FilterOperator.EQUAL, email));
			filters.add(new FilterPredicate("authorized", FilterOperator.IN, email));
			Query query = pm.newQuery("RegisterInfo");
			query.setFilter("owner == " + email);
			
			return (List<RegisterInfo>) query.execute();
		} finally {
			pm.close();
		}
	}

	@Override
	public List<RegisterInfo> deleteRegisters(Set<RegisterInfo> selectedForDeletion, String email) {
		return null;
	}
	
}
