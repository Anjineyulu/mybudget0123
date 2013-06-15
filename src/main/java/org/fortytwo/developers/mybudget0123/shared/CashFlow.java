package org.fortytwo.developers.mybudget0123.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CashFlow implements IsSerializable {
	public enum Type {
		GIVE,
		TAKE
	};
	
	private Type type;
	private Double amount;
	
	public CashFlow(Type type, Double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public Type getType() {
		return type;
	}
	
	public Double getAmount() {
		return amount;
	}
}
