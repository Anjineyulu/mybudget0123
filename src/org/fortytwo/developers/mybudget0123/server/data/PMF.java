package org.fortytwo.developers.mybudget0123.server.data;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
	private static final PersistenceManagerFactory pmfactory = JDOHelper.getPersistenceManagerFactory("transactions-optional");
	
	public static PersistenceManagerFactory get() {
		return pmfactory;
	}
}
