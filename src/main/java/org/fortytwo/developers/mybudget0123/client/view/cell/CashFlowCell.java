package org.fortytwo.developers.mybudget0123.client.view.cell;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class CashFlowCell extends AbstractCell<CashFlow> {

	@Override
	public void render(Context context,	CashFlow data, SafeHtmlBuilder html) {
		html.appendHtmlConstant("<span class=\"");
		if (data.isTake())
			html.appendHtmlConstant("take");
		else
			html.appendHtmlConstant("give");
		html.appendHtmlConstant("\">");
		html.append(data.getAmount());
		html.appendHtmlConstant("</span>");
	}

}
