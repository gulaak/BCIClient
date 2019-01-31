package packages;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import java.io.IOException;
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

public class MainController implements Initializable {

	
	
	 private Image lightOn;
	
	 private Image lightOff;
	 
	 private Image recOff;
	 
	 private Image recOn;
	 
	
	
	 @FXML
	 private TabPane MainTabs;

	 @FXML
	 private ChoiceBox<String> choiceBox;

	 @FXML
	 private Label D1Status;

     @FXML
	 private Label D2Status;

	 @FXML
	 private Label D3Status;
	 
	 @FXML
	 private Label sceneSliderStatus;

	 @FXML
	 private Slider SliderD3;

	 @FXML
	 private Slider SliderD1;

	 @FXML
	 private Slider SliderD2;
	 
	 @FXML
	 private Slider sceneSlider;
	 
	 

	 @FXML
	 private VBox vbox;

	 @FXML
	 private RadioButton home;

	 @FXML
	 private ToggleGroup TG1;
	 
	 @FXML
	 private ToggleGroup TG2;
	 
	 @FXML
	 private RadioButton wheelChair;
	 
	 @FXML
	 private RadioButton on;

	 @FXML
	 private RadioButton off;
	 
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
	 private ToggleButton sceneSave;
	 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		x.setLabel("Time");
		y.setLabel("Power(0-1)");
		x.setScaleX(1.00);
		sceneListView.setItems(FXCollections.observableArrayList("Pull" , "Push" , "Left"));
		sceneListView.getSelectionModel().getSelectedItem();
		TG1.selectToggle(off);
		this.lightOn = new Image("/LightOn.PNG"); //grab image for GUI
		this.lightOff = new Image("/LightOff.PNG"); // grab image for GUI
		this.recOff = new Image("/RecOff.PNG");
		this.recOn = new Image("/RecOn.PNG");
		choiceBox.getItems().add("hello"); // add profile boxes
		this.deviceOneImg.setImage(this.lightOff); // set default image
		this.deviceTwoImg.setImage(this.lightOff);
		this.deviceThreeImg.setImage(this.lightOff);
		this.recImage.setImage(this.recOff);
		this.getHome().setSelected(true);
		
	
		
		
		
//		this.SliderD1.valueProperty().addListener(new ChangeListener<Number>() {	// change listener for device 1
//			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
//				sliderOneChanged();
//			}
//		});
//		this.SliderD2.valueProperty().addListener(new ChangeListener<Number>() {    // change listener for device 2
//			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
//				sliderTwoChanged();
//			}
//		});
//		this.SliderD3.valueProperty().addListener(new ChangeListener<Number>() {    // change listener for device 3
//			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
//				sliderThreeChanged();
//			}
//		});
		
		
		
	
//		XYChart.Series data = new XYChart.Series();
//		data.getData().add(new XYChart.Data("10",100));
//		data.getData().add(new XYChart.Data("100",200));
		

		
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

						
						ZWave.post(7, 255);
						return null;
						
					}
					
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					
					@Override
					protected void succeeded() {
						if(deviceOneImg.getImage()==lightOff) {
							deviceOneImg.setImage(lightOn);
						}
						else
							deviceOneImg.setImage(lightOff);


					
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
		D1Status.setText(Integer.toString(brightness));
		DeviceOne(brightness);
	}
	
	
	
	@FXML
    void sliderTwoChanged(MouseEvent event) {
		
    	int brightness = (int)(Math.floor(SliderD2.getValue()));
		D2Status.setText(Integer.toString(brightness));
		DeviceTwo(brightness);

    }
	
	@FXML
    void sliderThreeChanged(MouseEvent event) {
    	int brightness = (int)(Math.floor(SliderD3.getValue()));
		D3Status.setText(Integer.toString(brightness));
		DeviceThree(brightness);

    }
	
	@FXML
	void sceneSliderChanged(MouseEvent event){
		int sliderValue = (int)(Math.floor(sceneSlider.getValue()));
		sceneSliderStatus.setText(Integer.toString(sliderValue));
		//DeviceOne(sliderValue);
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

						ZWave.post(8, 255);
						return null;
						
					}
					
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					
					@Override
					protected void succeeded() {
						if(deviceTwoImg.getImage()==lightOff) {
							deviceTwoImg.setImage(lightOn);
						}
						else
							deviceTwoImg.setImage(lightOff);

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
						ZWave.post(9, 255);
						return null;
						
					}
					
					@Override
					protected void failed() {
						System.out.println("Failed thread");
					}
					
					@Override
					protected void succeeded() {
						if(deviceThreeImg.getImage()==lightOff) {
							deviceThreeImg.setImage(lightOn);
						}
						else
							deviceThreeImg.setImage(lightOff);

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
	 void recClick(MouseEvent event){
		 
		 
		 
			Service<Void> myservice = new Service<Void>() {

				@Override
				protected Task<Void> createTask() {
					// TODO Auto-generated method stub
					return new Task<Void>() {

						@Override
						protected Void call() throws Exception {
							// TODO Auto-generated method stub
							
							ZWave.toggleRec(3);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
							 if(recImage.getImage() == recOff)
							 {
								 recImage.setImage(recOn);
								
							 }
							 else
								 recImage.setImage(recOff);
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
							ZWave.sliderPost(7, brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
							if(brightness > 0) {
								deviceOneImg.setImage(lightOn);
							}
							else
								deviceOneImg.setImage(lightOff);
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
							
							ZWave.sliderPost(8, brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
							if(brightness > 0) {
								deviceTwoImg.setImage(lightOn);
							}
							else
								deviceTwoImg.setImage(lightOff);
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
							
							ZWave.sliderPost(9, brightness);
							return null;
							
						}
						
						@Override
						protected void failed() {
							System.out.println("Failed thread");
						}
						
						@Override
						protected void succeeded() {
							if(brightness > 0) {
								deviceThreeImg.setImage(lightOn);
							}
							else
								deviceThreeImg.setImage(lightOff);
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
		



	
	

	

	

	
	



	

	
	
	

}
