package packages;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.sun.jna.Pointer;

import packages.EmoState.EE_CognitivAction_t;

public class Dispatcher {
	
	public static boolean selectionNetwork;
	public static boolean selectionSuite;
	
	
	public static void call(Pointer eState) throws ClientProtocolException, IOException {
		if(selectionSuite) { // pick passed on the current targeted application suite
			callCognitive(eState);
		}
		else
			callExpressive(eState);

		
	}
	
	public static void callExpressive(Pointer eState) throws ClientProtocolException, IOException {
		float currPower = EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState);
		
		if(selectionNetwork) {
			
			//Check for pushing action at a power over 0.5 and timeout false
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(7, 255);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(8, 255);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(9, 255);
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				ZWave.toggleRec(3);
			
			}
			
			
		}
		else {
			
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10,20);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10, 40);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10,10);
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				ZWave.post(10, 30);
			
			}
			
			
			
			
		}
		
	}
	
	public static void callCognitive(Pointer eState) throws ClientProtocolException, IOException {
		
		
		float currPower = EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState);
		
		if(selectionNetwork) {
			
			//Check for pushing action at a power over 0.5 and timeout false
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(7, 255);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(8, 255);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(9, 255);
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				ZWave.toggleRec(3);
			
			}
			
			
		}
		else {
			
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10,20);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10, 40);
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				ZWave.post(10,10);
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				ZWave.post(10, 30);
			
			}
			
			
			
			
		}
		
	}
	public static void checkNetwork() {
		if(controllerInterface.mc.getHome().isSelected() && controllerInterface.mc.getCognitive().isSelected()) {
			selectionNetwork = true;
			selectionSuite = controllerInterface.mc.getCognitive().isSelected();
		}
		else
			selectionNetwork = false;
			selectionSuite = controllerInterface.mc.getCognitive().isSelected();
	}

}


