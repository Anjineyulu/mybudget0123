package org.fortytwo.developers.mybudget0123.client.place;

import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ListRegisterPlace extends Place {
	@Prefix("list")
	public class Tokenizer implements PlaceTokenizer<ListRegisterPlace> {
		@Override
		public ListRegisterPlace getPlace(String token) {
			return new ListRegisterPlace(new RegisterID(token));
		}

		@Override
		public String getToken(ListRegisterPlace place) {
			return place.getID().toString();
		}
		
	}
	
	private RegisterID id;
	
	public ListRegisterPlace(RegisterID id) {
		this.id = id;
	}
	
	public RegisterID getID() {
		return id;
	}
}
