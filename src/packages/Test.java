package packages;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class Test {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		
		ZWave.create();
		ZWave.Authenticate();

		while(true) {
		
			if(LightTimer.timedout == true) {
				ZWave.post(2, 255);
				LightTimer.initTimer();
			}
			
		}

	}

}
