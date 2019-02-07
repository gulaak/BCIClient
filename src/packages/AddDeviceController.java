package packages;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AddDeviceController implements Initializable{
	
	@FXML
	private Button saveDevice;
	
	@FXML
	private Button showDevice;
	@FXML
	private TextField nameEntry;
	
	@FXML
	private TextField idEntry;
	
	public Scenes deviceManager = new Scenes();
	
	Alert success = new Alert(AlertType.CONFIRMATION);
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.nameEntry.setFont(new Font("Comic Sans",12));
		this.idEntry.setFont(new Font("Comic Sans",12));
		this.saveDevice.setFont(new Font("Comic Sans", 12));
		success.setTitle("Device Managed");
		success.setHeaderText("Success!");
		success.setContentText("Device successfully added");
		
	}
	
	@FXML
	public void addDevice()
	{
		deviceManager.addDevice(Integer.parseInt(this.idEntry.getText()), nameEntry.getText());
		success.showAndWait();
		
	}
	
	@FXML
	public void showDevices()
	{
		Iterator<Entry<String, Integer>> forEachDevice = deviceManager.getDeviceMap().entrySet().iterator();
		while(forEachDevice.hasNext()) 
		{
			Map.Entry<String,Integer> val = (Map.Entry<String,Integer>)forEachDevice.next();
			
			System.out.print(val.getKey());
			System.out.println(val.getValue());
		}
	
	
	}
}
