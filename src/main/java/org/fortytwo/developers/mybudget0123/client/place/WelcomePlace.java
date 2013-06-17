package org.fortytwo.developers.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class WelcomePlace extends Place {
	@Prefix("welcome")
	public class Tokenizer implements PlaceTokenizer<WelcomePlace> {

		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}

		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}
	}
}
