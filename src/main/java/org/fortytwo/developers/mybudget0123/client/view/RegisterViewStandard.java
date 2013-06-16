package org.fortytwo.developers.mybudget0123.client.view;

import java.text.SimpleDateFormat;
import java.util.List;

import org.fortytwo.developers.mybudget0123.client.view.cell.AmountCell;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class RegisterViewStandard extends Composite implements RegisterView {
	@UiField(provided = true)
	CellTable<RegisterData> registerEntries;
	private SimplePager registerEntriesPager;
	private ListDataProvider<RegisterData> registerEntriesDataProvider;

	private static RegisterViewStandardUiBinder uiBinder = GWT.create(RegisterViewStandardUiBinder.class);

	interface RegisterViewStandardUiBinder extends UiBinder<Widget, RegisterViewStandard> {
	}

	public RegisterViewStandard() {
		registerEntries = new CellTable<RegisterData>();

		registerEntries.addColumn(new Column<RegisterData, CashFlow>(new AmountCell()) {
			@Override
			public CashFlow getValue(RegisterData data) {
				return data.getCashFlow();
			}
		}, "Amount");
		registerEntries.addColumn(new Column<RegisterData, String>(new TextCell()) {
			private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			
			@Override
			public String getValue(RegisterData data) {
				return format.format(data.getDate());
			}
			
		}, "Date");
		registerEntries.addColumn(new Column<RegisterData, String>(new TextCell()) {
			@Override
			public String getValue(RegisterData data) {
				return data.getComment();
			}
			
		}, "Commnet");
		
		registerEntriesDataProvider = new ListDataProvider<RegisterData>();
		registerEntriesDataProvider.addDataDisplay(registerEntries);
		
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setData(List<RegisterData> data) {
		registerEntriesDataProvider.setList(data);
	}

}
