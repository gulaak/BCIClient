package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class ProfileList {
	
	public static ObservableList<String> DropDown = FXCollections.observableArrayList(); // ughhhhh Java syntax
	public static ChoiceBox profiles = new ChoiceBox(); //choicebox = dropdown list. yeah, I know it sounds dumb.
	
	static public void addProfile(String name) //can add profiles using this, will put in a method later
	// to make it user editable
	{
		DropDown.add(name);
	}
}
