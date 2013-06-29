package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.Date;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.AddCashFlowPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.AddCashFlowView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AddCashFlowActivity extends AbstractActivity implements AddCashFlowView.Presenter {

	private AddCashFlowPlace place;
	private AddCashFlowView view;
	private ClientFactory clientFactory;

	public AddCashFlowActivity(AddCashFlowPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		view = clientFactory.getAddCashFlowPlace();
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		view.getAmount().setValue(0.0);
		view.getDate().setValue(new Date());
		view.enableFrame(true);
		panel.setWidget(view);
	}

	@Override
	public void onAddCancelled() {
		clientFactory.getPlaceController().goTo(new RegisterPlace(place.getRegisterID()));
	}

	@Override
	public void onAddConfirmed() {
		view.enableFrame(false);
		clientFactory.
	}

}
