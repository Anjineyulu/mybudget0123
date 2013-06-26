package org.fortytwo.developers.mybudget0123.client.view;

import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.user.client.ui.IsWidget;

public interface ListRegistersView extends IsWidget {
	public interface Presenter {
		void onNewClic();
		void onRegisterSelected();
	}
	
	void setPresenter(Presenter presenter);
	void setRegisters(List<RegisterInfo> list);
}
