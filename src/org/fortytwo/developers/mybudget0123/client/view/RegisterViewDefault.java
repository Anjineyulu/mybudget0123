package org.fortytwo.developers.mybudget0123.client.view;

import java.util.Date;
import java.util.List;

import org.fortytwo.developers.mybudget0123.client.view.cell.CashFlowCell;
import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.view.client.ListDataProvider;

public class RegisterViewDefault extends Composite implements RegisterView {
	@UiField(provided = true)
	CellTable<CashFlow> registerTable;
	@UiField(provided = true)
	SimplePager registerTablePager;
	
	@UiField
	DialogBox addBox;
	
	@UiField
	DoubleBox amountTB;
	@UiField
	DatePicker datePicker;
	@UiField
    TextArea commentTB;
	@UiField
	ListBox type;
	
	private ListDataProvider<CashFlow> registerDP;
	private Presenter presenter;
	
	private static RegisterViewDefaultUiBinder uiBinder = GWT .create(RegisterViewDefaultUiBinder.class);

	interface RegisterViewDefaultUiBinder extends
			UiBinder<Widget, RegisterViewDefault> {
	}

	public RegisterViewDefault() {
		registerTable = new CellTable<CashFlow>();
		Column<CashFlow, Date> dateColumn = new Column<CashFlow, Date>(new DateCell()) {
			@Override
			public Date getValue(CashFlow data) {
				if (null == data) return null;
				
				return data.getDate();
			}
		};
		
		Column<CashFlow, CashFlow> flowColumn = new Column<CashFlow, CashFlow>(new CashFlowCell()) {
			@Override
			public CashFlow getValue(CashFlow data) {
				if (null == data) return null;
				return data;
			}
		};
		TextColumn<CashFlow> authorColumn = new TextColumn<CashFlow>(){

			@Override
			public String getValue(CashFlow object) {
				if (null != object)
					object.getAuthor();
				return null;
			}
			
		}; 
		TextColumn<CashFlow> commentColumn = new TextColumn<CashFlow>() {

			@Override
			public String getValue(CashFlow object) {
				if (null != object) return object.getComment();
				return null;
			}
			
		};
		
		registerTable.addColumn(dateColumn, "Date");
		registerTable.addColumn(flowColumn, "Amount");
		registerTable.addColumn(authorColumn, "Author");
		registerTable.addColumn(commentColumn, "Comment");
		registerTablePager = new SimplePager();
		
		initWidget(uiBinder.createAndBindUi(this));
		
		registerDP = new ListDataProvider<CashFlow>();
		registerDP.addDataDisplay(registerTable);
		registerTablePager.setDisplay(registerTable);
	}

	

	@Override
	public void setData(List<CashFlow> data) {
		registerDP.setList(data);
	}


	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@Override
	public void showAddFrame(boolean show) {
		if (show)
			addBox.center();
		else
			addBox.hide();
	}
	
	@UiHandler("genBtn")
	void onGenerateBtn(ClickEvent event) {
		presenter.onGenerate();
	}
	
	@UiHandler("addBtn")
	void onAddClicked(ClickEvent event) {
		presenter.onAddClicked();
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

}
