package ui.common.helper;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StageHelper {
    public static void setIcon(Stage stage,Class parent)
    {
    	String imgPath = "/ui/common/images/caparch.png"; 
        Image image = new Image(parent.getResourceAsStream(imgPath), 
          124.0, 124.0, true, true); 
        
    	stage.getIcons().add(image);
    	

    }
}
