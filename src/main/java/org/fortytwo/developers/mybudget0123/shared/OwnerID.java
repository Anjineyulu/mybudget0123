package org.fortytwo.developers.mybudget0123.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class OwnerID implements IsSerializable {
	private String email;
	
	public OwnerID(String email) {
		this.email = email;
	}
	
	
}
