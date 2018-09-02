package com.udemy.vaadinudemy;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/tab-sheets")
public class TabSheets extends UI {
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout verticalLayout = new VerticalLayout();

		TabSheet tabSheet = new TabSheet();

		VerticalLayout tab1 = new VerticalLayout();
		
		Label centerLeftLbl = new Label("Center Left");
		Label centerMiddleLbl = new Label("Center Middle");
		Label centerRightLbl = new Label("Center Right");
		tab1.addComponent(centerLeftLbl);
		tab1.addComponent(centerMiddleLbl);
		tab1.addComponent(centerRightLbl);
		
		tab1.setComponentAlignment(centerLeftLbl, Alignment.MIDDLE_LEFT);
		tab1.setComponentAlignment(centerMiddleLbl, Alignment.MIDDLE_CENTER);
		tab1.setComponentAlignment(centerRightLbl, Alignment.MIDDLE_RIGHT);
		
		tab1.addComponent(new Label("Label in first tab"));
		tabSheet.addTab(tab1, "BackEnd");
		tabSheet.getTab(tab1).setClosable(true);

		tabSheet.addSelectedTabChangeListener(new TabSheet.SelectedTabChangeListener() {
			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				TabSheet tabsheet = event.getTabSheet();
				Layout tab = (Layout) tabsheet.getSelectedTab();
				String caption = tabsheet.getTab(tab).getCaption();
				Notification.show("Cliked " + caption);
			}
		});

		VerticalLayout tab2 = new VerticalLayout();
		tab2.addComponent(new Label("Label in secend tab"));
		tabSheet.addTab(tab2, "FrontEnd");

		verticalLayout.addComponent(tabSheet);
		setContent(verticalLayout);
	}
}
