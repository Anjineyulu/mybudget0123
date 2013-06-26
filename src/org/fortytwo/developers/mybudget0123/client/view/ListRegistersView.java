package org.fortytwo.developers.mybudget0123.client.view;

import java.util.List;
import java.util.Set;

import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;

public interface ListRegistersView extends IsWidget {
	public interface Presenter {
		void onViewRegister();
		void onDelete();
		void onNew();
		void onDeleteConfirmed();
		void onCreate();
		void onCreationCancelled();
	}
	
	void setPresenter(Presenter presenter);
	void setRegisters(List<RegisterInfo> list);
	Long getSelectedRegister();
	Set<RegisterInfo> getSelectedForDeletion();
	void askConfirmation(int n);
	void showNewForm(boolean show);
	HasText getName();
	HasText getDescription();
}
