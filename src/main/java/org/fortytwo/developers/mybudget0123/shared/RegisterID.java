package org.fortytwo.developers.mybudget0123.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
@PersistenceCapable
public class RegisterID implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String id;
	
	public RegisterID(){}
	
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
