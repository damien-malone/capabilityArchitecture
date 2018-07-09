package ribbonbardemo;
 
import java.util.List;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import ui.common.MainScreen;
import ui.common.StartScreen; 

 
/**
 * Driver. The Application starts here. 
 */ 
public class Driver extends Application { 
    
	static int xAxis = -30;
	static int yAxis = -30;
	
    /**
     * Application Entry Point. Program starts here. 
     * @param args  
     */ 
    public static void main(String[] args) { 
        launch(); 
    } 
	
    /**
     * start. Build UI and show here. 
     * @param stage  
     */ 
    @Override 
    public void start(Stage stage) {     	
    	StartScreen startScreen = new StartScreen(stage);
    	MainScreen mainScreen = new MainScreen(new Stage());
    	
    	startScreen.showPopup();

    	Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                	//TODO change time
                    Thread.sleep(000);//should be 5000
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
            	startScreen.hidePopup();
            	mainScreen.showMainStage();
            }
        });
        new Thread(sleeper).start();
    	
    }
    
    
    public static int getNextXAxis() {
    	return xAxis+=30;
    }
    
    public static int getNextYAxis() {
    	return yAxis+=30;
    }
            
}