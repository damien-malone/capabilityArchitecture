package ui.common;

import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ui.common.helper.StageHelper;

public class StartScreen {
	
	Stage stage;
	
	public StartScreen() {
		stage = new Stage();
	}
	
	public StartScreen(Stage stage) {
		this.stage = stage;
	}
	
	
    public void showPopup()
    {
	    StageHelper.setIcon(stage,this.getClass());
	    stage.setTitle("Popup Example");  
	    stage.initStyle(StageStyle.UNDECORATED);
        
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

        stage.setScene(new Scene(layout));
        stage.getIcons().add(image);
        stage.centerOnScreen();
        stage.show();
        
      }
    
    public void hidePopup()
    {
    	stage.hide();
    }
    
}
