package ui.layouts.mainPane;

import javafx.scene.control.ScrollPane;

public class MainPane {
	
	//todo change these from static to one per stage
	public static ScrollPane basePane;
	public static boolean hasContent = false;
	
	public MainPane() {
		basePane =  new ScrollPane();
	}

	
	public ScrollPane get()
	{
		return basePane;
	}
	
	static public boolean hasContent()
	{
		if(hasContent == false)
		{
			hasContent = true;
			return false;
		}
		else
			return true;
		
	}


}
