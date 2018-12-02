package application;



import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUIConstruct { // top level, puts the pieces together
	public static BorderPane MainGUI = new BorderPane(); // create BorderPane
	public static Stage primaryStage = new Stage();
	public static Scene scene = new Scene(Tabs.tabs, 1000, 1000);
	public static void buildGUI()
	{
		
		
		ProfileList.profiles.setItems(ProfileList.DropDown); // sets up profile dropdown
		
		Tabs.setTab1Content(); // methods to organize tabs and their content
		Tabs.setTab2Content();
		Tabs.tab1Init();
		Tabs.tab2Init();
		
		primaryStage.setScene(scene); // initialize
		primaryStage.setTitle("Emotiv GUI"); //Window title
		primaryStage.show(); // scene pops up
	}
}
