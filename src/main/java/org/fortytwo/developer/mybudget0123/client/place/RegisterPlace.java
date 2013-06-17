package org.fortytwo.developer.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RegisterPlace extends Place {
	@Prefix("register")
	public class Tokenizer implements PlaceTokenizer<RegisterPlace> {
		@Override
		public RegisterPlace getPlace(String token) {
			return new RegisterPlace();
		}

		@Override
		public String getToken(RegisterPlace place) {
			return "";
		}
		
	}
}
