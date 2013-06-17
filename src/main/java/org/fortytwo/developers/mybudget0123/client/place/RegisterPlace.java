package org.fortytwo.developers.mybudget0123.client.place;

import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RegisterPlace extends Place {
	@Prefix("register")
	public class Tokenizer implements PlaceTokenizer<RegisterPlace> {
		@Override
		public RegisterPlace getPlace(String token) {
			return new RegisterPlace(new RegisterID(token));
		}

		@Override
		public String getToken(RegisterPlace place) {
			return id.toString();
		}
	}
	
	private RegisterID id;

	public RegisterPlace(RegisterID registerID) {
		this.id = registerID;
	}

	public RegisterID getRegisterID() {
		return id;
	}
}
