package com.udemy.vaadinudemy.navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ForumPageView extends VerticalLayout implements View{
public final static String NAME= "ForumPageView page";
	
	@Override
	public void enter(ViewChangeEvent event) {
		Label forumLabel = new Label("This is the ForumPageView");
		addComponent(forumLabel);
	}
}
