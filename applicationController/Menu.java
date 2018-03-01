package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application {

	private Stage stage;
	private Scene scene;

	@FXML
	private StackPane mainLayout;

	@FXML
	private ImageView backgroundImage;
	
	@FXML
	private Button saveGame;
	
	@FXML
	private Button loadGame;
	
	@FXML
	private Button Exit;
	
	@FXML
	private Label Title;
	
	@FXML
	private Button newGame;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		this.stage = stage;
		this.stage.setTitle("Seven Trials");
		mainMenu();
		
	}

	@FXML
	private void mainMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MenuView.fxml"));
		loader.setController(this);

		mainLayout = loader.load();
		scene = new Scene(mainLayout);
		resize();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		StackPane mapView =  FXMLLoader.load(getClass().getResource("view/MapView.fxml"));
		
		Scene map = new Scene(mapView, scene.getWidth(), scene.getHeight());
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(map);
		window.show();
	}

	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}


	@FXML
	void resize() {
		backgroundImage.fitWidthProperty().bind(mainLayout.widthProperty());
		backgroundImage.fitHeightProperty().bind(mainLayout.heightProperty());
	}

}
