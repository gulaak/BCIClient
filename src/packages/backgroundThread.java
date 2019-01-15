package packages;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class backgroundThread extends Service<Integer> {

	@Override
	protected Task<Integer> createTask() {
		// TODO Auto-generated method stub
		return new Task<Integer>() {

			@Override
			protected Integer call() throws Exception {
				// TODO Auto-generated method stub
				backgroundTask();
				return 0;
			}
			
		};
	}
	
	public void backgroundTask() {
		while(true) {
			
		}
	}
	
	
	
	

}
