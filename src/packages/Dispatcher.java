package packages;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.sun.jna.Pointer;

import packages.EmoState.EE_CognitivAction_t;

public class Dispatcher {
	
	public static boolean selectionNetwork;
	
	
	public static void call(Pointer eState) {
		float currPower = EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState);
		
		if(selectionNetwork) {
			
			//Check for pushing action at a power over 0.5 and timeout false
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(7, 255);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(7, 255);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(7, 255);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				try {
					ZWave.toggleRec(3);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
		}
		else {
			
			if ((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PUSH.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(10, 20);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_PULL.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(10, 40);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if((EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState) == EE_CognitivAction_t.COG_LEFT.ToInt()) && (EmoState.INSTANCE.ES_CognitivGetCurrentActionPower(eState) > 0.5) && (LightTimer.timedout == true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(10, 10);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)==EE_CognitivAction_t.COG_RIGHT.ToInt() && (EmoState.INSTANCE.ES_CognitivGetCurrentAction(eState)>0.5)&&(LightTimer.timedout==true)) {
				LightTimer.initTimer();
				try {
					ZWave.post(10, 30);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
			
			
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


