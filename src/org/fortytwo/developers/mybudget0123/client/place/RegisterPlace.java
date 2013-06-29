package org.fortytwo.developers.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RegisterPlace extends Place {
	
	@Prefix("register")
	public static class Tokenizer implements PlaceTokenizer<RegisterPlace> {
		@Override
		public RegisterPlace getPlace(String token) {
			return new RegisterPlace(Long.parseLong(token));
		}

		@Override
		public String getToken(RegisterPlace place) {
			return place.id.toString();
		}
	}
	
	private Long id;
	
	private RegisterPlace() {}
	
	public RegisterPlace(Long registerID) {
		this.id = registerID;
	}

	public Long getRegisterID() {
		return id;
	}
}
