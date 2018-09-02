package com.udemy.vaadinudemy.navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class DirectoryPageView extends VerticalLayout implements View{
	public final static String NAME= "DirectoryPageView page";
	
	@Override
	public void enter(ViewChangeEvent event) {
		Label diretoryLabel = new Label("This is the DriectoryPageView");
		addComponent(diretoryLabel);
	}
}
