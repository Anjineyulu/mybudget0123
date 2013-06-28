package org.fortytwo.developers.mybudget0123.shared;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

@PersistenceCapable
public class CashFlow implements IsSerializable {
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
	@Persistent
	private String author;
	
	@Persistent(mappedBy = "RegisterInfo")
	private Long registerID;
	
	@Persistent
	private Date date;

	@Persistent
	private String comment;
	
	CashFlow(){}
	
	public CashFlow(Type type, Double amount, Date date, Long registerID, String author, String comment) {
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.registerID = registerID;
		this.comment = comment;
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
	
	public Date getDate() {
		return date;
	}
	
	public Long getKey() {
		return key;
	}

	public String getAuthor() {
		return author;
	}

	public String getComment() {
		return comment;
	}
}
