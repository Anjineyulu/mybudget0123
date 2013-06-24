package org.fortytwo.developers.mybudget0123.client.place;

import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RegisterPlace extends Place {
	private static final Logger logger = Logger.getLogger(RegisterPlace.class.toString());
	@Prefix("register")
	public static class Tokenizer implements PlaceTokenizer<RegisterPlace> {
		@Override
		public RegisterPlace getPlace(String token) {
			logger.info(token);
			return new RegisterPlace(new RegisterID(token));
		}

		@Override
		public String getToken(RegisterPlace place) {
			return place.getRegisterID().getID();
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
