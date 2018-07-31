package ui.layouts.panes;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
	File file;
	


	public Organisation() {
		canvas.setPrefWrapLength(1250);
		capabilityName = new Label("Untitled Organisation");
		
    	setBorder(new Border(new BorderStroke(Color.BLACK, 
   			 BorderStrokeStyle.SOLID, new CornerRadii(0), BorderWidths.DEFAULT))); 
    	setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(4))));
    	
    	canvas.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, new Insets(4))));
    	canvas.setMinSize(1000, 1000);
    	canvas.setPadding(new Insets(10, 10, 10, 10));
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
	 
		public String toXML()
		{
			StringBuffer sb = new StringBuffer();
			sb.append("<Organisation name='").append(capabilityName.getText())
				.append("'>")
				.append("\n<owner>").append(getOwner()).append("</owner>")
				.append("\n<description>").append(getOwner()).append("</description>");
				
				List<Node> l = canvas.getChildren();
				for (Iterator<Node> iterator = l.iterator(); iterator.hasNext();) {
					Level1BusinessCapability node = (Level1BusinessCapability) iterator.next();
					
					sb.append("\n").append(((Level1BusinessCapability)node).toXML());
				}
				
				
				sb.append("\n</Organisation>");
			
			return sb.toString();
		}
		
		public File getFile() {
			return file;
		}

		public void setFile(File filename) {
			this.file = filename;
		}

}
