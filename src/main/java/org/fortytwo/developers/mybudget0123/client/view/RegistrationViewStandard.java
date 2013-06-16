package org.fortytwo.developers.mybudget0123.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class RegistrationViewStandard extends Composite implements RegistrationView {

	private static RegistrationViewStandardUiBinder uiBinder = GWT
			.create(RegistrationViewStandardUiBinder.class);

	interface RegistrationViewStandardUiBinder extends UiBinder<Widget, RegistrationViewStandard> {
	}

	public RegistrationViewStandard() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
