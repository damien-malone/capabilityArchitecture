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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import logic.capability.BusinessCapability;
import ui.common.MainScreen;
import ui.layout.applicationPanes.PropertyPane;

public class Organisation extends BusinessCapability{

	
	
	public Organisation() {
		//super(15);
		capabilityName = new Label("Untitled Organisation");
		
    	setBorder(new Border(new BorderStroke(Color.BLACK, 
   			 BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT))); 
    	setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    	
    	HBox canvas = new HBox(10);
    	canvas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    	canvas.setMinSize(100, 100);
    	getChildren().add(capabilityName);
    	
    	getChildren().add(canvas);
    	
    	canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    		  public void handle(MouseEvent mouseEvent) {
    			  if (mouseEvent.isSecondaryButtonDown()) {
    				  System.out.println("right mouse click detected! " + mouseEvent.getSource());
    				  
    				  final ContextMenu contextMenu = new ContextMenu();
    				  MenuItem newCapability = new MenuItem("New Capability");
    				  MenuItem changeName = new MenuItem("Change Name");

    				  contextMenu.getItems().addAll(newCapability, changeName);
    				  
    				  newCapability.setOnAction(new EventHandler<ActionEvent>() {
    				      @Override
    				      public void handle(ActionEvent event) {
    				    	  addLevel1((HBox)mouseEvent.getSource());
    				      }
    				  });
    				  
    				  contextMenu.setAutoHide(true);			
    				  contextMenu.show(canvas, mouseEvent.getScreenX(), mouseEvent.getScreenY());

    			  }  
    			  
    		  }
    		});
	}
	
	 public void addLevel1(HBox hbox)
	 {
		 Level1BusinessCapability capability = new Level1BusinessCapability();
		 hbox.getChildren().add(capability);
		 
		 PropertyPane properties = (PropertyPane)MainScreen.layout.getRight();
		 properties.setActivePanel(capability);
	 }

}
