package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.List;
import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.RegisterView;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;

public class RegisterActivity extends AbstractActivity implements RegisterView.Presenter {
	private static final Logger logger = Logger.getLogger(RegisterActivity.class.toString());

	private RegisterPlace place;
	private ClientFactory clientFactory;
	private RegisterView view;

	@UiField(provided=true)
	CellTable<CashFlow> registerTable;
	@UiField
	SimplePager registerTablePager;

	ListDataProvider<CashFlow> registerDataProvider;

	public RegisterActivity(RegisterPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		this.view = clientFactory.getRegisterView();
	}

	@Override
	public void start(AcceptsOneWidget widget, EventBus eventBus) {
		logger.info("starting");
		view.setPresenter(this);

		getData();

		widget.setWidget(view);
	}

	@Override
	public void onAddClicked() {
		logger.info("onAddClicked");
	}

	@Override
	public void onGenerate() {
		clientFactory.getDataProvider().generate(place.getRegisterID(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Generated 100 entries!");
			}
		});
	}

	private void getData() {
		clientFactory.getDataProvider().getRegisterData(place.getRegisterID(), new AsyncCallback<List<CashFlow>>() {

			@Override
			public void onSuccess(List<CashFlow> data) {
				view.setData(data);
			}

			@Override
			public void onFailure(Throwable arg0) {
				logger.severe(arg0.getMessage());
			}
		});
	}
}
