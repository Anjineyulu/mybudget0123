package org.fortytwo.developer.mybudget0123.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegisterViewDefault extends Composite implements RegisterView {

	private static RegisterViewDefaultUiBinder uiBinder = GWT .create(RegisterViewDefaultUiBinder.class);

	interface RegisterViewDefaultUiBinder extends
			UiBinder<Widget, RegisterViewDefault> {
	}

	public RegisterViewDefault() {
		initWidget(uiBinder.createAndBindUi(this));
	}


	public RegisterViewDefault(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
