package packages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class backgroundThread extends Thread {


	public ArrayList<Integer> deviceList;

	Timer timer;
	TimerTask task;
	
	backgroundThread(){
		timer = new Timer();
		this.task = new backgroundTimer();
		this.timer.schedule(task, 2000 , 1000);
		this.deviceList = new ArrayList<Integer>();
		this.deviceList.add(3);
		this.deviceList.add(7);
		this.deviceList.add(8);
		this.deviceList.add(9);		
	}
	
	public void run() {
		while(true) {
		
			
			if(((backgroundTimer)this.task).getStatus() && (controllerInterface.mc.getTabText().trim().equals("Home"))) {
				((backgroundTimer)this.task).setStatus(false);
				
				for(Integer iter : this.deviceList) {
					Platform.runLater(()->{
						// TODO Auto-generated method stub
						if(iter == 3) {
							boolean status;
							if(controllerInterface.mc.getRecStatus().getText() == "On") {
								status = true;
							}
							else
								status = false;
							try {
								if(ZWave.getRecStatus(iter) != status) {
									if(status == false) {
										controllerInterface.mc.getRecImage().setImage(controllerInterface.mc.getRecOn());
										controllerInterface.mc.getRecStatus().setText("On");
									}
									else {
										controllerInterface.mc.getRecImage().setImage(controllerInterface.mc.getRecOff());
										controllerInterface.mc.getRecStatus().setText("Off");
									}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else {
						
							int status = Integer.parseInt(controllerInterface.mc.getDeviceStatus(iter).getText());
							int serverStatus;
							try {
								serverStatus = ZWave.getStatus(iter);
								if (!(Math.abs((serverStatus - status)) <4)) {
									 controllerInterface.mc.getDeviceStatus(iter).setText(Integer.toString(serverStatus));;
									 controllerInterface.mc.getDeviceSlider(iter).setValue((double)(serverStatus));
									 if(serverStatus > 0)
										 controllerInterface.mc.getDeviceImage(iter).setImage(controllerInterface.mc.getLightOn());
									 else
										 controllerInterface.mc.getDeviceImage(iter).setImage(controllerInterface.mc.getLightOff());
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
						});
						
						
					}
	

			}
		}
	}
}
