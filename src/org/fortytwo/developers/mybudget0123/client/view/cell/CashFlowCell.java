package org.fortytwo.developers.mybudget0123.client.view.cell;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class CashFlowCell extends AbstractCell<CashFlow> {

	@Override
	public void render(Context context,	CashFlow data, SafeHtmlBuilder html) {
		if (data.isTake())
			html.appendHtmlConstant("<span class=\"take\">");
		else
			html.appendHtmlConstant("<span class=\"give\">");
		html.append(data.getAmount());
		html.appendHtmlConstant("</span>");
	}

}
