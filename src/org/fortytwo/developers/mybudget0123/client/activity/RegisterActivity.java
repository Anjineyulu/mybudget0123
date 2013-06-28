package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.Date;
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
		
		widget.setWidget(view);
	}
	
	@Override
	public void onAddClicked() {
		view.getAmount().setValue(0.0);
		view.getDate().setValue(new Date());
		view.showAddFrame(true);
	}
	
	@Override
	public void onGenerate() {
		
	}

	@Override
	public void onAddCancelled() {
		view.showAddFrame(false);
	}

	@Override
	public void onAddConfirmed() {
		clientFactory.getDataProvider().addRegisterData(view.getAmount().getValue(), CashFlow.Type.valueOf(view.getType()), view.getDate().getValue(), place.getRegisterID(), new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				view.showAddFrame(false);
			}
		});
	}
}
