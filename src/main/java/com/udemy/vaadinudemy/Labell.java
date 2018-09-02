package com.udemy.vaadinudemy;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/label")
public class Labell extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout verticalLayout = new VerticalLayout();
		
		final TextField textFiled = new TextField();
		
		Button button = new Button("Click Me");
		button.addClickListener(e-> {
			verticalLayout.addComponent(new Label("Thanks "+textFiled.getValue()+", it works!"));
		});
		verticalLayout.addComponents(textFiled, button);

		Label lorem = new Label("Lorem ipsum dolor sit amet, \n"
				+ " consectetur adipiscing elit, sed do eiusmod \t tempor incididunt "
				+ "<b>ut labore et dolore magna aliqua</b>", ContentMode.HTML);
		/*
		 * ContentMode.PREFORMATED enalble using java signs like \n \t
		 * ContentMode.HTML enable using HTML tags 
		 */
//		verticalLayout.setWidth("360");
		verticalLayout.addComponent(lorem);
//		verticalLayout.addComponent(new Label("&nbsp;", ContentMode.HTML));
		Label gapLabel = new Label();
		gapLabel.setHeight("1em");
		verticalLayout.addComponent(gapLabel);
		verticalLayout.addComponent(new Label("I like pancakes", ContentMode.HTML));

		setContent(verticalLayout);
	}
}
