package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.view.RegisterView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final DataProviderAsync dataProvider = GWT.create(DataProvider.class);
	private static final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	// views
	private RegisterView registerView;

	@Override
	public PlaceController getPlaceController() {
		return placeController ;
	}
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
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
	public LoginServiceAsync getLoginService() {
		return loginService;
	}

}
