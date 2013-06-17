package org.fortytwo.developer.mybudget0123.client.activity;

import java.util.logging.Logger;

import org.fortytwo.developer.mybudget0123.client.ClientFactory;
import org.fortytwo.developer.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developer.mybudget0123.client.view.RegisterView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class RegisterActivity extends AbstractActivity {
	private static final Logger logger = Logger.getLogger(RegisterActivity.class.toString());
	
	private RegisterPlace place;
	private ClientFactory clientFactory;
	private RegisterView view;

	public RegisterActivity(RegisterPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		this.view = clientFactory.getRegisterView();
	}

	@Override
	public void start(AcceptsOneWidget widget, EventBus eventBus) {
		logger.info("starting");
		
		widget.setWidget(view);
	}

}
