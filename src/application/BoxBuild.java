package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BoxBuild {
	
	

	static public HBox InitRadioBox() // box containing radio buttons for switching headset target
	{
		TargetSelect.RadioInit();
		HBox buttons = new HBox(); // new horizontal box for buttons
		buttons.getChildren().add(TargetSelect.RC);
		buttons.getChildren().add(TargetSelect.home);
		buttons.setPadding(new Insets(0,0,0,450)); // pads box over to the right by 450 arbitrary distance units?
		return buttons;
	}
	static public HBox TitleBox() // currently defunct, may remove
	{	
		HBox title = new HBox();
		Text t = new Text(); // new text structure
		t.setFont(new Font(40)); // set font size to 40
		t.setText("Emotiv GUI"); 
		t.setFill(Color.RED); // make text red
		title.setPadding(new Insets(0,0,0,400)); //top right bottom left
		title.getChildren().add(t); // add text to horizontal box
		return title;
	}
	static public VBox InitProfileBox() // creates box for profile list to live in
	{
		VBox profileList = new VBox();
		profileList.getChildren().add(ProfileList.profiles);
		ProfileList.addProfile("Aiden");
		return profileList;
	}
	
	static public VBox InitSwitches() //creates box containing switches for tab 1
	{
		VBox switches = new VBox();
		HomeControl.lightSwitchInit(); //handles button logic
		switches.getChildren().add(HomeControl.lightswitch);
		switches.getChildren().add(HomeControl.lightStatus);
		switches.getChildren().add(HomeControl.outlet);
		switches.getChildren().add(HomeControl.outletStatus);
		switches.setPadding(new Insets(400,0,0,400));
		return switches;
	}
	
	
	
	
}
