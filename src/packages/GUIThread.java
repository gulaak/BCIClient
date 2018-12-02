package packages;

import application.GUIConstruct;
import javafx.application.Application;
import javafx.stage.Stage;

public class GUIThread extends Application{

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			GUIConstruct.buildGUI();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void main(String[] args) {
		Application.launch(args);
	}

}
