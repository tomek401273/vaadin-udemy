package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/checkboxes")
public class CheckBoxes extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout verticalLayout = new VerticalLayout();

		CheckBox checkBox = new CheckBox("Custom buttons: ");

		checkBox.addValueChangeListener(event -> {
			boolean check = checkBox.getValue();
			if(check==true) {
				Button button = new Button("Custom button");
				verticalLayout.addComponent(button);  
			}
		});

		verticalLayout.addComponent(checkBox);
		setContent(verticalLayout);
	}
}
