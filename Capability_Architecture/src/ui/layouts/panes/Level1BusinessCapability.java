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

public class Level1BusinessCapability extends FlowPane {

	Label name = new Label("Untitled Capability");
	
	public Level1BusinessCapability() {
		super();
		setBorder(new Border(new BorderStroke(Color.BLACK, 
				 BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT))); 

		setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		getChildren().add(name);

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

			 }
		 });
	}
	
	public String toXML()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<Level1BusCap>").append(name.getText()).append("</Level1BusCap>");
		
		return sb.toString();
	}

}
