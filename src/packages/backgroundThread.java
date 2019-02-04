package packages;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.concurrent.Service;
import javafx.concurrent.Task;



public class backgroundThread extends Thread {

	public Timer timer;
	public TimerTask task;
	public ArrayList<Integer> deviceList;
	backgroundThread(){
		this.timer = new Timer();
		this.task = new backgroundTimer();
		this.timer.schedule(task, 10000);
		this.deviceList.add(3);
		this.deviceList.add(7);
		this.deviceList.add(8);
		this.deviceList.add(9);
	
		
		
	}
	
	public void run() {
		while(true) {
			
			if(((backgroundTimer)this.task).getStatus()) {
				for(Integer iter: this.deviceList) {
					Service<Void> myservice = new Service<Void>() {

						@Override
						protected Task<Void> createTask() {
							// TODO Auto-generated method stub
							return new Task<Void>() {

								@Override
								protected Void call() throws Exception {
									// TODO Auto-generated method stub
									if(iter == 3) {
										
									}
									else {
										ZWave.getStatus(iter);
									}
									return null;
								}
								@Override
								protected void failed() {
									System.out.println("Failed Thread");
									
								}
							};
						}
						
					};
					
				}
			}
			
		}
	}
	
	
	

}
