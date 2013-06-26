package org.fortytwo.developers.mybudget0123.client.view;

import java.util.List;
import java.util.Set;

import org.fortytwo.developers.mybudget0123.shared.RegisterInfo;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

public class ListRegistersViewDefault extends Composite implements ListRegistersView {
	private Presenter presenter;
	
	@UiField(provided = true)
	CellTable<RegisterInfo> registersTable;
	@UiField(provided = true)
	SimplePager registersPager;
	@UiField
	TextBox name;
	@UiField
	TextBox description;
	@UiField
	DialogBox creationBox;
	
	private MultiSelectionModel<RegisterInfo> selectionModel;
	private ListDataProvider<RegisterInfo> registerDataProvider;
	
	private Long selectedItem;

	private static ListRegisterViewDefaultUiBinder uiBinder = GWT.create(ListRegisterViewDefaultUiBinder.class);

	interface ListRegisterViewDefaultUiBinder extends UiBinder<Widget, ListRegistersViewDefault> {
	}

	public ListRegistersViewDefault() {
		registersTable = new CellTable<RegisterInfo>();
		registersPager = new SimplePager();
		registersPager.setDisplay(registersTable);
		initWidget(uiBinder.createAndBindUi(this));
		registerDataProvider = new ListDataProvider<RegisterInfo>();
		registerDataProvider.addDataDisplay(registersTable);
		TextColumn<RegisterInfo> nameCol = new TextColumn<RegisterInfo>() {
			@Override
			public String getValue(RegisterInfo object) {
				return object.getName();
			}
		};
		TextColumn<RegisterInfo> ownerCol = new TextColumn<RegisterInfo>() {

			@Override
			public String getValue(RegisterInfo object) {
				return object.getEmail();
			}
		};
		Column<RegisterInfo, Long> viewColumn = new Column<RegisterInfo, Long>(new ActionCell<Long>("View", new ActionCell.Delegate<Long>(){
			@Override
			public void execute(Long object) {
				selectedItem = object;
				presenter.onViewRegister();
			}
			
		})) {

			@Override
			public Long getValue(RegisterInfo object) {
				return object.getKey();
			}
			
		};
		
		Column<RegisterInfo, Boolean> selectCol = new Column<RegisterInfo, Boolean>(new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(RegisterInfo object) {
				return selectionModel.isSelected(object);
			}
			
		}; 
		registersTable.addColumn(selectCol);
		registersTable.addColumn(nameCol, "Name");
		registersTable.addColumn(ownerCol, "Owner");
		registersTable.addColumn(viewColumn);
		
		selectionModel = new MultiSelectionModel<RegisterInfo>();
		registersTable.setSelectionModel(selectionModel);
	}
	
	@UiHandler("deleteBtn")
	void onDelete(ClickEvent event) {
		presenter.onDelete();
	}
	
	@UiHandler("newBtn")
	void onNewClick(ClickEvent event) {
		presenter.onNew();
	}
	
	@UiHandler("cancelBtn")
	void onCancel(ClickEvent event) {
		presenter.onCreationCancelled();
	}
	
	@UiHandler("createBtn")
	void onCreate(ClickEvent event) {
		presenter.onCreate();
	}
	
	@Override
	public Set<RegisterInfo> getSelectedForDeletion() {
		return selectionModel.getSelectedSet();
	}
	
	@Override
	public void askConfirmation(int n) {
		if (Window.confirm("Do you confirm the deletion of " + n + " registers?"))
			presenter.onDeleteConfirmed();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setRegisters(List<RegisterInfo> list) {
		registerDataProvider.setList(list);
	}
	
	@Override
	public Long getSelectedRegister() {
		return selectedItem;
	}

	@Override
	public void showNewForm(boolean show) {
		if (show) {
			creationBox.center();
		} else
			creationBox.hide();
	}

	@Override
	public HasText getName() {
		return name;
	}

	@Override
	public HasText getDescription() {
		return description;
	}

}
