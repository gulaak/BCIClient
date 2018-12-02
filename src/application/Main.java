package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GUIConstruct.buildGUI();
			
			/* Chart Start
			NumberAxis x = new NumberAxis();
			NumberAxis y = new NumberAxis();
			LineChart<Number,Number> rtd = new LineChart<Number, Number>(x,y);
			rtd.setTitle("Random Data Because You Asked Me To");
			rtd.setHorizontalGridLinesVisible(false);
			rtd.setVerticalGridLinesVisible(false);
			x.setLabel("Data");
			y.setLabel("Other Data");
			y.setUpperBound(1);
			XYChart.Series randomdata = new XYChart.Series();
			double yfilter;
			Random yval = new Random();
			for(double i = 1; i < 20; i++)
			{
			yfilter = yval.nextInt() % 10 ;
			if(yfilter < 0)
				yfilter *= -1;
			randomdata.getData().add(new XYChart.Data(i, yfilter));
			}
			rtd.getData().add(randomdata);
			MainGUI.setCenter(rtd);
			Scene scene = new Scene(MainGUI,1000,1000); // create scene
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setFill(Color.HOTPINK); // make background pink (doesn't work anymore :( )
			primaryStage.setScene(scene); // initialize
			primaryStage.show(); // scene pops up */
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
