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
	
	
	
	public Scenes()
	{
		this.commandOne = new HashMap<Integer,Integer>();
		this.commandTwo = new HashMap<Integer,Integer>();
		this.commandThree = new HashMap<Integer,Integer>();
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
	
	
	
	
	
	
}
