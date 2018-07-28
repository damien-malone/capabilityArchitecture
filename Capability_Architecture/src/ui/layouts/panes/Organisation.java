package ui.layouts.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.capability.BusinessCapability;
import ui.common.MainScreen;
import ui.layout.applicationPanes.PropertyPane;

public class Organisation extends BusinessCapability{

	FlowPane canvas = new FlowPane(5,5);
	
	public Organisation() {
		canvas.setPrefWrapLength(1250);
		capabilityName = new Label("Untitled Organisation");
		
    	setBorder(new Border(new BorderStroke(Color.BLACK, 
   			 BorderStrokeStyle.SOLID, new CornerRadii(0), BorderWidths.DEFAULT))); 
    	setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(4))));
    	
    	canvas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(4))));
    	canvas.setMinSize(1000, 1000);
    	getChildren().add(capabilityName);
    	
    	getChildren().add(canvas);
    	
    	addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    		  public void handle(MouseEvent mouseEvent) {
    			  if (mouseEvent.isSecondaryButtonDown()) {
    				  System.out.println("right mouse click detected! " + mouseEvent.getSource());
    				  
    				  final ContextMenu contextMenu = new ContextMenu();
    				  MenuItem newCapability = new MenuItem("New Capability");
    				 
    				  contextMenu.getItems().addAll(newCapability);
    				  
    				  newCapability.setOnAction(new EventHandler<ActionEvent>() {
    				      @Override
    				      public void handle(ActionEvent event) {
    				    	  addLevel1();
    				      }
    				  });
    				  
    				  contextMenu.setAutoHide(true);			
    				  contextMenu.show(canvas, mouseEvent.getScreenX(), mouseEvent.getScreenY());

    			  }  
    			  
    		  }
    		});
	}
	
	 public void addLevel1()
	 {
		 Level1BusinessCapability capability = new Level1BusinessCapability();
		 canvas.getChildren().add(capability);
		 
		 PropertyPane properties = (PropertyPane)MainScreen.layout.getRight();
		 properties.setActivePanel(capability);
	 }

}
