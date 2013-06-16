package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.view.RegisterView;
import org.fortytwo.developers.mybudget0123.client.view.RegistrationView;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {
	private EventBus eventBus = new SimpleEventBus();
	private PlaceController placeController = new PlaceController(eventBus);

	// services
	private DataProviderAsync dataProvider = GWT.create(DataProvider.class);
	private LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	// views
	private RegisterView registerView;
	private RegistrationView registrationView;
	
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}
	
	@Override
	public RegistrationView getRegistrationView() {
		if (null == registrationView)
			registrationView = GWT.create(RegisterView.class);
		
		return registrationView;
	}

	@Override
	public RegisterView getRegisterView() {
		if (null == registerView)
			registerView = GWT.create(RegisterView.class);
		
		return registerView;
	}

	@Override
	public DataProviderAsync getDataProvider() {
		return dataProvider;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public LoginServiceAsync getLoginService() {
		return loginService;
	}
}
