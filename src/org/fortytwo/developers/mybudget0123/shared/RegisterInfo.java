package org.fortytwo.developers.mybudget0123.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
	private String name;
	
	@Persistent
	private List<String> authorizedUsers;
	
	RegisterInfo(){}
	
	public RegisterInfo(String email, String name, String description) {
		this.email = email;
		this.name = name;
		this.description = description;
		this.authorizedUsers = new ArrayList<String>();
	}
	
	public RegisterInfo(String email, String name, String description, Collection<String> authorizedUsers) {
		this(email, name, description);
		authorizedUsers.addAll(authorizedUsers);
	}
	
	public RegisterInfo(RegisterInfo other) {
		email = other.email;
		key = other.key;
		description = other.description;
		name = other.name;
		authorizedUsers = new ArrayList<String>();
		authorizedUsers.addAll(other.authorizedUsers);
	}

	public String getEmail() {
		return email;
	}
	
	public Long getKey() {
		return key;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getName() {
		return name;
	}
	
	public List<String> getAuthorizedUsers() {
		return authorizedUsers;
	}
	
	public void setAuthorizedUsers(List<String> list) {
		authorizedUsers = list;
	}
	
	public void authorize(String email) {
		if (!authorizedUsers.contains(email))
			authorizedUsers.add(email);
	}
	
	public void unauthorize(String email) {
		authorizedUsers.remove(email);
	}
	
	@Override
	public String toString() {
		return key.toString();
	}
}
