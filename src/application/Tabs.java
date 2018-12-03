package application;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tabs {
	
	static public TabPane tabs = new TabPane();
	static public BorderPane tab1pane = new BorderPane();
	static public BorderPane tab2pane = new BorderPane();
	
	static public void setTab1Content() // fills tab 1
	{
		tab1pane.setLeft(BoxBuild.InitSwitches()); // puts switches on left side of tab 1
		tab1pane.setBottom(BoxBuild.InitRadioBox()); // puts radio buttons on bottom of tab 1 (may move)
	}
	static public void setTab2Content() // fills tab 2
	{
		tab2pane.setCenter(ScrollingChart.createContent()); // puts chart in center of tab 2
		tab2pane.setLeft(BoxBuild.InitProfileBox()); // puts profiles on left side of tab 2
		
	}
	static public void tab1Init() // makes tab 1 exist
	{
		Tab tab1 = new Tab();
		tab1.setText("Manual Control");
		tab1.setContent(tab1pane);
		tabs.getTabs().add(tab1);
	}
	static public void tab2Init() // makes tab 2 exist
	{
		Tab tab2 = new Tab();
		tab2.setText("Action Power");
		tab2.setContent(tab2pane);
		tabs.getTabs().add(tab2);
	}
	

}
