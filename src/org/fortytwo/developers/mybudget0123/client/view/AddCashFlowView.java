package org.fortytwo.developers.mybudget0123.client.view;

import java.util.Date;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;

public interface AddCashFlowView extends IsWidget {
	public interface Presenter {

		void onAddCancelled();

		void onAddConfirmed();
		
	}
	
	void setPresenter(Presenter presenter);

	HasValue<Double> getAmount();

	HasValue<Date> getDate();

	String getType();

	void enableFrame(boolean enable);

	HasValue<String> getMessage();

	void enableMessage(boolean enable);
}
