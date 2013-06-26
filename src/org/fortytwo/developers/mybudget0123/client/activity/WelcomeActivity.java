package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.ListRegistersPlace;
import org.fortytwo.developers.mybudget0123.client.place.LoginPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.place.WelcomePlace;
import org.fortytwo.developers.mybudget0123.shared.RegisterID;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends AbstractActivity {
	private static final Logger logger = Logger.getLogger(WelcomeActivity.class.toString());
	private ClientFactory clientFactory;
	//private WelcomePlace place;

	public WelcomeActivity(WelcomePlace place, ClientFactory clientFactory) {
		//this.place = place;
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget widget, EventBus eventBus) {
		logger.info("starting");
		clientFactory.getLoginService().isLoggedIn(new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean arg0) {
				logger.info(arg0.toString());
				if (arg0) {
					clientFactory.getLoginService().getRegisterID(new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable arg0) {
							// TODO Auto-generated method stub
						}

						@Override
						public void onSuccess(String arg0) {
							clientFactory.getPlaceController().goTo(new ListRegistersPlace(arg0));
						}
					});
				} else {
					clientFactory.getPlaceController().goTo(new LoginPlace());
				}
			}

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

}
