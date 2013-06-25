package org.fortytwo.developers.mybudget0123.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable
public class RegisterData implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	@Persistent
	private CashFlow cashFlow;
	@Persistent
	private Date date;
	@Persistent
	private List<String> tags;
	@Persistent
	private String comment;
	@Persistent
	private RegisterID registerID;
	
	public RegisterData(){}
	
	public RegisterData(RegisterID registerID, CashFlow cashFlow, Date date, List<String> tags, String comment) {
		this.registerID = registerID;
		this.cashFlow = cashFlow;
		this.date = date;
		this.tags = new ArrayList<String>();
		if (null != tags)
			this.tags.addAll(tags);
		this.comment = comment;
	}
	
	public CashFlow getCashFlow() {
		return cashFlow;
	}

	public Date getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}
	
	public RegisterID getRegisterID() {
		return registerID;
	}
	
	public Key getKey() {
		return key;
	}
}
