package packages;

import java.io.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.ToggleGroup;

public class Scenes implements Serializable {
	
	
	
	
	private static final long serialVersionUID = 4586;
	
	private Map<Integer,Integer> commandOne;
	private Map<Integer,Integer> commandTwo;
	private Map<Integer,Integer> commandThree;
	private Map<String,Integer> deviceMap;
	private int d1;
	private int d2;
	private int d3;
	private int d4;
	private int wheelChair;
	
	
	
	public Scenes()
	{
		this.commandOne = new HashMap<Integer,Integer>();
		this.commandTwo = new HashMap<Integer,Integer>();
		this.commandThree = new HashMap<Integer,Integer>();
		this.setDeviceMap(new HashMap<String,Integer>());
	}
	
	public Map<Integer,Integer> getCommandOne() {
		return this.commandOne;
	}
	
	public void setCommandOne(int key, int value) {
		this.commandOne.put(key, value);
	}
	
	public Map<Integer,Integer> getCommandTwo(){
		return this.commandTwo;
	}
	
	public void setCommandTwo(int key,int value) {
		this.commandTwo.put(key, value);
	}
	public Map<Integer,Integer> getCommandThree(){
		return this.commandThree;
	}
	
	public void setCommandThree(int key, int value) {
		this.commandThree.put(key, value);
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public int getD2() {
		return d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
	}

	public int getD3() {
		return d3;
	}

	public void setD3(int d3) {
		this.d3 = d3;
	}

	public int getD4() {
		return d4;
	}

	public void setD4(int d4) {
		this.d4 = d4;
	}

	public int getWheelChair() {
		return wheelChair;
	}

	public void setWheelChair(int wheelChair) {
		this.wheelChair = wheelChair;
	}

	public void addDevice(String name, int id) {
		this.getDeviceMap().put(name,id);
		
	}

	public Map<String,Integer> getDeviceMap() {
		return deviceMap;
	}

	public void setDeviceMap(Map<String,Integer> deviceMap) {
		this.deviceMap = deviceMap;
	}
	
	
	
	
	
	
}
