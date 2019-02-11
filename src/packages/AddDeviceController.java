package packages;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;

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
	
	private StringBuilder deviceList = new StringBuilder();
	
	Alert success = new Alert(AlertType.CONFIRMATION);
<<<<<<< HEAD
=======
	Alert listWindow = new Alert(AlertType.INFORMATION);
>>>>>>> 0912c46ccacdd16de633e63203e204f43212aafa
	
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
		deviceManager.addDevice( nameEntry.getText(),Integer.parseInt(this.idEntry.getText()));
		success.showAndWait();
	}
	
	@FXML
	public void showDevices()
	{
		Iterator<Entry<String, Integer>> forEachDevice = deviceManager.getDeviceMap().entrySet().iterator();
		while(forEachDevice.hasNext()) 
		{
			Map.Entry<String,Integer> val = forEachDevice.next();
			deviceList.append(val.getKey());
			deviceList.append(" ");
			deviceList.append(val.getValue());
			deviceList.append("\n");
		}
		
		listWindow.setContentText(deviceList.toString());
		listWindow.setTitle("Available Devices");
		listWindow.setHeaderText("Device Name, Device ID");
		listWindow.showAndWait();
	
	
	}
}