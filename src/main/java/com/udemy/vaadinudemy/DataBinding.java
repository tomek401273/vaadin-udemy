package com.udemy.vaadinudemy;

import com.udemy.vaadinudemy.grid.Boxer;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

@SpringUI(path = "/databinding")
public class DataBinding extends UI {
	@Override
	protected void init(VaadinRequest request) {
		GridLayout gridLayout = new GridLayout(2, 2);
		Panel customPanel = new Panel("Custom Panel");
		customPanel.setSizeUndefined();
		
		TextField fullName = new TextField();
		TextField weightClass = new TextField();
		TextField nubmerOfFights = new TextField();
		TextField isActive = new TextField();

		Binder<Boxer> binder = new Binder<>();
		binder.forField(fullName).withValidator(name -> name.length() >= 5, "Full name at least five letters")
				.bind(Boxer::getFullName, Boxer::setFullName);

		binder.forField(weightClass).asRequired("Boxers must have weith class")
				.withValidator(weight -> weight.length() >= 1, "WeightClass at least two letters")
				.bind(Boxer::getWeightClass, Boxer::setWeightClass);

		Boxer newBoxer = new Boxer();
		binder.readBean(newBoxer);

		Button eventButon = new Button("Event Button", event -> {
			try {
				binder.writeBean(newBoxer);
				Notification.show(newBoxer + "");
				System.out.println(newBoxer);
			} catch (Exception e) {
				Notification.show("Boxer could not be validated");
			}
		});
		
		FormLayout formLayout = new FormLayout();
		formLayout.addComponent(fullName);
		formLayout.addComponent(weightClass);
		formLayout.addComponent(nubmerOfFights);
		formLayout.addComponent(isActive);
		formLayout.addComponent(eventButon);

		customPanel.setContent(formLayout);
		gridLayout.addComponent(customPanel);
		setContent(gridLayout);
	}
}
