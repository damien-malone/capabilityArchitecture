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
import javafx.scene.paint.Color;
import logic.capability.BusinessCapability;
import ui.common.MainScreen;
import ui.layout.applicationPanes.PropertyPane;

public class Level2BusinessCapability extends BusinessCapability {

	
	
	public Level2BusinessCapability() {
		//super(5,5);
		setVgap(5);
		setHgap(5);
		setWidth(50);
		capabilityName = new Label("Untitled Capability");
		setBorder(new Border(new BorderStroke(Color.DARKCYAN, 
				 BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT))); 

		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		getChildren().add(capabilityName);

		addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			 public void handle(MouseEvent mouseEvent) {
				 if (mouseEvent.isSecondaryButtonDown()) {
					 System.out.println("right mouse click detected! " + mouseEvent.getSource());

					 final ContextMenu contextMenu = new ContextMenu();
					 MenuItem newCapability = new MenuItem("New Level 2");
					 MenuItem changeName = new MenuItem("Change Name");

					 contextMenu.getItems().addAll(newCapability, changeName);

					 newCapability.setOnAction(new EventHandler<ActionEvent>() {
						 @Override
						 public void handle(ActionEvent event) {
							 //TODO
							 System.out.println("TO DO, create new level 2 architecture item");
						 }
					 });

					 contextMenu.setAutoHide(true);


					 contextMenu.show(getParent(), mouseEvent.getScreenX(), mouseEvent.getScreenY());

				 }  
				 else
				 {
					 PropertyPane properties = (PropertyPane)MainScreen.layout.getRight();
					 properties.setActivePanel((BusinessCapability)mouseEvent.getSource());
				 }

			 }
		 });
	}
	
	public String toXML()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<Level2BusCap>").append(capabilityName.getText()).append("</Level2BusCap>");
		
		return sb.toString();
	}

}
