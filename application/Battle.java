package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Battle extends Application{

	private Stage stage;
	private Scene scene;

	@FXML
	private ImageView mapImage1;

	@FXML
	private Label Commands1;

	@FXML
	private Label Map1;

	@FXML
	private Label MapName1;

	@FXML
	private Label CharacterInfo1;

	@FXML
	private Label Stats1;

	@FXML
	private AnchorPane battleScreen;


	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		this.stage.setTitle("Seven Trials");

	}

	@FXML
	private void battleScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/BattleView.fxml"));
		loader.setController(this);

		battleScreen = loader.load();
		scene = new Scene(battleScreen);
		stage.setScene(scene);
		stage.show();
	}

}
