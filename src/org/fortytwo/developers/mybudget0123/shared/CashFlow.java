package org.fortytwo.developers.mybudget0123.shared;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable
public class CashFlow implements IsSerializable {
	@PersistenceCapable
	public enum Type {
		GIVE,
		TAKE
	};
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private Type type;
	@Persistent
	private Double amount;
	@Persistent(mappedBy = "RegisterInfo")
	private Long registerID;
	
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
	
	public Long getKey() {
		return key;
	}
}
