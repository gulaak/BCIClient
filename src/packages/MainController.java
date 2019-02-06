package packages;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;


import org.apache.http.client.ClientProtocolException;


import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;




import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;

public class MainController implements Initializable, Serializable {

	
	
	 private Image lightOn;
	
	 private Image lightOff;
	 
	 private Image recOff;
	 
	 private Image recOn;
	 
	 private String settingsFileName = "sceneSettings.txt";
	
	 @FXML
	 private TabPane MainTabs;

	 @FXML
	 private ChoiceBox<String> choiceBox;

	 @FXML
	 private Label D1Status;
	 
	 @FXML
	 private ToggleGroup TG3;

     @FXML
	 private Label D2Status;

	 @FXML
	 private Label D3Status;
	 
	 @FXML
	 private Label sceneSliderStatusOne;
	 
	 @FXML
	 private Label sceneSliderStatusTwo;
	 
	 @FXML
	 private Label sceneSliderStatusThree;

	 @FXML
	 private Slider SliderD3;

	 @FXML
	 private Slider SliderD1;

	 @FXML
	 private Slider SliderD2;
	 
	 @FXML
	 public Slider sceneSliderOne;
	 
	 @FXML
	 public Slider sceneSliderTwo;
	 
	 @FXML
	 public Slider sceneSliderThree;
	 
	 

	 @FXML
	 private VBox vbox;

	 @FXML
	 private RadioButton home;

	 @FXML
	 private ToggleGroup TG1;
	 
	
	 
	 @FXML
	 private RadioButton wheelChair;
	 
	
	 
	 @FXML
	 private ImageView deviceOneImg;


	 @FXML
	 private Label emotivStatus;

	 @FXML
	 private ProgressBar signalProgress;

	 @FXML
	 private ProgressBar batteryProgress;

	 @FXML
	 public LineChart<String, Number> RTG;

	 @FXML
	 public CategoryAxis x;

	 @FXML
	 public NumberAxis y;
	 
	 @FXML
	 private ImageView deviceTwoImg;

	 @FXML
	 private ImageView deviceThreeImg;
	 
	 @FXML
	 private ImageView recImage;

	 @FXML
	 private Label recStatus;
	 
	 @FXML
	 private Polygon forwardPoly;

	 @FXML
	 private Polygon leftPoly;

	 @FXML
	 private Polygon rightPoly;

	 @FXML
	 private Polygon reversePoly;

	 @FXML
	 private ListView<String> sceneListView;
	 
	 @FXML
	 private Button sceneSave;
	 
	 public Scenes commandSettings;
	 
	 @FXML
	 private RadioButton cognitive;

	 @FXML
	 private RadioButton expressive;
	 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		x.setLabel("Time");
		y.setLabel("Power(0-1)");
		x.setScaleX(1.00);
		sceneListView.setItems(FXCollections.observableArrayList("Pull" , "Push" , "Left"));
		sceneListView.getSelectionModel().getSelectedItem();
		this.setLightOn(new Image("/LightOn.PNG")); //grab image for GUI
		this.setLightOff(new Image("/LightOff.PNG")); // grab image for GUI
		this.setRecOff(new Image("/RecOff.PNG"));
		this.setRecOn(new Image("/RecOn.PNG"));
		choiceBox.getItems().add("hello"); // add profile boxes
		this.getDeviceOneImg().setImage(this.getLightOff()); // set default image
		this.getDeviceTwoImg().setImage(this.getLightOff());
		this.getDeviceThreeImg().setImage(this.getLightOff());
		this.getRecImage().setImage(this.getRecOff());
		this.getHome().setSelected(true);
		this.getCognitive().setSelected(true);
		
		this.D1Status.setText("0");
		this.D2Status.setText("0");
		this.D3Status.setText("0");
		this.recStatus.setText("Off");
		
		
		this.sceneSliderOne.valueProperty().addListener(new ChangeListener<Number>() {	// change listener for device 1
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int sliderValue = (int)(Math.floor(sceneSliderOne.getValue()));
				sceneSliderStatusOne.setText(Integer.toString(sliderValue));
			}
		});
		
		this.sceneSliderTwo.valueProperty().addListener(new ChangeListener<Number>() {	// change listener for device 1
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int sliderValue = (int)(Math.floor(sceneSliderTwo.getValue()));
				sceneSliderStatusTwo.setText(Integer.toString(sliderValue));
			}
		});
		
		this.sceneSliderThree.valueProperty().addListener(new ChangeListener<Number>() {	// change listener for device 1
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int sliderValue = (int)(Math.floor(sceneSliderThree.getValue()));
				sceneSliderStatusThree.setText(Integer.toString(sliderValue));
			}
		});
		
		FileInputStream file;
		try {
			file = new FileInputStream(settingsFileName);
			 ObjectInputStream in = new ObjectInputStream(file); 
			 commandSettings = (Scenes)in.readObject(); 
			 ZWave.commandSettings = this.commandSettings;
		     in.close(); 
		     file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			commandSettings = new Scenes();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			commandSettings = new Scenes();
			ZWave.commandSettings = new Scenes();
			e.printStackTrace();
		} 
		ZWave.commandSettings.setD1(7);
		ZWave.commandSettings.setD2(8);
		ZWave.commandSettings.setD3(9);
		ZWave.commandSettings.setD4(3);
		ZWave.commandSettings.setWheelChair(13);
		
	}
	
	public TabPane getTabInstance() {
		return MainTabs;
	}
	
	

	@FXML
	void DeviceOne(MouseEvent event) throws ClientProtocolException, IOException {

		

		Service<Void> myservice = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				// TODO Auto-generated method stub
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						// TODO Auto-generated method stub

						
						ZWave.post(ZWave.commandSettings.getD1(), 99);
						return null;
						
					}
					
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					
					@Override
					protected void succeeded() {
//						if(getDeviceOneImg().getImage()==getLightOff()) {
//							getDeviceOneImg().setImage(getLightOn());
//							getD1Status().setText(Integer.toString(99));
//						}
//						else {
//							getDeviceOneImg().setImage(getLightOff());
//							getD1Status().setText(Integer.toString(0));
//						}

					
					}
				};

			}
		};
		
			

		myservice.start();

	}	
    @FXML
    void keyPress(KeyEvent event) throws ClientProtocolException, IOException {
    	System.out.println("Trigger" + event.getCode());
    	switch(event.getCode()) {
    		case W:
    			System.out.println("Forward");
    			ZWave.rcForward();
    			break;
    		case A:
    			System.out.println("Left");
    			ZWave.rcLeft();
    			break;
    		case D:
    			System.out.println("Right");
    			ZWave.rcRight();
    			break;
    		case S:
    			System.out.println("Reverse");
    			ZWave.rcReverse();
    			break;
			default:
				ZWave.rcStop();
				break;
    	
    	}
    	

    }
    
    
	@FXML
	void sliderOneChanged(MouseEvent event){
		int brightness = (int)(Math.floor(SliderD1.getValue()));
		getD1Status().setText(Integer.toString(brightness));
		DeviceOne(brightness);
	}
	
	@FXML
	void sliderTwoChanged(MouseEvent event) {
		int brightness = (int)(Math.floor(SliderD2.getValue()));
		getD2Status().setText(Integer.toString(brightness));
		DeviceTwo(brightness);
	}
	
	
	@FXML
    void sliderThreeChanged(MouseEvent event) {
    	int brightness = (int)(Math.floor(SliderD3.getValue()));
		getD3Status().setText(Integer.toString(brightness));
		DeviceThree(brightness);

    }
	

	@FXML
	void DeviceTwo(MouseEvent event) {

		Service<Void> myservice = new Service<Void>() {

			@Override
			protected Task<Void> createTask() {
				// TODO Auto-generated method stub
				return new Task<Void>() {

					@Override
					protected Void call() throws Exception {
						// TODO Auto-generated method stub

						ZWave.post(ZWave.commandSettings.getD2(), 99);
						return null;
						
					}
					
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					
					@Override
					protected void succeeded() {
//						if(getDeviceTwoImg().getImage()==getLightOff()) {
//							getDeviceTwoImg().setImage(getLightOn());
//							getD2Status().setText(Integer.toString(99));
//						}
//						else {
//							getDeviceTwoImg().setImage(getLightOff());
//							getD1Status().setText(Integer.toString(0));
//						}

					}
				};
			};	
		};
		myservice.start();
	}
	
	@FXML
	void DeviceThree(MouseEvent event) {
		
		Service<Void> myservice = new Service<Void>() {
			@Override
			protected Task<Void> createTask() {
				// TODO Auto-generated method stub
				return new Task<Void>() {
					@Override
					protected Void call() throws Exception {
						// TODO Auto-generated method stub
						ZWave.post(ZWave.commandSettings.getD3(), 99);
						return null;
					}
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					@Override
					protected void succeeded() {
//						if(getDeviceThreeImg().getImage()==getLightOff()) {
//							getDeviceThreeImg().setImage(getLightOn());
//							getD3Status().setText(Integer.toString(99));
//						}
//						else {
//							getDeviceThreeImg().setImage(getLightOff());
//							getD3Status().setText(Integer.toString(0));
//						}
					}
				};
			};
		};
		myservice.start();
	}

	
	public String getTabText() {
		return MainTabs.getSelectionModel().getSelectedItem().getText();
		
	}
	
	public LineChart<?,?> getChart(){
		return RTG;
	}
	
		
	
	public void plotPoint(XYChart.Series x) {
		RTG.getData().add(x);
		
	}
	
	 @FXML
	 void slider1Move(TouchEvent event) {

	 }
	 
	 @FXML
	 public void saveScene() throws Exception
		{
		 	if(controllerInterface.mc.sceneListView.getSelectionModel().getSelectedIndex() < 0) {
		 		Alert alert = new Alert(AlertType.ERROR);
		 		alert.setTitle("Error");
		 		alert.setHeaderText("Error");
		 		alert.setContentText("Please select a target command");

		 		alert.showAndWait();
		 		return;
		 	}
		 
		 	switch(controllerInterface.mc.sceneListView.getSelectionModel().getSelectedItem()) { // save state based on current settings
		 		case "Push":
		 			this.commandSettings.setCommandOne(7, (int)controllerInterface.mc.sceneSliderOne.getValue());
		 			this.commandSettings.setCommandOne(8, (int)controllerInterface.mc.sceneSliderTwo.getValue());
		 			this.commandSettings.setCommandOne(9, (int)controllerInterface.mc.sceneSliderThree.getValue());
		 			break;
		 		case "Pull":
		 			this.commandSettings.setCommandTwo(7, (int)controllerInterface.mc.sceneSliderOne.getValue());
		 			this.commandSettings.setCommandTwo(8, (int)controllerInterface.mc.sceneSliderTwo.getValue());
		 			this.commandSettings.setCommandTwo(9, (int)controllerInterface.mc.sceneSliderThree.getValue());
		 			break;
		 		case "Left":
		 			this.commandSettings.setCommandThree(7, (int)controllerInterface.mc.sceneSliderOne.getValue());
		 			this.commandSettings.setCommandThree(8, (int)controllerInterface.mc.sceneSliderTwo.getValue());
		 			this.commandSettings.setCommandThree(9, (int)controllerInterface.mc.sceneSliderThree.getValue());
		 			break;
		 		default:
		 			throw new Exception();
		 	}
		 	
			try {
				FileOutputStream settings = new FileOutputStream(settingsFileName);
				ObjectOutputStream save = new ObjectOutputStream(settings); 
				
				save.writeObject(this.commandSettings);
				Alert alert = new Alert(AlertType.CONFIRMATION);
		 		alert.setTitle("Success");
		 		alert.setHeaderText("Success");
		 		alert.setContentText("Scene Settings Saved");
		 		alert.showAndWait();
				
				save.close();
				settings.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("bad1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("bad2");
			}
		}
	 
	 @FXML
	 void recClick(MouseEvent event){
		 
		 
		 
			Service<Void> myservice = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					// TODO Auto-generated method stub
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							// TODO Auto-generated method stub
							
							ZWave.toggleRec(ZWave.commandSettings.getD4());
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
//							 if(getRecImage().getImage() == getRecOff())
//							 {
//								 getRecImage().setImage(getRecOn());
//								 getRecStatus().setText("On");
//								
//							 }
//							 else {
//								 getRecImage().setImage(getRecOff());
//								 getRecStatus().setText("Off");
//							 }
					}
				};

				
				
				};
			};
			
			myservice.start();	
		 	
	 }
	 
	 
		void DeviceOne(int brightness) {

			
			Service<Void> myservice = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					// TODO Auto-generated method stub
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							// TODO Auto-generated method stub
							ZWave.sliderPost(ZWave.commandSettings.getD1(), brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
//							if(brightness > 0) {
//								getDeviceOneImg().setImage(getLightOn());
//								getD1Status().setText(Integer.toString(brightness));
//							}
//							else {
//								getDeviceOneImg().setImage(getLightOff());
//								getD1Status().setText(Integer.toString(brightness));
//							}
						}
						
					};
				}

				
				
			};
			
			myservice.start();
			
			
			
				
			
		}
		
		
		
		void DeviceTwo(int brightness)  {
			
			Service<Void> myservice = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					// TODO Auto-generated method stub
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							// TODO Auto-generated method stub
							
							ZWave.sliderPost(ZWave.commandSettings.getD1(), brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
//							if(brightness > 0) {
//								getDeviceTwoImg().setImage(getLightOn());
//								getD2Status().setText(Integer.toString(brightness));
//							}
//							else {
//								getDeviceTwoImg().setImage(getLightOff());
//								getD2Status().setText(Integer.toString(brightness));
//							}
						}
						
					};
				}

				
				
			};
			
			myservice.start();
		}
		
		
		
		void DeviceThree(int brightness) {
			
			Service<Void> myservice = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					// TODO Auto-generated method stub
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							// TODO Auto-generated method stub
							ZWave.sliderPost(ZWave.commandSettings.getD3(), brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
//							if(brightness > 0) {
//								getDeviceThreeImg().setImage(getLightOn());
//								getD3Status().setText(Integer.toString(brightness));
//							}
//							else {
//								getDeviceThreeImg().setImage(getLightOff());
//								getD3Status().setText(Integer.toString(brightness));
//							}
						}
						
					};
				}
				
			};
			
			myservice.start();
		}

		public ProgressBar getSignalProgress() {
			return signalProgress;
		}

		public void setSignalProgress(ProgressBar signalProgress) {
			this.signalProgress = signalProgress;
		}

		public Label getEmotivStatus() {
			return emotivStatus;
		}

		public void setEmotivStatus(Label emotivStatus) {
			this.emotivStatus = emotivStatus;
		}

		public ProgressBar getBatteryProgress() {
			return batteryProgress;
		}

		public void setBatteryProgress(ProgressBar batteryProgress) {
			this.batteryProgress = batteryProgress;
		}
		
		
		@FXML
		void shutdown(ActionEvent event) {
			Platform.exit();
			System.exit(0);
			System.out.println("Exit");

		}

		public RadioButton getHome() {
			return home;
		}

		public void setHome(RadioButton home) {
			this.home = home;
		}

		public RadioButton getCognitive() {
			return cognitive;
		}

		public void setCognitive(RadioButton cognitive) {
			this.cognitive = cognitive;
		}

		public ImageView getRecImage() {
			return recImage;
		}

		public void setRecImage(ImageView recImage) {
			this.recImage = recImage;
		}

		public Label getD1Status() {
			return D1Status;
		}

		public void setD1Status(Label d1Status) {
			D1Status = d1Status;
		}

		public Label getD2Status() {
			return D2Status;
		}

		public void setD2Status(Label d2Status) {
			D2Status = d2Status;
		}

		public Label getD3Status() {
			return D3Status;
		}

		public void setD3Status(Label d3Status) {
			D3Status = d3Status;
		}

		public ImageView getDeviceOneImg() {
			return deviceOneImg;
		}

		public void setDeviceOneImg(ImageView deviceOneImg) {
			this.deviceOneImg = deviceOneImg;
		}

		public Image getLightOn() {
			return lightOn;
		}

		public void setLightOn(Image lightOn) {
			this.lightOn = lightOn;
		}

		public Image getLightOff() {
			return lightOff;
		}

		public void setLightOff(Image lightOff) {
			this.lightOff = lightOff;
		}

		public ImageView getDeviceTwoImg() {
			return deviceTwoImg;
		}

		public void setDeviceTwoImg(ImageView deviceTwoImg) {
			this.deviceTwoImg = deviceTwoImg;
		}

		public ImageView getDeviceThreeImg() {
			return deviceThreeImg;
		}

		public void setDeviceThreeImg(ImageView deviceThreeImg) {
			this.deviceThreeImg = deviceThreeImg;
		}

		public Label getRecStatus() {
			return recStatus;
		}

		public void setRecStatus(Label recStatus) {
			this.recStatus = recStatus;
		}

		public Image getRecOn() {
			return recOn;
		}

		public void setRecOn(Image recOn) {
			this.recOn = recOn;
		}

		public Image getRecOff() {
			return recOff;
		}

		public void setRecOff(Image recOff) {
			this.recOff = recOff;
		}
		
		
		public Label getDeviceStatus(int device) {
			switch(device) {
				case 7:
					return this.D1Status;
					
				case 8:
					return this.D2Status;
					
				case 9:
					return this.D3Status;
					
				default:
					return null;
			}
		}
		
		public ImageView getDeviceImage(int device) {
			switch(device) {
				case 7:
					return this.deviceOneImg;
					
				case 8:
					return this.deviceTwoImg;
					
				case 9:
					return this.deviceThreeImg;
					
				default:
					return null;
			}
		}
		
		public Slider getDeviceSlider(int device) {
			switch(device) {
				case 7:
					return this.SliderD1;
				case 8:
					return this.SliderD2;
				case 9:
					return this.SliderD3;
				default:
					return null;
			}
		}
		
		



	
	

	

	

	
	



	

	
	
	

}
