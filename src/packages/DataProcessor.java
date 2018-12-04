package packages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.stage.Stage;
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

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.*;

import application.*;


/** Simple example of JNA interface mapping and usage. */
public class DataProcessor extends javafx.application.Application 
{      
	
	static HttpPost postChange;
	static Timer timer = new Timer();
    static boolean timeout = false;
    @Override
    public void start(Stage primaryStage) {
		try {
			GUIConstruct.buildGUI();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args) throws IOException 
    {
    	
    	Threading thread = new Threading();
    	thread.start();
    	Application.launch(args);
    	
    	
    }
    
    public static void timerStart(boolean startValue) {
    	if (startValue == true) {
    		timeout = true;
    		//Wait 10 seconds for head set
    		timer.schedule(new TimerTask() {
    			  @Override
    			  public void run() {
    			    timeout = false;
    			    System.out.println("Timeout");
    			  }
    			}, 10000);
    	}
    }
   
    
    

}
