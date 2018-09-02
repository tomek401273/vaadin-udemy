package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/textFiled")
public class TextFiledd extends UI {
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout verticalLayout = new VerticalLayout();
		Label label = new Label("Label Name: ", ContentMode.TEXT);

		TextField textFiled = new TextField("Text filed");
		textFiled.setValue("pancakes");
		textFiled.setMaxLength(20);

		Label conterLabel = new Label();
		conterLabel.setValue(textFiled.getValue().length() + " of" + textFiled.getValue().length());
		
		textFiled.addValueChangeListener(event -> {
			int lengthCounter = event.getValue().length();
			conterLabel.setValue(lengthCounter+" of "+textFiled.getMaxLength());
		});
		
		verticalLayout.addComponent(label);
		verticalLayout.addComponent(textFiled);
		verticalLayout.addComponent(conterLabel);
		setContent(verticalLayout);
	}
}
