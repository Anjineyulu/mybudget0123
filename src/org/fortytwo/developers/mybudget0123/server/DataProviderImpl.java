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
import org.fortytwo.developers.mybudget0123.shared.exception.UserUnauthenticatedException;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DataProviderImpl extends RemoteServiceServlet implements DataProvider {
	private static final Logger logger = Logger.getLogger(DataProviderImpl.class.toString());
	
	private static final boolean D = true; // DEBUG!!
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CashFlow> getRegisterData(Long registerID) {
		logger.info("Retrieving cashflows for " + registerID);
		
		ArrayList<CashFlow> data = new ArrayList<CashFlow>();
		PersistenceManager pm = null;
		
		try {
			pm = PMF.get().getPersistenceManager();
			//pm.currentTransaction().setIsolationLe
			Query q = pm.newQuery(CashFlow.class);
			q.setFilter("registerID == givenID");
			q.declareParameters("Long givenID");
			try {
				for (CashFlow cf : (List<CashFlow>)q.execute(registerID)) {
					data.add(new CashFlow(cf));
				}
			} finally {
				q.closeAll();
			}
		} finally {
			pm.close();
		}
		
		return data;
	}
	
	@Override
	public Long createRegister(String email, String name) {
		logger.info("Creating " + name + " for " + email);
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
		logger.info("Retrieving registers for " + email);
		PersistenceManager pm = null;
		try {
			pm = PMF.get().getPersistenceManager();
			
			Query query = pm.newQuery(RegisterInfo.class);
			query.setFilter("email == givenEmail");
			query.declareParameters("String givenEmail");
			
			try {
				List<RegisterInfo> list =  new ArrayList<RegisterInfo>();
				List<RegisterInfo> pList = (List<RegisterInfo>) query.execute(email);
			
				if (null == pList)
					logger.info("Retrieved null");
				else {
					logger.info(list.toString());
					//list.addAll(pList);
					for (RegisterInfo rInfo : pList)
						list.add(new RegisterInfo(rInfo));
					
				}
				return list;
			} finally {
				query.closeAll();
			}
		} finally {
			pm.close();
		}
	}

	@Override
	public void deleteRegisters(Set<RegisterInfo> selectedForDeletion, String email) {
		logger.info("Deleting " + selectedForDeletion + " for " + email);
		
		PersistenceManager pm = null;
		
		try {
			pm = PMF.get().getPersistenceManager();
			pm.currentTransaction().begin();
			Query delCF = pm.newQuery(CashFlow.class);
			delCF.setFilter("registerID == givenID");
			delCF.declareParameters("Long givenID");
			
			Query delRI = pm.newQuery(RegisterInfo.class);
			delRI.setFilter("key == givenKey");
			delRI.declareParameters("Long givenKey");
			try {
				for (RegisterInfo rInfo : selectedForDeletion) {
					logger.info("- " + rInfo.getKey());
					delCF.deletePersistentAll(rInfo.getKey());
					logger.info("--");
					delRI.deletePersistentAll(rInfo.getKey());
				}
				logger.info("done");
			} finally {
				delCF.closeAll();
				delRI.closeAll();
			}
		} catch (RuntimeException re) {
			re.printStackTrace();
		} finally {
			if (pm.currentTransaction().isActive())
				pm.currentTransaction().commit();
			pm.close();
		}
	}
	
	@Override
	public void generate(Long registerID) {
		Random rand = new Random();
		for (int i = 0; i < 100; ++i) {
			try {
				addCashFlow( 100 * rand.nextDouble(), rand.nextBoolean() ? Type.TAKE : Type.GIVE, new Date(), registerID);
			} catch (UserUnauthenticatedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addCashFlow(Double amount, Type type, Date date, Long register) throws UserUnauthenticatedException {
		UserService us = UserServiceFactory.getUserService();
		if (!us.isUserLoggedIn()) {
			logger.info("unauthenticated");
			if (!D)
				throw new UserUnauthenticatedException();
		}
		
		User u = us.getCurrentUser();
			
		PersistenceManager pm = PMF.get().getPersistenceManager();
			
		try {
			pm.currentTransaction().begin();
			pm.makePersistent(new CashFlow(type, amount, date, register, D ? "test@gmail.com" : u.getEmail(), ""));
		} catch (Exception e) {
			e.printStackTrace();
			pm.currentTransaction().rollback();
		} finally {
			if (pm.currentTransaction().isActive())
				pm.currentTransaction().commit();
			pm.close();
		}
	}
	
}
