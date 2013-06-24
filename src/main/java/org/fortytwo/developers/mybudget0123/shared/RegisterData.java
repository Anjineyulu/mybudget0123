package org.fortytwo.developers.mybudget0123.shared;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RegisterData implements IsSerializable {
	private CashFlow cashFlow; 
	private Date date;
	private List<String> tags;
	private String comment;
	private RegisterID registerID;
	
	public RegisterData(){}
	
	public RegisterData(RegisterID registerID, CashFlow cashFlow, Date date, List<String> tags, String comment) {
		this.registerID = registerID;
		this.cashFlow = cashFlow;
		this.date = date;
		this.tags = new ArrayList<String>(tags);
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
}
