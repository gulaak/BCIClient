package packages;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

	public static MainController mc;
	
	 Image lightOn;
	
	 Image lightOff;
	
	
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

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		x.setLabel("Time");
		y.setLabel("Power(0-1)");
		this.lightOn = new Image("/LightOn.PNG"); //grab image for GUI
		this.lightOff = new Image("/LightOff.PNG"); // grab image for GUI
		choiceBox.getItems().add("hello"); // add profile boxes
		this.deviceOneImg.setImage(this.lightOff); // set defualt image
		
		
	
//		XYChart.Series data = new XYChart.Series();
//		data.getData().add(new XYChart.Data("10",100));
//		data.getData().add(new XYChart.Data("100",200));
		

		
	}
	
	public TabPane getTabInstance() {
		return MainTabs;
	}
	
	

	@FXML
	void DeviceOne(MouseEvent event) throws ClientProtocolException, IOException {
		this.deviceOneImg.setImage(this.lightOn);
	    //ZWave.post(2, 255);
	}
	
	void slider1changed() {
		System.out.println(SliderD1.getValue());
	}
	
	@FXML
    void Slider1Click(MouseEvent event) {
		D1Status.setText(Integer.toString((int)Math.floor(SliderD1.getValue())));

    }
	
	@FXML
    void Slider2Click(MouseEvent event) {
		D2Status.setText(Integer.toString((int)Math.floor(SliderD2.getValue())));

    }
	
	@FXML
    void Slider3Click(MouseEvent event) {
		D3Status.setText(Integer.toString((int)Math.floor(SliderD3.getValue())));

    }
	
	
	
	@FXML
	void DeviceTwo(MouseEvent event) throws ClientProtocolException, IOException {
		ZWave.post(3, 255);
	}
	
	@FXML
	void DeviceThree(MouseEvent event) {

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
	
	

	

	

	
	



	

	
	
	

}
