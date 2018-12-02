package application;


import java.util.Random;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
// git instructions: git commit, git push to update
public class ScrollingChart  // this is a mess don't look in here
{
	private LineChart<Number, Number> chart;

	private XYChart.Series<Number, Number> dataSeries;

	static private NumberAxis xAxis;
	
	static private NumberAxis yAxis;

	private Timeline animation;

	private double sequence = 0;

	private double y = 10;

	private final int MAX_DATA_POINTS = 25, MAX = 10, MIN = 5;
	
	static public LineChart createChart()
	{
		xAxis = new NumberAxis(); // create axes, x axis is dynamic so leave as blank constructor for now
		yAxis = new NumberAxis(0,100,10);
		
		xAxis.setLabel("Time"); // label axes
		yAxis.setLabel("Action Power");
		LineChart actionPower = new LineChart(xAxis,yAxis); // create and personalize chart
		actionPower.setLegendVisible(false);
		actionPower.setTitle("Current Action Power");
		actionPower.setHorizontalGridLinesVisible(false);
		actionPower.setVerticalGridLinesVisible(false);
		return actionPower;
	}
	/*public void insertData() // in main write "while(true) { run timer, insert data }
	{
		XYChart.Data data = new XYChart.Data(/*insert data from headset);
		
		dataSeries.getData().add(data);
		
	} */
}
