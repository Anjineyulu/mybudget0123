package org.fortytwo.developers.mybudget0123.client.view;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterView extends IsWidget {
	public interface Presenter {
		void onGenerate();
		void onAddClicked();
		void onAddCancelled();
		void onAddConfirmed();
	}
	
	void setData(List<CashFlow> data);
	void setPresenter(Presenter presenter);
	void showAddFrame(boolean show);
	HasValue<Double> getAmount();
	HasValue<Date> getDate();
	String getType();
}
