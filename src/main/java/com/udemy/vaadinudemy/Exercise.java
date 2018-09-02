package com.udemy.vaadinudemy;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/exercise")
public class Exercise extends UI {
	@Override
	protected void init(VaadinRequest request) {
		GridLayout grid = new GridLayout(4, 2);
		grid.addComponent(new Label("First Label in Grid"), 2, 1);
	
		grid.addComponent(new Button("Register"));
		setContent(grid);
	}
}
