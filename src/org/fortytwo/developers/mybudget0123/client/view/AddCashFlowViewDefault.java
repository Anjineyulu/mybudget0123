package org.fortytwo.developers.mybudget0123.client.view;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class AddCashFlowViewDefault extends Composite implements AddCashFlowView {

	private static AddCashFlowViewDefaultUiBinder uiBinder = GWT.create(AddCashFlowViewDefaultUiBinder.class);

	interface AddCashFlowViewDefaultUiBinder extends
			UiBinder<Widget, AddCashFlowViewDefault> {
	}

	public AddCashFlowViewDefault() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	private Presenter presenter;
	
	@UiField
	DoubleBox amountTB;
	@UiField
	DatePicker datePicker;
	@UiField
    TextArea commentTB;
	@UiField
	ListBox type;
	@UiField
	Button cancelBtn;
	@UiField
	Button createBtn;

	public AddCashFlowViewDefault(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("cancelBtn")
	void onAddCancel(ClickEvent event) {
		presenter.onAddCancelled();
	}
	
	@UiHandler("createBtn")
	void onAddConfirmed(ClickEvent event) {
		presenter.onAddConfirmed();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public HasValue<Double> getAmount() {
		return amountTB;
	}
	
	@Override
	public HasValue<Date> getDate() {
		return datePicker;
	}
	
	@Override
	public String getType() {
		return type.getValue(type.getSelectedIndex());
	}

	@Override
	public void enableFrame(boolean enabled) {
		cancelBtn.setEnabled(enabled);
		createBtn.setEnabled(enabled);
		amountTB.setEnabled(enabled);
		commentTB.setEnabled(enabled);
	}

}
