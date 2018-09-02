package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/button")
public class Butonn extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout verticalLayout = new VerticalLayout();

		TextField textFiled = new TextField(); 
		textFiled.setValue("Insert text here");
		
		Button button = new Button("Click me");
		button.addClickListener(event -> {
			Label custom = new Label();
			custom.setValue(textFiled.getValue());
			verticalLayout.addComponent(custom);
			Notification.show("New label has been added with button");
		});
		verticalLayout.addComponent(textFiled);
		verticalLayout.addComponent(button);
		setContent(verticalLayout);
	}
}
