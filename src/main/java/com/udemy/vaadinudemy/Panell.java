package com.udemy.vaadinudemy;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;

@SpringUI(path = "/panel")
public class Panell extends UI {
	@Override
	protected void init(VaadinRequest request) {
		GridLayout gridLayout = new GridLayout(2, 2);
		Panel customPanel = new Panel("Custom Panel");
		customPanel.setSizeUndefined();

		FileResource resource = new FileResource(new File("/home/tomasz/Obrazy/many.jpg"));
//		Image image = new Image(null, new ThemeResource("/home/tomasz/Obrazy/many.jpg"));
//		Image image = new Image(null, new ThemeResource("many.jpg"));
		Image image = new Image("Image from file", resource);

		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(image);
		customPanel.setContent(formLayout);
		gridLayout.addComponent(customPanel);
		setContent(gridLayout);

	}

}
