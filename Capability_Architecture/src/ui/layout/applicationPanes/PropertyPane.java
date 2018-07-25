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
import ui.layouts.panes.Level1BusinessCapability;
import ui.layouts.panes.Organisation;

public class PropertyPane extends FlowPane {

	Level1BusinessCapability capability;
	Organisation org;
	
	TextField name;
	
	public PropertyPane() {
		super();

		setMaxWidth(150);
		
	}
	
	public PropertyPane(Level1BusinessCapability capability) {
		super();

		setMaxWidth(150);
		
	}
	
	public PropertyPane(Organisation org) {
		super();
		this.org = org;
		setMaxWidth(150);
		buildScreen();
		
	}
	
	
	public void setActivePanel(Level1BusinessCapability capability)
	{
		this.capability = capability;
	}
	
	
	public void buildScreen()
	{
		VBox vb = new VBox();
		
		Label label1 = new Label("Name:");
		name = new TextField ();
	
		
		name.setOnKeyTyped(new EventHandler<KeyEvent>() { 
			 
			   @Override 
			   public void handle(KeyEvent event) { 
			 
			    System.out.println("text changed"); 
			    org.name.setText(name.getText());
			 
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
