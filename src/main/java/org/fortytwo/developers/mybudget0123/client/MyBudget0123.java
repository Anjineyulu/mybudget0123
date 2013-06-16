package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.mvp.AppActivityMapper;
import org.fortytwo.developers.mybudget0123.client.mvp.AppPlaceHistoryMapper;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class MyBudget0123 implements EntryPoint {
	@Override
	public void onModuleLoad() {
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		
		LoginServiceAsync loginService = clientFactory.getLoginService();
		
		SimpleLayoutPanel panel = new SimpleLayoutPanel();
		ActivityManager activityManager = new ActivityManager(new AppActivityMapper(clientFactory), clientFactory.getEventBus());
		activityManager.setDisplay(panel);

		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new RegisterPlace());
		
		RootLayoutPanel.get().add(new HTMLPanel("<h1>THIS IS A TEST!!</h1>"));
	}

}
