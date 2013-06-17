package org.fortytwo.developer.mybudget0123.client.mvp;

import org.fortytwo.developer.mybudget0123.client.place.RegisterPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({RegisterPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}
