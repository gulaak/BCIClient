package packages;
import javafx.beans.value.ChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;


import org.apache.http.client.ClientProtocolException;

import javafx.beans.value.ObservableValue;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

	
	
	 private Image lightOn;
	
	 private Image lightOff;
	 
	 private Image recOff;
	 
	 private Image recOn;
	 
	
	 @FXML
	 private TabPane MainTabs;

	 @FXML
	 private ChoiceBox<String> choiceBox;

	 @FXML
	 private Label D1Status;

     @FXML
	 private Label D2Status;

	 @FXML
	 private Label D3Status;

	 @FXML
	 private Slider SliderD3;

	 @FXML
	 private Slider SliderD1;

	 @FXML
	 private Slider SliderD2;

	 @FXML
	 private VBox vbox;

	 @FXML
	 private RadioButton home;

	 @FXML
	 private ToggleGroup TG1;

	 @FXML
	 private RadioButton wheelChair;
	 
	 @FXML
	 private ImageView deviceOneImg;


	 @FXML
	 private Label emotivStatus;

	 @FXML
	 private ProgressBar signalProgress;

	 @FXML
	 private ProgressBar batteryProgress;

	 @FXML
	 public LineChart<String, Number> RTG;

	 @FXML
	 public CategoryAxis x;

	 @FXML
	 public NumberAxis y;
	 
	 @FXML
	 private ImageView deviceTwoImg;

	 @FXML
	 private ImageView deviceThreeImg;
	 
	 @FXML
	 private ImageView recImage;

	 @FXML
	 private Label recStatus;


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		x.setLabel("Time");
		y.setLabel("Power(0-1)");
		this.lightOn = new Image("/LightOn.PNG"); //grab image for GUI
		this.lightOff = new Image("/LightOff.PNG"); // grab image for GUI
		this.recOff = new Image("/RecOff.PNG");
		this.recOn = new Image("/RecOn.PNG");
		choiceBox.getItems().add("hello"); // add profile boxes
		this.deviceOneImg.setImage(this.lightOff); // set default image
		this.deviceTwoImg.setImage(this.lightOff);
		this.deviceThreeImg.setImage(this.lightOff);
		this.recImage.setImage(this.recOff);
		this.home.setSelected(true);
		this.signalProgress.setProgress(0.5);
		
		
		
		this.SliderD1.valueProperty().addListener(new ChangeListener<Number>() {	// change listener for device 1
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				sliderOneChanged();
			}
		});
		this.SliderD2.valueProperty().addListener(new ChangeListener<Number>() {    // change listener for device 2
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				sliderTwoChanged();
			}
		});
		this.SliderD3.valueProperty().addListener(new ChangeListener<Number>() {    // change listener for device 3
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				sliderThreeChanged();
			}
		});
		
		
		
	
//		XYChart.Series data = new XYChart.Series();
//		data.getData().add(new XYChart.Data("10",100));
//		data.getData().add(new XYChart.Data("100",200));
		

		
	}
	
	public TabPane getTabInstance() {
		return MainTabs;
	}
	
	

	@FXML
	void DeviceOne(MouseEvent event) throws ClientProtocolException, IOException {
		
		
		ZWave.create();
		ZWave.Authenticate();
		new Thread(()->{
			try {
				ZWave.post(7, 255);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		if (this.deviceOneImg.getImage() == lightOff)
		{
			this.deviceOneImg.setImage(this.lightOn);
			

				
			
		}
		else
		{
			this.deviceOneImg.setImage(this.lightOff);
			
		}
	    
	}
	
	void sliderOneChanged() {
		int brightness = (int)(Math.floor(SliderD1.getValue()));
		D1Status.setText(Integer.toString(brightness));
	}
	
	
	

    void sliderTwoChanged() {
    	int brightness = (int)(Math.floor(SliderD2.getValue()));
		D2Status.setText(Integer.toString(brightness));

    }
	

    void sliderThreeChanged() {
    	int brightness = (int)(Math.floor(SliderD3.getValue()));
		D3Status.setText(Integer.toString(brightness));

    }
	
	
	
	@FXML
	void DeviceTwo(MouseEvent event) throws ClientProtocolException, IOException {
		
		ZWave.create();
		ZWave.Authenticate();
		new Thread(()->{
			try {
				ZWave.post(8, 255);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		if (this.deviceTwoImg.getImage() == lightOff)
		{
			this.deviceTwoImg.setImage(this.lightOn);
			//ZWave.post(?, 255);
		}
		else
		{
			this.deviceTwoImg.setImage(this.lightOff);
			//ZWave.post(?, 0);
		}
	}
	
	@FXML
	void DeviceThree(MouseEvent event) {
		
		new Thread(()->{
			try {
				ZWave.post(9, 255);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).start();
		if (this.deviceThreeImg.getImage() == lightOff)
		{
			this.deviceThreeImg.setImage(this.lightOn);
			//ZWave.post(?, 255);
		}
		else
		{
			this.deviceThreeImg.setImage(this.lightOff);
			//ZWave.post(?, 0);
		}
	}

	
	public String getTabText() {
		return MainTabs.getSelectionModel().getSelectedItem().getText();
		
	}
	
	public LineChart<?,?> getChart(){
		return RTG;
	}
	
		
	
	public void plotPoint(XYChart.Series x) {
		RTG.getData().add(x);
		
	}
	
	 @FXML
	 void slider1Move(TouchEvent event) {

	 }
	 
	 @FXML
	 void recClick(MouseEvent event) throws ClientProtocolException, IOException {
		 
		 ZWave.create();
		 ZWave.Authenticate();
		 if(this.recImage.getImage() == this.recOff)
		 {
			 this.recImage.setImage(this.recOn);
			 new Thread(()-> {
				try {
					ZWave.toggleRec(3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 }).start();
		 }
		 else
		 {
			 this.recImage.setImage(this.recOff);
			 new Thread(()-> {
				 try {
					ZWave.toggleRec(3);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }).start();
			 
		 }
		 
		 	
	 }
	
	

	

	

	
	



	

	
	
	

}
