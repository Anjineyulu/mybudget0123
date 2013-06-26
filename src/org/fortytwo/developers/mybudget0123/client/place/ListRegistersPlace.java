package org.fortytwo.developers.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ListRegistersPlace extends Place {
	private String email;
	
	public ListRegistersPlace(String email) {
		this.email = email;
	}

	@Prefix("list")
	public static class Tokenizer implements PlaceTokenizer<ListRegistersPlace>{
		@Override
		public ListRegistersPlace getPlace(String token) {
			return new ListRegistersPlace(token);
		}

		@Override
		public String getToken(ListRegistersPlace place) {
			return place.email;
		}
	}
	
	public String getEmail() {
		return email;
	}
}
