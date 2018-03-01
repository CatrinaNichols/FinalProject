package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Map extends Application{

		private Stage stage;
		private Scene scene;
		
	   @FXML
	    private StackPane GameLayout;

	    @FXML
	    private ImageView mapImage1;

	    @FXML
	    private GridPane mapLayout1;

	    @FXML
	    private Label Commands1;

	    @FXML
	    private Label Map1;

	    @FXML
	    private Label MapName1;

	    @FXML
	    private static ImageView Character;
	    
	    @FXML
	    private Label CharacterInfo1;

	    @FXML
	    private Label Stats1;

	@FXML
	private void mapMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MapView.fxml"));
		loader.setController(this);
		
		GameLayout = loader.load();
		scene = new Scene(GameLayout);
		stage.setScene(scene);
		stage.show();
	}

//	 private static void moveWareHouse(Stage theStage, Group wHK) {
//
//	        theStage.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
//	        e.consume();
//
//	        switch (e.getCharacter()) {
//
//	        case W:
//	            Character.setLayoutY(Character.getLayoutY() - KEYBOARD_MOVEMENT_DELTA);
//	            break;
//	        case D:
//	            Character.setLayoutX(Character.getLayoutX() + KEYBOARD_MOVEMENT_DELTA);
//	            break;
//	        case A:
//	            Character.setLayoutY(Character.getLayoutY() + KEYBOARD_MOVEMENT_DELTA);
//	            break;
//	        case S:
//	            Character.setLayoutX(Character.getLayoutX() - KEYBOARD_MOVEMENT_DELTA);
//	            break;
//	        }
//	    });
//	}
	 
	@FXML
	public void exitApp(ActionEvent event) throws IOException{
		Platform.exit();
	}
	    
	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		StackPane mapView =  (StackPane) FXMLLoader.load(getClass().getResource("view/MenuView.fxml"));
		
		Scene map = new Scene(mapView, scene.getWidth(), scene.getHeight());
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(map);
		window.show();
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		this.stage.setTitle("Seven Trials");
		mapMenu();
	}
}
