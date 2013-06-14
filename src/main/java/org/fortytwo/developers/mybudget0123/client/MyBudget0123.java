package org.fortytwo.developers.mybudget0123.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class MyBudget0123 implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootLayoutPanel.get().add(new Label("THIS IS A TEST!!"));
	}

}
