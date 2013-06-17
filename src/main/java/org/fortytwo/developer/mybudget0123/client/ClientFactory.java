package org.fortytwo.developer.mybudget0123.client;

import org.fortytwo.developer.mybudget0123.client.view.RegisterView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	RegisterView getRegisterView();
}
