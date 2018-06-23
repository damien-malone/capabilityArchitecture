package ribbonbardemo;
 
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
            	mainScreen.showMainStage();
            }
        });
        new Thread(sleeper).start();
    	
    }
            
}