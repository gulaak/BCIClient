package packages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class ZWave {
	
	private static String address = "http://134.88.49.223";
	private static String port = ":8083";
	private static String authenticate = ZWave.address + ZWave.port  +"/ZAutomation/api/v1/login";
	private static HttpClient client;
	
	//get current address of http server
	public static String getAddress() {
		return ZWave.address;
	}
	// create instance of HttpClientBuilder 
	public static void create() {
		ZWave.client = HttpClientBuilder.create().build();
	}
	// set address
	public static void setAddress(String myAddress) {
		ZWave.address = myAddress;
		
	}
	// authenticate zway server
	public static void Authenticate() throws ClientProtocolException, IOException {
		HttpPost request = new HttpPost(ZWave.authenticate);
		request.setHeader(HttpHeaders.CONTENT_TYPE , "application/json");
		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		String json = "{\"form\":\"true\" ,\"login\":\"admin\",\"password\":\"ece6123\",\"keepme\":\"false\", \"default_ui\":\"1\"}";
		StringEntity entity = new StringEntity(json);
		request.setEntity(entity);
		HttpResponse statusResponse = client.execute(request);
		System.out.println(statusResponse.toString());
	
  		
	}
	
	// post request to z way server to target a device and brightness
	public static int post(int device, int brightness) throws ClientProtocolException, IOException {
		  //Gets the current status of the light
  	  	HttpPost getStatus = new HttpPost(ZWave.address + ZWave.port + "/ZWaveAPI/Run/devices%5B" + Integer.toString(device) + "%5D.instances%5B0%5D.commandClasses.SwitchMultilevel.data.level.value");
  	  	client = HttpClientBuilder.create().build();
  	  	Authenticate();
  	  	HttpResponse statusResponse = client.execute(getStatus);
  	  	BufferedReader statusOut =  new BufferedReader(new InputStreamReader(statusResponse.getEntity().getContent()));
  	  	getStatus.releaseConnection();
  	  	int status = Integer.parseInt(statusOut.readLine());
  	  	if(status > 0) { // Light on
  	  		brightness = 0;
  	  		
  	  	}
  	  		
		HttpPost postStatus = new HttpPost(ZWave.address + ZWave.port + "/ZWaveAPI/Run/devices%5B"+Integer.toString(device) +"%5D.instances%5B0%5D.Basic.Set%28" + Integer.toString(brightness)+"%29");
		HttpResponse postResponse = client.execute(postStatus);
		postStatus.releaseConnection();
		System.out.println(postResponse.toString());
		
		return 0;
		
	}
	
	public static boolean toggleRec(int device) throws ClientProtocolException, IOException {
		HttpPost getStatus = new HttpPost(ZWave.address + ZWave.port + "/ZWaveAPI/Run/devices%5b" +Integer.toString(device)+"%5D.instances%5B0%5D.commandClasses.SwitchBinary.data.level.value");
		HttpResponse statusResponse = client.execute(getStatus);
		client = HttpClientBuilder.create().build();
  	  	Authenticate();
		BufferedReader statusOut =  new BufferedReader(new InputStreamReader(statusResponse.getEntity().getContent()));
		System.out.println(statusResponse.toString());
		boolean status = Boolean.parseBoolean(statusOut.readLine());
		getStatus.releaseConnection();
		
		System.out.println(status);
		if(status == false) {
			status = true;
			
		}
		else if(status == true) {
			status = false;
		}
		System.out.println(status);
		
		HttpPost postStatus = new HttpPost(ZWave.address + ZWave.port + "/ZWaveAPI/Run/devices%5B"+Integer.toString(device) +"%5D.instances%5B0%5D.SwitchBinary.Set%28" + Boolean.toString(status)+"%29");
		HttpResponse postResponse = client.execute(postStatus);
		postStatus.releaseConnection();
		System.out.println(postResponse.toString());
			
		return status;
		
		
		
		
	}

	
	
	
	
	

}
