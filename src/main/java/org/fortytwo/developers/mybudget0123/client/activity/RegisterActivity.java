package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.RegisterView;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class RegisterActivity extends AbstractActivity {
	private RegisterView view;
	private RegisterPlace place;
	private ClientFactory clientFactory;



	public RegisterActivity(RegisterPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		view = clientFactory.getRegisterView();
	}



	@Override
	public void start(final AcceptsOneWidget widget, EventBus eventBus) {
		// initialize
		clientFactory.getDataProvider().getRegisterData(new Date(), new AsyncCallback<List<RegisterData>>() {
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(List<RegisterData> data) {
				view.setData(data);
			}

		});
		widget.setWidget(view);
	}
}
