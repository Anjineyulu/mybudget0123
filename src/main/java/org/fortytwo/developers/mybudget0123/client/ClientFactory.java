package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.view.RegisterView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	EventBus getEventBus();
	RegisterView getRegisterView();
	DataProviderAsync getDataProvider();
	LoginServiceAsync getLoginService();
	PlaceController getPlaceController();
}
