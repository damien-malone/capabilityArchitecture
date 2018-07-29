package logic.capability;

import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class BusinessCapability extends FlowPane {
	
	public enum Catagorisation {HYGENE ,COMPETE, DIFFERENTIATOR};
	
	public Label capabilityName = new Label();
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public Catagorisation getCatagory() {
		return Catagory;
	}


	public void setCatagory(Catagorisation catagory) {
		Catagory = catagory;
	}


	public String description = new String();
	public String owner = new String();	
	public Catagorisation Catagory = Catagorisation.HYGENE;
	
	public String getCapabilityName()
	{
		return capabilityName.getText();
	}
	
	
	public void setCapabilityName(String name)
	{
		this.capabilityName.setText(name);
	}


	public BusinessCapability() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(double arg0, double arg1, Node... arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(double arg0, double arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(Node... arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(Orientation arg0, double arg1, double arg2, Node... arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(Orientation arg0, double arg1, double arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(Orientation arg0, Node... arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}


	public BusinessCapability(Orientation arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	

}
