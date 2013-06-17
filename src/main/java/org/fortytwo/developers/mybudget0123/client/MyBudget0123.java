package org.fortytwo.developers.mybudget0123.client;

import org.fortytwo.developers.mybudget0123.client.mvp.AppActivityMapper;
import org.fortytwo.developers.mybudget0123.client.mvp.AppPlaceHistoryMapper;
import org.fortytwo.developers.mybudget0123.client.place.WelcomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyBudget0123 implements EntryPoint {
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  ClientFactory clientFactory = GWT.create(ClientFactory.class);
	  
	  SimpleLayoutPanel appPanel = new SimpleLayoutPanel();
	  
	  RootLayoutPanel.get().add(appPanel);
	  
	  ActivityManager activityManager = new ActivityManager(new AppActivityMapper(clientFactory), clientFactory.getEventBus());
	  activityManager.setDisplay(appPanel);
	  
	  AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
	  PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	  historyHandler.register(clientFactory.getPlaceController(), clientFactory.getEventBus(), new WelcomePlace());
	  
	  historyHandler.handleCurrentHistory();
  }
  
}
