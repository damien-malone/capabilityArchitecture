package ribbonbardemo;
 
import java.util.concurrent.TimeUnit;

import javafx.application.Application; 
import javafx.geometry.Rectangle2D; 
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane; 
import javafx.stage.Screen; 
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
         
    	showStartPopup(new Stage());

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
    
    
    
    
    public void showStartPopup(Stage primaryStage) {        

        primaryStage.setTitle("Popup Example");  
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        String imgPath = "/ui/common/images/new.png"; 
        Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
          24.0, 24.0, true, true); 
        ImageView imageView = new ImageView(image);
        
        final Popup popup = new Popup(); popup.setX(300); popup.setY(200);

        popup.getContent().addAll(new Circle(25, 25, 50, Color.AQUAMARINE));



        Button show = new Button("Show");

        show.setOnAction(new EventHandler<ActionEvent>() {

          @Override public void handle(ActionEvent event) {

            popup.show(primaryStage);

          }

        });



        Button hide = new Button("Hide");

        hide.setOnAction(new EventHandler<ActionEvent>() {

          @Override public void handle(ActionEvent event) {

            popup.hide();

          }

        });



        HBox layout = new HBox(10);

        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

        layout.getChildren().addAll(show, hide, imageView);

        primaryStage.setScene(new Scene(layout));

        primaryStage.show();
        popup.show(primaryStage);

      }
    
}