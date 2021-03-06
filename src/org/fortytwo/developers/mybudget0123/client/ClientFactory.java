package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.view.AddCashFlowView;
import org.fortytwo.developers.mybudget0123.client.view.ListRegistersView;
import org.fortytwo.developers.mybudget0123.client.view.RegisterView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	EventBus getEventBus();
	PlaceController getPlaceController();
	
	DataProviderAsync getDataProvider();
	LoginServiceAsync getLoginService();
	
	//WelcomeView getWelcomeView();
	RegisterView getRegisterView();
	ListRegistersView getListRegistersView();
	AddCashFlowView getAddCashFlowView();
	
}
