package org.fortytwo.developers.mybudget0123.client.view;

import java.util.List;

import org.fortytwo.developers.mybudget0123.shared.RegisterData;

import com.google.gwt.user.client.ui.IsWidget;

public interface RegisterView extends IsWidget {
	void setData(List<RegisterData> data);
}
