package org.fortytwo.developers.mybudget0123.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RegisterID implements IsSerializable {
	private String id;
	
	public RegisterID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
