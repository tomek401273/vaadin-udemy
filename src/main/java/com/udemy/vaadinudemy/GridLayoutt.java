package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI(path = "/grid-layout")
public class GridLayoutt extends UI {
	@Override
	protected void init(VaadinRequest request) {
		GridLayout gridLayout = new GridLayout(2, 2);
		gridLayout.addComponent(new Label("First Label in Grid"));
		gridLayout.addComponent(new Button("ClickButton"));
		gridLayout.addComponent(new Label("Secend Label in Grid"));
		gridLayout.addComponent(new Button("Register"));
//		gridLayout.addComponent(new Button("Register"), 1, 1);
//		it is possible to change the position of the cell but 
//		I don't understand correctly how it should works 
		setContent(gridLayout);

	}
}
