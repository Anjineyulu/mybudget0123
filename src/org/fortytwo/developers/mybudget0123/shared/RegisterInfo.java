package org.fortytwo.developers.mybudget0123.shared;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable
public class RegisterInfo implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private String email;
	@Persistent
	private String description;
	
	@Persistent
	private List<String> authorizedUsers;
	
	RegisterInfo(){}
	public RegisterInfo(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Long getKey() {
		return key;
	}
}
