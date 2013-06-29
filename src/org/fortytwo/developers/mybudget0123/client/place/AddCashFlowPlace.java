package org.fortytwo.developers.mybudget0123.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class AddCashFlowPlace extends Place {
	@Prefix("ac")
	public static class Tokenizer implements PlaceTokenizer<AddCashFlowPlace> {
		@Override
		public AddCashFlowPlace getPlace(String token) {
			return new AddCashFlowPlace(Long.parseLong(token));
		}

		@Override
		public String getToken(AddCashFlowPlace place) {
			return place.registerID.toString();
		}
	}
	
	private Long registerID;
	
	public AddCashFlowPlace(Long registerID) {
		this.registerID = registerID;
	}
}
