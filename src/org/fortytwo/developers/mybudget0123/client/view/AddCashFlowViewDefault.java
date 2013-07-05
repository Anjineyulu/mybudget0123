package org.fortytwo.developers.mybudget0123.client.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
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
	
	//@UiField
	DoubleBox amountTB;
	//@UiField
	DatePicker datePicker;
	//@UiField
    TextArea commentTB;
	//@UiField
	ListBox type;
	//@UiField
	Button cancelBtn;
	//@UiField
	Button createBtn;
	/*@UiField*/
	Label message;
	HasValue<String> messageWrapper;

	public AddCashFlowViewDefault(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		messageWrapper = new HasValue<String>() {
			List<ValueChangeHandler<String>> handlers = new ArrayList<ValueChangeHandler<String>>();
			
			@Override
			public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<String> handler) {
				handlers.add(handler);
				
				return new HandlerRegistration() {
					@Override
					public void removeHandler() {
						handlers.remove(handlers.indexOf(handler));
					}
				};
			}

			@Override
			public void fireEvent(GwtEvent<?> event) {
				
			}

			@Override
			public String getValue() {
				return message.getText();
			}

			@Override
			public void setValue(String value) {
				setValue(value, true);
				
			}

			@Override
			public void setValue(String value, boolean fireEvents) {
				message.setText(value);
				if (fireEvents)
					; // TMCH
					/*for (ValueChangeHandler<String> handler : handlers)
						handler.onValueChange(new ValueChangeEvent<String>(value));*/
			}
		};
	}
/*
	@UiHandler("cancelBtn")
	void onAddCancel(ClickEvent event) {
		presenter.onAddCancelled();
	}
	
	@UiHandler("createBtn")
	void onAddConfirmed(ClickEvent event) {
		presenter.onAddConfirmed();
	}
*/
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

	@Override
	public HasValue<String> getMessage() {
		return messageWrapper;
	}

	@Override
	public void enableMessage(boolean enable) {
		message.setVisible(enable);
	}

}
