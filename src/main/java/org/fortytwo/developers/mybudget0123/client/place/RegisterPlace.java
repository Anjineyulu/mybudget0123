package org.fortytwo.developers.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class RegisterPlace extends Place {

	public class Tokenizer implements PlaceTokenizer<RegisterPlace> {

		@Override
		public RegisterPlace getPlace(String string) {
			return new RegisterPlace();
		}

		@Override
		public String getToken(RegisterPlace place) {
			return "";
		}

	}
	
}
