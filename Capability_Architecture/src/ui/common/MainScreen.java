package ui.common;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ribbonbardemo.Driver;
import ui.common.helper.StageHelper;
import ui.layouts.mainPane.MainPane;
import ui.layouts.ribbonBar.RibbonBar;

public class MainScreen {
    private Scene scene; 
    public static BorderPane layout; 
    Stage stage;
    
    public MainScreen(Stage stage)
    {
    	this.stage = stage;
    }
    
    
	public void showMainStage()
    {
    	StageHelper.setIcon(stage,this.getClass());
    	stage.initStyle(StageStyle.DECORATED);
        //Initalize layout 
        layout = new BorderPane(); 
        layout.setId("app"); 
         
        //Set BorderPane Regions 
        RibbonBar r = new RibbonBar(); 
        layout.setTop(r.get()); 
         
        
        MainPane mainPane = new MainPane();
        layout.setCenter(mainPane.get());
        
        
        //Set Scene properties. 
        setSceneProperties(); 
         
        //Set a few properties of our Application Window 
        stage.setScene(scene); 
        stage.setTitle("Ribbon Menu Demo"); 
        stage.setX(Driver.getNextXAxis());
        stage.setY(Driver.getNextYAxis());
       
        stage.show(); 
    } 
	
    /**
     * setSceneProperties. This method sets the app to almost full size. It also 
     * is where CSS style sheet is attached. 
     */ 
    private void setSceneProperties() 
    { 
        //The percentage values are used as multipliers for screen width/height. 
        double percentageWidth = 0.98; 
        double percentageHeight = 0.90; 
         
        //Calculate the width / height of screen. 
        Rectangle2D screenSize = Screen.getPrimary().getBounds(); 
        percentageWidth *= screenSize.getWidth(); 
        percentageHeight *= screenSize.getHeight(); 
                    
        //Create a scene object. Pass in the layout and set 
        //the dimensions to 98% of screen width & 90% screen height. 
        this.scene = new Scene(layout, percentageWidth, percentageHeight); 
        
        //Add CSS Style Sheet (located in same package as this class). 
        //String css = this.getClass().getResource("App.css").toExternalForm(); 
         
        //Add CSS for Tabs. 
        String tabsURL = "/ui/layouts/ribbonBar/tabs/tabs.css"; 
        //String tabsCSS = this.getClass().getResource(tabsURL).toExternalForm(); 
         
        //scene.getStylesheets().addAll(css, tabsCSS); 
 
    } 
	
	
}
