package org.fortytwo.developers.mybudget0123.client.mvp;

import org.fortytwo.developers.mybudget0123.client.place.AddCashFlowPlace;
import org.fortytwo.developers.mybudget0123.client.place.ListRegistersPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.place.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({AddCashFlowPlace.Tokenizer.class, ListRegistersPlace.Tokenizer.class, RegisterPlace.Tokenizer.class, WelcomePlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
