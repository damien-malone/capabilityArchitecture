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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneCreator {
	 
	 /**
	  * builds pane, sets border and adds mouse events
	  * 
	  * @return
	  */
	 public Pane buildLevel1Pane()
	 {
		 FlowPane pane = new FlowPane(10, 10);
		 pane.setBorder(new Border(new BorderStroke(Color.BLACK, 
				 BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT))); 

		 pane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		 pane.getChildren().add(new Label("Untitled Capability"));

		 pane.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
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


					 contextMenu.show(pane, mouseEvent.getScreenX(), mouseEvent.getScreenY());

				 }  

			 }
		 });

		 return pane;
	 }
	
	 public Pane buildPropertiesEditor()
	 {
		 Pane flowPane = new FlowPane();
		 flowPane.setMaxWidth(150);
		 
		 return flowPane;
	 }
	
	
}
