package ribbonbardemo;
 
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.common.StageHelper;
import ui.common.StartScreen;
import ui.layouts.ribbonBar.RibbonBar; 

 
/**
 * Driver. The Application starts here. 
 */ 
public class Driver extends Application { 
 
    private Scene scene; 
    private BorderPane layout; 
     
    /**
     * start. Build UI and show here. 
     * @param stage  
     */ 
    @Override 
    public void start(Stage stage) { 
    	
    	
    	StartScreen startScreen = new StartScreen(stage);
    	startScreen.showPopup();

    	Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
            	startScreen.hidePopup();
            	showMainStage(new Stage());
            }
        });
        new Thread(sleeper).start();
    	
    }
    
    
    public void showMainStage(Stage stage)
    {
    	StageHelper.setIcon(stage,this.getClass());
    	stage.initStyle(StageStyle.DECORATED);
        //Initalize layout 
        layout = new BorderPane(); 
        layout.setId("app"); 
         
        //Set BorderPane Regions 
        RibbonBar r = new RibbonBar(); 
        layout.setTop(r.get()); 
         
        //Set Scene properties. 
        setSceneProperties(); 
         
        //Set a few properties of our Application Window 
        stage.setScene(scene); 
        stage.setTitle("Ribbon Menu Demo"); 
        stage.show(); 
    } 
     
    /**
     * Application Entry Point. Program starts here. 
     * @param args  
     */ 
    public static void main(String[] args) { 
        launch(); 
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
        String css = this.getClass().getResource("App.css").toExternalForm(); 
         
        //Add CSS for Tabs. 
        String tabsURL = "/ui/layouts/ribbonBar/tabs/tabs.css"; 
        String tabsCSS = this.getClass().getResource(tabsURL).toExternalForm(); 
         
        scene.getStylesheets().addAll(css, tabsCSS); 
 
    } 
    
            
}