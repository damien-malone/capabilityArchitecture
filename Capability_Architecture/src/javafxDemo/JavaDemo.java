package javafxDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavaDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Popup Example");  
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        String imgPath = "/ui/common/images/caparch.png"; 
        Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
          124.0, 124.0, true, true); 
        ImageView imageView = new ImageView(image);
        

        HBox layout = new HBox(10);

        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");

        layout.getChildren().addAll(imageView);

        primaryStage.setScene(new Scene(layout));
        primaryStage.getIcons().add(image);
        primaryStage.show();
        
        
     
      }
    
    
    
}