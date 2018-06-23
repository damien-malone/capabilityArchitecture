package ribbonbardemo;
 
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    	
    	showStartPopup(stage);


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
            	stage.hide();
            	showMainStage(new Stage());
            }
        });
        new Thread(sleeper).start();

    	
    	
    	
    }
    
    public void showMainStage(Stage stage)
    {
    	setIcon(stage);
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
    
    
    
    
    public void showStartPopup(Stage primaryStage)
        {
    		setIcon(primaryStage);
        	primaryStage.setTitle("Popup Example");  
            primaryStage.initStyle(StageStyle.UNDECORATED);
            
            String imgPath = "/ui/common/images/caparch.png"; 
            Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
              124.0, 124.0, true, true); 
            ImageView imageView = new ImageView(image);
            

            final Text intro = new Text(25, 175, "Capability Architecture");
            intro.setFill(Color.DARKVIOLET);
            intro.setFont(Font.font(java.awt.Font.SERIF, FontWeight.EXTRA_BOLD, 45));
            final Light.Distant light = new Light.Distant();
            light.setAzimuth(-135.0);
            final Lighting lighting = new Lighting();
            lighting.setLight(light);
            lighting.setSurfaceScale(9.0);
            intro.setEffect(lighting);
            
            
            final Text text1 = new Text(25, 25, "A tool for mapping your organisations capabilities and technologies");
            text1.setFill(Color.CHOCOLATE);
            text1.setFont(Font.font(java.awt.Font.SERIF, 20));
            
            final Text copyrighttext = new Text(25, 225, "Copyright© Damien Malone 2018");
            copyrighttext.setFill(Color.BLACK);
            copyrighttext.setFont(Font.font(java.awt.Font.DIALOG_INPUT, FontWeight.THIN, 15));
            
            
            HBox layout = new HBox(10);
            VBox verticalLayout = new VBox();
            
            layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
            verticalLayout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
            
            verticalLayout.getChildren().addAll(intro,text1,copyrighttext);
            
            layout.getChildren().addAll(imageView,verticalLayout);

            primaryStage.setScene(new Scene(layout));
            primaryStage.getIcons().add(image);
            primaryStage.centerOnScreen();
            primaryStage.show();
            primaryStage.alwaysOnTopProperty();
            
          }
        
    
    public void setIcon(Stage stage)
    {
    	String imgPath = "/ui/common/images/caparch.png"; 
        Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
          124.0, 124.0, true, true); 
        
    	stage.getIcons().add(image);
    	

    }
    
}