package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.Date;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.AddCashFlowPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.AddCashFlowView;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AddCashFlowActivity extends AbstractActivity implements AddCashFlowView.Presenter {

	private AddCashFlowPlace place;
	private AddCashFlowView view;
	private ClientFactory clientFactory;
	private Timer messageTimer;

	public AddCashFlowActivity(AddCashFlowPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		view = clientFactory.getAddCashFlowView();
		view.setPresenter(this);
		messageTimer = new Timer() {
			@Override
			public void run() {
				view.enableMessage(false);
			}
		}; 
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		init();
		panel.setWidget(view);
	}
	
	@Override
	public void onStop() {
		messageTimer.cancel();
	}
	
	private void init() {
		view.getAmount().setValue(0.0);
		view.getDate().setValue(new Date());
		view.enableFrame(true);
	}

	@Override
	public void onAddCancelled() {
		clientFactory.getPlaceController().goTo(new RegisterPlace(place.getRegisterID()));
	}

	@Override
	public void onAddConfirmed() {
		view.enableFrame(false);
		clientFactory.getDataProvider().addCashFlow(view.getAmount().getValue(), CashFlow.Type.valueOf(view.getType()), view.getDate().getValue(), place.getRegisterID(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				//clientFactory.getPlaceController().goTo(new RegisterPlace(place.getRegisterID()));
				messageTimer.cancel();
				messageTimer.schedule(5000);
				init();
				//view.getMessage().setValue("Cash flow added");
				view.setMessage("Cash flow added");
			}
		});
	}

}
