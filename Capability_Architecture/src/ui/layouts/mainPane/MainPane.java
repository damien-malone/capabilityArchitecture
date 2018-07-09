package ui.layouts.mainPane;

import javafx.scene.control.ScrollPane;

public class MainPane {
	
	public static ScrollPane basePane;
	
	public MainPane() {
		basePane =  new ScrollPane();
	}

	
	public ScrollPane get()
	{
		return basePane;
	}
	
	static public boolean hasContent()
	{
		if(basePane.getChildrenUnmodifiable().size()>0)
		{
			return true;
		}
		return false;
		
	}
}
