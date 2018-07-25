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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ui.common.MainScreen;

public class Organisation extends VBox{

	public Label name = new Label("Untitled Organisation");
	
	public Organisation() {
		super(15);
    	
    	setBorder(new Border(new BorderStroke(Color.BLACK, 
   			 BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT))); 
    	setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    	
    	HBox canvas = new HBox(10);
    	canvas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    	canvas.setMinSize(100, 100);
    	getChildren().add(name);
    	
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
		 System.out.println("Adding new level 1 capability object");
		 hbox.getChildren().add(new Level1BusinessCapability());
	 }

}
