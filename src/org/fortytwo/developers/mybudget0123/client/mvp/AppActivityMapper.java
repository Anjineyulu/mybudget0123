package org.fortytwo.developers.mybudget0123.client.mvp;

import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.activity.RegisterActivity;
import org.fortytwo.developers.mybudget0123.client.activity.WelcomeActivity;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.place.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	private static final Logger logger = Logger.getLogger(AppActivityMapper.class.toString());
	
	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		logger.info(place.getClass().toString());
		
		if (place instanceof RegisterPlace)
			return new RegisterActivity((RegisterPlace) place, clientFactory);
		if (place instanceof WelcomePlace)
			return new WelcomeActivity((WelcomePlace) place, clientFactory);
		return null;
	}

}