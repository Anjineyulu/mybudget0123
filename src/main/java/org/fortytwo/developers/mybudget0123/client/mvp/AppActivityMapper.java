package org.fortytwo.developers.mybudget0123.client.mvp;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.activity.RegisterActivity;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper{
	private ClientFactory clientFactory;
	
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof RegisterPlace) {
			return new RegisterActivity((RegisterPlace) place, clientFactory);
		}
		
		return null;
	}

}
