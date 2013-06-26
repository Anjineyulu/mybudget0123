package org.fortytwo.developers.mybudget0123.shared;

import javax.jdo.annotations.PersistenceCapable;

import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable
public class CashFlow implements IsSerializable {
	public enum Type {
		GIVE,
		TAKE
	};
	
	private Type type;
	private Double amount;
	
	CashFlow(){}
	
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
	
	public boolean isTake() {
		return type.equals(Type.TAKE);
	}
}
