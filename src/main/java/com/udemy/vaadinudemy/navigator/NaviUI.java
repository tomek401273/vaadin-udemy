package com.udemy.vaadinudemy.navigator;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path="/navi")
public class NaviUI extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout rootLayout = new VerticalLayout();
		Button forumPage = new Button("Forum Page");
		Button directoryPage = new Button("Direcory Page");
		
		Panel panelNavigator = new Panel();
		Navigator navigator = new Navigator(this, panelNavigator);
		navigator.addView(DirectoryPageView.NAME, new DirectoryPageView());
		navigator.addView(ForumPageView.NAME, new ForumPageView());
		rootLayout.addComponent(panelNavigator);
		
		rootLayout.addComponent(forumPage);
		rootLayout.addComponent(directoryPage);
		
		navigator.navigateTo(ForumPageView.NAME);
		
		directoryPage.addClickListener(event -> {
			navigator.navigateTo(DirectoryPageView.NAME);
		});
		
		forumPage.addClickListener(event -> {
			navigator.navigateTo(ForumPageView.NAME);
		});
		
		setContent(rootLayout);
		
		
	}

}
