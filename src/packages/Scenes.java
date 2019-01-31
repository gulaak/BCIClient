package packages;

import java.io.*;

import javafx.scene.control.ToggleGroup;

public class Scenes implements Serializable {
	
	
	private static final long serialVersionUID = 4586;
	
	private transient ToggleGroup buttonStatus;
	private int sliderStatus;
	
	
	public Scenes(ToggleGroup a, int b)
	{
		buttonStatus = a;
		sliderStatus = b;
	}
	
	
	
	
	
	
}
