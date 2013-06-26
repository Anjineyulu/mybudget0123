package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.List;
import java.util.logging.Logger;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.ListRegistersPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.ListRegistersView;
import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ListRegistersActivity extends AbstractActivity implements ListRegistersView.Presenter {
	private static final Logger logger = Logger.getLogger(ListRegistersActivity.class.toString());
	
	private ListRegistersPlace place;
	private ClientFactory clientFactory;
	private ListRegistersView view;

	public ListRegistersActivity(ListRegistersPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
		view = clientFactory.getListRegistersView();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		logger.info(place.getEmail());
		view.setPresenter(this);
		
		updateData();
		
		
		panel.setWidget(view);
	}

	private void updateData() {
		clientFactory.getDataProvider().getRegisterList(place.getEmail(), new AsyncCallback<List<RegisterInfo>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(List<RegisterInfo> result) {
				view.setRegisters(result);
			}
		});
	}

	@Override
	public void onDelete() {
		logger.info("Delete selected");
		view.askConfirmation(view.getSelectedForDeletion().size());
	}
	
	@Override
	public void onDeleteConfirmed() {
		logger.info("delete confirmed");
		clientFactory.getDataProvider().deleteRegisters(view.getSelectedForDeletion(), place.getEmail(), new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Void result) {
				logger.info("done");
				updateData();
			}
		});
	}

	@Override
	public void onNew() {
		logger.info("New selected");
		view.getName().setText("");
		view.getDescription().setText("");
		view.showNewForm(true);
	}

	@Override
	public void onViewRegister() {
		clientFactory.getPlaceController().goTo(new RegisterPlace(view.getSelectedRegister()));
	}

	@Override
	public void onCreationCancelled() {
		view.showNewForm(false);
	}

	@Override
	public void onCreate() {
		clientFactory.getDataProvider().createRegister(place.getEmail(), view.getName().getText(), new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Long result) {
				view.showNewForm(false);
				updateData();
			}
		});
		
	}

}
