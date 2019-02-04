package packages;

import java.util.TimerTask;

public class backgroundTimer extends TimerTask {
	private boolean statusFlag;
	
	public backgroundTimer() {
		this.setStatus(false);
	}
	
	public boolean getStatus() {
		return this.statusFlag;
		
	}
	public void setStatus(boolean status) {
		this.statusFlag = status;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.statusFlag = !this.statusFlag;
		
		
		
	}

}
