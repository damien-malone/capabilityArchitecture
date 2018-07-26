package logic.capability;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class BusinessCapability extends FlowPane {
	public Label capabilityName = new Label();
	
	public enum Catagorisation {HYGENE ,COMPETE, DIFFERENTIATOR};
	
	public Catagorisation Catagory = Catagorisation.HYGENE;
	
	public String getCapabilityName()
	{
		return capabilityName.getText();
	}
	
	
	public void setCapabilityName(String name)
	{
		this.capabilityName.setText(name);
	}



}
