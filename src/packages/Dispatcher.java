package packages;

import com.sun.jna.Pointer;

public class Dispatcher {
	
	public static boolean selectionNetwork;
	
	
	public static void call(Pointer eState) {
		float currPower = EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState);
		
		if(selectionNetwork) {
			
			
		}
		else {
			
		}
		
	}
	public static void checkNetwork() {
		if(controllerInterface.mc.getHome().isSelected()) {
			selectionNetwork = true;
		}
		else
			selectionNetwork = false;
	}

}


