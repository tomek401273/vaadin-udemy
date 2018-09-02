package com.udemy.vaadinudemy;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.ComboBox; 
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/comboboxes")
public class ComboBoxess extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		ComboBox<String> combo = new ComboBox<>("Boxers");
		List<String> myList = new ArrayList<>();
		myList.add("Comp");
		myList.add("Server");
		myList.add("Laptop");
		combo.setItems(myList);
		
		combo.setNewItemHandler(inputValue -> {
			final String tempBox = inputValue;
			myList.add(tempBox);
			combo.setItems(myList);
		});		
		layout.addComponent(combo);
		setContent(layout);
		
		
	}
}
