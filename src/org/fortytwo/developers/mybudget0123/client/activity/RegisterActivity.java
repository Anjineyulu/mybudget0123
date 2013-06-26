package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.List;
import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.RegisterView;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.view.client.ListDataProvider;

public class RegisterActivity extends AbstractActivity {
	private static final Logger logger = Logger.getLogger(RegisterActivity.class.toString());
	
	private RegisterPlace place;
	private ClientFactory clientFactory;
	private RegisterView view;
	
	@UiField(provided=true)
	CellTable<RegisterData> registerTable;
	@UiField
	SimplePager registerTablePager;
	
	ListDataProvider<RegisterData> registerDataProvider;

	public RegisterActivity(RegisterPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		this.view = clientFactory.getRegisterView();
	}

	@Override
	public void start(AcceptsOneWidget widget, EventBus eventBus) {
		logger.info("starting");
		
		clientFactory.getDataProvider().getRegisterData(place.getRegisterID(), new AsyncCallback<List<RegisterData>>() {
			
			@Override
			public void onSuccess(List<RegisterData> data) {
				view.setData(data);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				logger.severe(arg0.getMessage());
			}
		});
		
		widget.setWidget(view);
	}
	
	@UiHandler("generateBtn")
	void onGenerateClick(ClickEvent event) {
		logger.info("generateBtn clicked!");
		clientFactory.getDataProvider().generateData(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				Window.alert("Generated");
			}
		});
	}

}
