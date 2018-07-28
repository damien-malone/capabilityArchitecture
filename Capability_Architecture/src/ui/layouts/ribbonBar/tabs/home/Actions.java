package ui.layouts.ribbonBar.tabs.home;
 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos; 
import javafx.scene.control.Button; 
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip; 
import javafx.scene.image.Image; 
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority; 
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import ui.common.MainScreen;
import ui.layout.applicationPanes.MainPane;
import ui.layout.applicationPanes.PropertyPane;
import ui.layouts.panes.Level1BusinessCapability;
import ui.layouts.panes.Organisation;
import ui.layouts.panes.PaneCreator; 
 
/**
 * Tables. This class represents the Actions Ribbon Bar Component. 
 */ 
public class Actions { 
 
 private Button btnNew, btnOpen, btnSaveAs, btnPrint, btnPDF, btnSave; 
 private VBox root; 
 PaneCreator paneCreator = new PaneCreator();
 
 /**
  * Default Constructor. 
  */ 
 public Actions() { 
 
  this.root = new VBox(); 
  build(); 
 } 
 
 /**
  * get. Returns the VBox to be placed on the Ribbon Bar. 
  *  
  * @return 
  */ 
 public VBox get() { 
 
  return this.root; 
 } 
 
 /**
  * build. Helper method to build the layout. 
  */ 
 private void build() { 
 
  // GridPane used to layout the components. 
  GridPane layout = new GridPane(); 
 
  // Grid Lines to help layout buttons. 
  layout.setGridLinesVisible(false); 
 
  // Set horizontal spacing. 
  layout.setHgap(5); 
 
  // Build UI Controls 
  this.buildNewButton(); 
  this.buildOpenButton(); 
  this.buildSaveAsButton(); 
  this.buildPDFButton(); 
  this.buildPrintButton(); 
  this.buildSaveButton(); 
 
  // Add All Componets to the GridPane. 
  layout.add(this.btnNew, 0, 0); 
  layout.add(this.btnOpen, 1, 0); 
  layout.add(this.btnSave, 2, 0); 
  layout.add(this.btnSaveAs, 3, 0); 
  layout.add(this.btnPrint, 4, 0); 
  layout.add(this.btnPDF, 5, 0); 
 
  // Build the Toolbar Container Label. 
  Label label = new Label("Actions"); 
  label.getStyleClass().add("ribbonLabel"); 
  label.setTooltip(new Tooltip("Order related stuff...")); 
 
  // TODO: find a better way to center a label. 
  VBox vbox = new VBox(); 
  vbox.getChildren().add(label); 
  VBox.setVgrow(label, Priority.ALWAYS); 
  vbox.setAlignment(Pos.BOTTOM_CENTER); 
  vbox.setStyle("-fx-padding: 5 0 0 0"); 
  layout.add(vbox, 0, 2, 6, 1); 
 
  // Center alignment in the VBox, add GridPane, set VBox CSS Selector. 
  this.root.setAlignment(Pos.CENTER); 
  this.root.getChildren().add(layout); 
  this.root.getStyleClass().add("toolbarContainer"); 
 } 
 
 /**
  * buildNewButton. Helper method to build a Button. 
  */ 
 private void buildNewButton() { 
 
  // Create button with text. 
  this.btnNew = new Button("New"); 
 
  // Set the Image above the text. 
  this.btnNew.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/new.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnNew.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnNew.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnNew.setTooltip(new Tooltip("New Order")); 
 
  // Set simple Click Event Handler. 
  this.btnNew.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("New Order Button clicked."); 
    if(MainPane.hasContent()==true)
    {
    	MainScreen mainScreen = new MainScreen(new Stage());
    	mainScreen.showMainStage();
    }
    else
    {
    	Organisation org = new Organisation();
    	
    	MainScreen.layout.setRight(new PropertyPane(org));
    	MainPane.basePane.setContent(org);
    }
 
   } 
 
  }); 
 } 
 
 /**
  * buildOpenButton. Helper method to build a Button. 
  */ 
 private void buildOpenButton() { 
 
  // Create button with text. 
  this.btnOpen = new Button("Open"); 
 
  // Set the Image above the text. 
  this.btnOpen.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/open.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnOpen.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnOpen.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnOpen.setTooltip(new Tooltip("Open Order")); 
 
  // Set simple Click Event Handler. 
  this.btnOpen.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("Open Exist Order Button clicked."); 
 
   } 
 
  }); 
 } 
 
 /**
  * buildSaveAsButton. Helper method to build a Button. 
  */ 
 private void buildSaveAsButton() { 
 
  // Create button with text. 
  this.btnSaveAs = new Button("Save As"); 
 
  // Set the Image above the text. 
  this.btnSaveAs.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/email.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnSaveAs.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnSaveAs.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnSaveAs.setTooltip(new Tooltip("Email Order")); 
 
  // Set simple Click Event Handler. 
  this.btnSaveAs.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("Email Order Button clicked."); 
 
   } 
 
  }); 
 } 
 
 /**
  * buildPrintButton. Helper method to build a Button. 
  */ 
 private void buildPrintButton() { 
 
  // Create button with text. 
  this.btnPrint = new Button("Print"); 
 
  // Set the Image above the text. 
  this.btnPrint.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/print.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnPrint.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnPrint.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnPrint.setTooltip(new Tooltip("Print Order")); 
 
  // Set simple Click Event Handler. 
  this.btnPrint.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("Print Invoice Button clicked."); 
 
   } 
 
  }); 
 } 
 
 /**
  * buildSaveButton. Helper method to build a Button. 
  */ 
 private void buildSaveButton() { 
 
  // Create button with text. 
  this.btnSave = new Button("Save"); 
 
  // Set the Image above the text. 
  this.btnSave.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/delete.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnSave.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnSave.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnSave.setTooltip(new Tooltip("Delete Order")); 
 
  // Set simple Click Event Handler. 
  this.btnSave.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("Delete Order Button clicked."); 
 
   } 
 
  }); 
 } 
 
 /**
  * buildPDFButton. Helper method to build a Button. 
  */ 
 private void buildPDFButton() { 
 
  // Create button with text. 
  this.btnPDF = new Button("Export"); 
 
  // Set the Image above the text. 
  this.btnPDF.setContentDisplay(ContentDisplay.TOP); 
 
  // Add image. 
  String imgPath = "/ui/common/images/pdf.png"; 
  Image image = new Image(this.getClass().getResourceAsStream(imgPath), 
    24.0, 24.0, true, true); 
  ImageView imageView = new ImageView(image); 
  this.btnPDF.setGraphic(imageView); 
 
  // Set CSS Styles. 
  this.btnPDF.getStyleClass().add("ribbonToggleButton"); 
 
  // Set Tooltip 
  this.btnPDF.setTooltip(new Tooltip("Export Order to PDF")); 
 
  // Set simple Click Event Handler. 
  this.btnPDF.setOnAction(new EventHandler<ActionEvent>() { 
 
   @Override 
   public void handle(ActionEvent event) { 
 
    System.out.println("PDF Export Button clicked."); 
 
   } 
 
  }); 
 } 
 

 


}