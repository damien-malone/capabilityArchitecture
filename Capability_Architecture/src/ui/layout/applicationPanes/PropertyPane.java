package ui.layout.applicationPanes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.capability.BusinessCapability;
import logic.capability.BusinessCapability.Catagorisation;
import ui.layouts.panes.Level1BusinessCapability;
import ui.layouts.panes.Organisation;

public class PropertyPane extends FlowPane {

	BusinessCapability capability;
	
	TextField name;
	TextField owner;
	TextArea ta = new TextArea();
	
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
		ta.setText(capability.getDescription());
		owner.setText(capability.getOwner());
		
	}
	
	
	public void buildScreen()
	{
		VBox vb = new VBox();
		
		Label nameLabel = new Label("Name:");
		Label catagoryLabel = new Label("Catagory:");
		Label ownerLabel = new Label("Owner:");
		Label descLabel = new Label("Desc.:");
		
		
		name = new TextField ();
		name.setOnKeyTyped(new EventHandler<KeyEvent>() { 
			 
			   @Override 
			   public void handle(KeyEvent event) { 
			 
			    capability.capabilityName.setText(name.getText());
			 
			   } 
			 
			  }); 
		GridPane gp = new GridPane();
		gp.setHgap(10); //horizontal gap in pixels => that's what you are asking for
		gp.setVgap(10); //vertical gap in pixels
		gp.setPadding(new Insets(10, 10, 10, 10)); //margins around the whole grid
		
		
		gp.add(nameLabel, 1,1);
		gp.add(name, 2, 1);
		
		gp.add(catagoryLabel, 1,2);
		
		VBox root = new VBox();
		ToggleGroup group = new ToggleGroup();
	    RadioButton button1 = new RadioButton(Catagorisation.HYGENE.toString());
	    button1.setToggleGroup(group);
	    button1.setSelected(true);
	    
	    RadioButton button2 = new RadioButton(Catagorisation.COMPETE.toString());
	    button2.setToggleGroup(group);
	   
	    RadioButton button3 = new RadioButton(Catagorisation.DIFFERENTIATOR.toString());
	    button3.setToggleGroup(group);
	    root.getChildren().add(button1);
	    root.getChildren().add(button2);
	    root.getChildren().add(button3);
	    gp.add(root, 2, 2);
		
	    owner = new TextField();
	    owner.setOnKeyTyped(new EventHandler<KeyEvent>() { 
			 
			   @Override 
			   public void handle(KeyEvent event) { 
			 
			    capability.setOwner(owner.getText());
			 
			   } 
			 
			  }); 
	    
		gp.add(ownerLabel, 1,3);
		gp.add(owner, 2, 3);
		
		gp.add(descLabel, 1,4);
		
		ta.setWrapText(true);
		ta.setPrefHeight(50);
		ta.setPrefWidth(100);
		
		ta.setOnKeyTyped(new EventHandler<KeyEvent>() { 
			 
			   @Override 
			   public void handle(KeyEvent event) { 
			 
			    capability.setDescription(ta.getText());
			 
			   } 
			 
			  }); 
		
		gp.add(ta, 2, 4);
		
		
		getChildren().add(gp);
	}

}
