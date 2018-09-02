package com.udemy.vaadinudemy.errors;

import com.vaadin.server.UserError;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringUI(path="/error")
public class ErrorUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout handlingExeptionsLayout = new VerticalLayout();
		
		TextField textFiledWarning = new TextField();
		handlingExeptionsLayout.addComponent(textFiledWarning);
		
		//default
		textFiledWarning.setComponentError(null);
		
		Button buttonEventWarning = new Button("Event button Warning", event -> {
			if (textFiledWarning.getValue().matches("[0-9]+")) {
				textFiledWarning.setComponentError(new UserError("Textfiled value must start with letters not numbers!"));
			} else {
				Notification.show("Proceed", "Vaild input", Type.WARNING_MESSAGE);
			}
		} );
		
		handlingExeptionsLayout.addComponent(buttonEventWarning);
		setContent(handlingExeptionsLayout);
		
	}
}
