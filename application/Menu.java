package application;

import java.io.IOException;

import controllers.Mechanics;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application {

	private Stage stage;
	
	private static Scene scene;

	@FXML
	private TextField characterName;
	
	@FXML
	private StackPane mainLayout;

	@FXML
	private ImageView backgroundImage;

	@FXML
	private Button loadGame;

	@FXML
	private Button Exit;

	@FXML
	private Label Title;

	@FXML
	private Button newGame;

    @FXML
    private Button archerButton;

    @FXML
    private Button warriorButton;

    @FXML
    private Button wizardButton;
    
    @FXML
    private TextField playerName;


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
		mainLayout = new StackPane();
		mainLayout = loader.load();
		scene = new Scene(mainLayout);
		resize();
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	public void warriorClass(ActionEvent event) throws IOException{
		String name = playerName.getText();
		Mechanics.newGame(name, "warrior");		
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MapView.fxml"));

		StackPane mapView = loader.load();
		Scene map = new Scene(mapView, scene.getWidth(),scene.getHeight());
		((Map) loader.getController()).setScene(map);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(map);
		window.show();
	}
	
	@FXML
	public void wizardClass(ActionEvent event) throws IOException{
		String name = playerName.getText();
		Mechanics.newGame(name, "wizard");		

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MapView.fxml"));

		StackPane mapView = loader.load();
		Scene map = new Scene(mapView, scene.getWidth(),scene.getHeight());
		((Map) loader.getController()).setScene(map);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(map);
		window.show();
	}
	
	@FXML
	public void archerClass(ActionEvent event) throws IOException{
		String name = playerName.getText();
		Mechanics.newGame(name, "ranger");		

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MapView.fxml"));

		StackPane mapView = loader.load();
		Scene map = new Scene(mapView, scene.getWidth(),scene.getHeight());
		((Map) loader.getController()).setScene(map);

		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(map);
		window.show();
	}
	

	@FXML
	public void newGameButton(ActionEvent event) throws IOException {
		archerButton.setText("Ranger");
		wizardButton.setText("Wizard");
		warriorButton.setText("Warrior");
		newGame.setVisible(false);
		loadGame.setVisible(false);
		Exit.setVisible(false);
		
		playerName.setPromptText("Please enter your name");
		playerName.setVisible(true);
		
		archerButton.setLayoutX(119);
		archerButton.setLayoutY(249);
		archerButton.setAlignment(Pos.CENTER_LEFT);
		archerButton.setVisible(true);
		
		warriorButton.setLayoutX(319);
		warriorButton.setLayoutY(249);
		warriorButton.setAlignment(Pos.CENTER);
		warriorButton.setVisible(true);
		
		wizardButton.setLayoutX(519);
		wizardButton.setLayoutY(249);
		wizardButton.setAlignment(Pos.CENTER_RIGHT);
		wizardButton.setVisible(true);
	}
	
	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MapView.fxml"));

		StackPane mapView = loader.load();
		Scene map = new Scene(mapView, scene.getWidth(),scene.getHeight());
		((Map) loader.getController()).setScene(map);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(map);
		window.show();
	}
	
	@FXML
	public void loadGame(ActionEvent event) {
		Mechanics.load();
	}

	@FXML
	public void exit(ActionEvent event) {
		Platform.exit();
	}


	@FXML
	void resize() {
//		backgroundImage.fitWidthProperty().bind(mainLayout.widthProperty());
//		backgroundImage.fitHeightProperty().bind(mainLayout.heightProperty());
//		saveGame.prefWidthProperty().bind(mainLayout.widthProperty().subtract(10));
//		loadGame.prefWidthProperty().bind(mainLayout.widthProperty().subtract(10));
//		Exit.prefWidthProperty().bind(mainLayout.widthProperty().subtract(10));
	}

}
