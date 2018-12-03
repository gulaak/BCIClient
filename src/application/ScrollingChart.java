package application;


import java.util.Random;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.chart.Chart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.util.Duration;
// git instructions: git commit, git push to update
public class ScrollingChart  // this is a mess don't look in here
{
	static private LineChart<Number, Number> chart;

	static private XYChart.Series<Number, Number> dataSeries;

	static private NumberAxis xAxis;

	public static Timeline animation;

	static private double sequence = 0;

	static private double y = 10;

	static private final int MAX_DATA_POINTS = 30, MAX = 1, MIN = 0;

	public ScrollingChart() {

	    // create timeline to add new data every 60th of second
	    animation = new Timeline();
	    animation.getKeyFrames()
	            .add(new KeyFrame(Duration.millis(1000), 
	                    (ActionEvent actionEvent) -> plotTime()));
	    animation.setCycleCount(Animation.INDEFINITE); // run forever
	}

	static public Parent createContent() {

	    xAxis = new NumberAxis(0, MAX_DATA_POINTS, 3); 
	    final NumberAxis yAxis = new NumberAxis(MIN, MAX, 0.1); // action power percentage
	    chart = new LineChart<>(xAxis, yAxis);
	    new ScrollingChart();
	    // setup chart
	    chart.setAnimated(false);
	    chart.setLegendVisible(false);
	    chart.setTitle("Action Power");
	    xAxis.setLabel("Time");
	    xAxis.setForceZeroInRange(false);

	    yAxis.setLabel("Magnitude");

	    // add starting data
	    dataSeries = new XYChart.Series<>();
	    dataSeries.setName("Data");

	    // create some starting data
	    dataSeries.getData()
	            .add(new XYChart.Data<Number, Number>(++sequence, y));

	    chart.getData().add(dataSeries);
	    animation.play();
	    return chart;
	}

	private void plotTime() {
	    dataSeries.getData().add(new XYChart.Data<Number, Number>(++sequence, getNextValue()));

	    // after 25hours delete old data
	    if (sequence > MAX_DATA_POINTS) {
	        dataSeries.getData().remove(0);
	    }

	    // every hour after 24 move range 1 hour
	    if (sequence > MAX_DATA_POINTS - 1) {
	        xAxis.setLowerBound(xAxis.getLowerBound() + 1);
	        xAxis.setUpperBound(xAxis.getUpperBound() + 1);
	    }
	}

	private float getNextValue(){     
	    Random rand = new Random();
	    return rand.nextFloat();     
	}
}
