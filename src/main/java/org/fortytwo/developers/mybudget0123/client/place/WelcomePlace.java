package org.fortytwo.developers.mybudget0123.client.place;

import java.util.logging.Logger;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class WelcomePlace extends Place {
	private static final Logger logger = Logger.getLogger(WelcomePlace.class.toString());
	@Prefix("welcome")
	public class Tokenizer implements PlaceTokenizer<WelcomePlace> {

		@Override
		public WelcomePlace getPlace(String token) {
			logger.info("getting logger for token" + token);
			
			return new WelcomePlace();
		}

		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}
	}
}
