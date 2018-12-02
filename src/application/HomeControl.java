package application;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import packages.ZWave;

public class HomeControl {
	
	static public Button lightswitch = new Button("Light Switch");
	
	static public Button outlet = new Button("Outlet Control");
	
	static public Text outletStatus = new Text();
	
	static public Text lightStatus = new Text();
	
	static public void lightSwitchInit() // button logic
	{
		lightStatus.setText("Light Off");
		lightStatus.setId("off");
		outletStatus.setText("Outlet Off");
		outletStatus.setId("off");
		
		lightswitch.setOnAction(new EventHandler<ActionEvent>() { // override to toggle lights
            @Override public void handle(ActionEvent e) {
                //light on if off, off if on
            	if(lightStatus.getId() == "off")
            	{
            		lightStatus.setText("Light On");
            		lightStatus.setId("on");
            		try {
						ToggleLight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else if(lightStatus.getId() == "on")
            	{
            		lightStatus.setText("Light Off");
            		lightStatus.setId("off");
            		try {
						ToggleLight();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
		
		outlet.setOnAction(new EventHandler<ActionEvent>() { // override to toggle outlet
            @Override public void handle(ActionEvent e) {
                //outlet on if off, off if on
            	
            	if(outletStatus.getId() == "off")
            	{
            		outletStatus.setText("Outlet On");
            		outletStatus.setId("on");
            		try {
						ToggleOutlet();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else if(outletStatus.getId() == "on")
            	{
            		outletStatus.setText("Outlet Off");
            		outletStatus.setId("off");
            		try {
						ToggleOutlet();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            }
        });
	}
	
	static private void ToggleLight() throws ClientProtocolException, IOException
	{
		ZWave.post(2, 255);
		// code code code
	}
	
	static private void ToggleOutlet() throws ClientProtocolException, IOException
	{
		// code code code
		ZWave.toggleRec(3);
	}

}
