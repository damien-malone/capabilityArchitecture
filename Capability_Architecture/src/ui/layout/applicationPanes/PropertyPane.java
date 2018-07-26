package ui.layout.applicationPanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.capability.BusinessCapability;
import ui.layouts.panes.Level1BusinessCapability;
import ui.layouts.panes.Organisation;

public class PropertyPane extends FlowPane {

	BusinessCapability capability;
	
	TextField name;
	
	public PropertyPane() {
		super();

		setMaxWidth(200);
		
	}
	
	public PropertyPane(BusinessCapability capability) {
		super();
		this.capability = capability;
		setMaxWidth(200);
		buildScreen();
		setActivePanel(capability);
		
	}
	
	
	public void setActivePanel(BusinessCapability capability)
	{
		this.capability = capability;
		name.setText(capability.getCapabilityName());
	}
	
	
	public void buildScreen()
	{
		VBox vb = new VBox();
		
		Label label1 = new Label("Name:");
		name = new TextField ();
	
		
		name.setOnKeyTyped(new EventHandler<KeyEvent>() { 
			 
			   @Override 
			   public void handle(KeyEvent event) { 
			 
			    capability.capabilityName.setText(name.getText());
			 
			   } 
			 
			  }); 
		
		HBox hb = new HBox();
		hb.getChildren().addAll(label1, name);
		hb.setSpacing(10);
		
		Label label2 = new Label("Stuff:");
		TextField textField2 = new TextField ();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(label2, textField2);
		hb2.setSpacing(10);
		
		vb.getChildren().addAll(hb,hb2);
		
		getChildren().add(vb);
	}

}
