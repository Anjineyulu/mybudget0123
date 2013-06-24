package org.fortytwo.developers.mybudget0123.client.view;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.client.view.cell.CashFlowCell;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;
import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.cell.client.DateCell;
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

public class RegisterViewDefault extends Composite implements RegisterView {
	@UiField(provided = true)
	CellTable<RegisterData> registerTable;
	@UiField
	SimplePager registerTablePager;
	
	private ListDataProvider<RegisterData> registerDP;
	
	private static RegisterViewDefaultUiBinder uiBinder = GWT .create(RegisterViewDefaultUiBinder.class);

	interface RegisterViewDefaultUiBinder extends
			UiBinder<Widget, RegisterViewDefault> {
	}

	public RegisterViewDefault() {
		registerTable = new CellTable<RegisterData>();
		Column<RegisterData, Date> dateColumn = new Column<RegisterData, Date>(new DateCell()) {
			@Override
			public Date getValue(RegisterData data) {
				if (null == data) return null;
				
				return data.getDate();
			}
		};
		
		Column<RegisterData, CashFlow> flowColumn = new Column<RegisterData, CashFlow>(new CashFlowCell()) {
			@Override
			public CashFlow getValue(RegisterData data) {
				if (null == data) return null;
				return data.getCashFlow();
			}
		};
		Column<RegisterData, String> authorColumn = new Column<RegisterData, String>(new TextCell()) {

			@Override
			public String getValue(RegisterData data) {
				if (null == data) return null;
				return data.getRegisterID().toString();
			}
		};
		Column<RegisterData, String> commentColumn = new Column<RegisterData, String>(new TextCell()) {

			@Override
			public String getValue(RegisterData data) {
				if (null == data) return null;
				return data.getComment();
			}
		};
		
		registerTable.addColumn(dateColumn, "Date");
		registerTable.addColumn(flowColumn, "Amount");
		registerTable.addColumn(authorColumn, "Author");
		registerTable.addColumn(commentColumn, "Comment");
		
		initWidget(uiBinder.createAndBindUi(this));
		
		registerDP = new ListDataProvider<RegisterData>();
		registerDP.addDataDisplay(registerTable);
		registerTablePager.setDisplay(registerTable);
	}


	@Override
	public void setData(List<RegisterData> data) {
		registerDP.setList(data);
	}

}
