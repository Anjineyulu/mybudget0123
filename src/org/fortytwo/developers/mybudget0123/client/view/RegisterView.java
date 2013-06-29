package org.fortytwo.developers.mybudget0123.client.view;

import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterView extends IsWidget {
	public interface Presenter {
		void onGenerate();
		void onAddClicked();
	}
	
	void setData(List<CashFlow> data);
	void setPresenter(Presenter presenter);
}
