package org.fortytwo.developers.mybudget0123.client.activity;

import java.util.List;

import org.fortytwo.developers.mybudget0123.client.ClientFactory;
import org.fortytwo.developers.mybudget0123.client.place.ListRegistersPlace;
import org.fortytwo.developers.mybudget0123.client.place.RegisterPlace;
import org.fortytwo.developers.mybudget0123.client.view.ListRegistersView;
import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ListRegisterActivity extends AbstractActivity implements ListRegistersView.Presenter {
	private ListRegistersPlace place;
	private ClientFactory clientFactory;
	private ListRegistersView view;
	

	public ListRegisterActivity(ListRegistersPlace place, ClientFactory clientFactory) {
		this.place = place;
		view = clientFactory.getListRegistersView();
	}



	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		
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
		
		panel.setWidget(view);
	}

	@Override
	public void onDelete() {
		view.askConfirmation(view.getSelectedForDeletion().size());
	}
	
	@Override
	public void onDeleteConfirmed() {
		clientFactory.getDataProvider().deleteRegisters(view.getSelectedForDeletion(), place.getEmail(), new AsyncCallback<List<RegisterInfo>>(){

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
	public void onNew() {
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
		});
		
	}

}
