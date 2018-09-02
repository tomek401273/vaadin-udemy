package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CheckBoxGroup;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/group")
public class Groupp extends UI {
	@Override
	public void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();

		RadioButtonGroup<String> singleGroup = new RadioButtonGroup<>("E-Ship Single");
		singleGroup.setItems("Shoes", "Jeans", "Shirts");

		CheckBoxGroup<String> mulitGroup = new CheckBoxGroup<>("E-shop Multi");
		mulitGroup.setItems("Comp", "Comp + monitor", "mouse");
		
		
		RadioButtonGroup<String> buttonGroupEx= new RadioButtonGroup<>("Disable");
		buttonGroupEx.setItems("Shoes", "Jeans", "Shirts");
	
		buttonGroupEx.setItemEnabledProvider(item -> !"Jeans".equals(item));
//		layout.addComponent(singleGroup);
		layout.addComponents(singleGroup, mulitGroup, buttonGroupEx);

		setContent(layout);
	}
}
