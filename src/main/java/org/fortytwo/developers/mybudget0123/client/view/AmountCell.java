package org.fortytwo.developers.mybudget0123.client.view;

import org.fortytwo.developers.mybudget0123.shared.CashFlow;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class AmountCell extends AbstractCell<CashFlow> {
	@Override
	public void render(Context context, CashFlow data, SafeHtmlBuilder safeHtml) {
		if (null == data) return;
		safeHtml.appendHtmlConstant("<span class=\"");
		safeHtml.appendHtmlConstant(CashFlow.Type.TAKE == data.getType() ? "take" : "give"); 
		safeHtml.appendHtmlConstant("\">");
		safeHtml.append(data.getAmount());
		safeHtml.appendHtmlConstant("</span>");
	}
}
