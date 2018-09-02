package com.udemy.vaadinudemy.grid;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.grid.HeightMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.TreeContextClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.ButtonRenderer;

@SpringUI(path = "/boxer-grid")
public class BoxerView extends UI {
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();

		List<Boxer> boxers = new ArrayList<>();
		boxers.add(new Boxer("Mike Tyson", "Super HeavyWeight", 50, false));
		boxers.add(new Boxer("Anthony Joshua", "Super HeavyWeight", 20, true));
		boxers.add(new Boxer("Canelo Alvarez", "Midleweight", 52, true));
		boxers.add(new Boxer("Genady Golovkin", "Midleweight", 38, true));
		boxers.add(new Boxer("Vassylly Lomachenko", "Super Feathewight", 11, true));

		Grid<Boxer> gridBoxers = new Grid();
		gridBoxers.addColumn(Boxer::getFullName).setCaption("Full Name");
		gridBoxers.addColumn(Boxer::getWeightClass).setCaption("Weight Class");
		gridBoxers.addColumn(Boxer::getClass).setCaption("Class");
		gridBoxers.addColumn(Boxer::getNuberOfFights).setCaption("Number Of Fight");
		gridBoxers.addColumn(Boxer::isActive).setCaption("Is Active");
		gridBoxers.addColumn(Boxer::toString).setCaption("To String");

		gridBoxers.setItems(boxers);
		gridBoxers.setHeightMode(HeightMode.ROW);
		gridBoxers.setHeightByRows(boxers.size());

		
		UI.getCurrent().getPage().getStyles().add(
				".my-grid-style"
				+" .v-grid-body"
				+" .v-grid-cell {\n"+""
				+" line-height: 20px; \n"
				+" font-size: 12px; \n"
				+" color: red;\n"
				+"}");		
		gridBoxers.setStyleName("my-grid-style");
		
		gridBoxers.setSelectionMode(SelectionMode.MULTI);
		
		gridBoxers.addColumn(boxingEvent -> "Delete Boxer", new ButtonRenderer(clickEvent -> {
			boxers.remove(clickEvent.getItem());
			gridBoxers.setItems(boxers);
		}));
		
		Tree<String> tree = new Tree<>("Programming technologies");
		
		TreeData<String> treeData = new TreeData<>();
		treeData.addItem(null, "BackEnd");
		treeData.addItem(null, "FrontEnd");
		
		treeData.addItem("BackEnd", "Java");
		treeData.addItem("BackEnd", "SQL");
		treeData.addItem("BackEnd", "Maven");
		
		treeData.addItem("FrontEnd", "Vaadin");
		treeData.addItem("FrontEnd", "HTML");
		
		tree.setDataProvider(new TreeDataProvider<>(treeData));
		tree.expand("BackEnd");

		
//		tree.addItemClickListener(event -> Notification.show("Clicked", Notification.TYPE_HUMANIZED_MESSAGE));
		
		tree.addContextClickListener(event -> Notification.show(((TreeContextClickEvent<String>) event).getItem()+" Cliked"));
		
		layout.addComponent(tree);
		
		layout.addComponent(gridBoxers);
		setContent(layout);
	}
}
