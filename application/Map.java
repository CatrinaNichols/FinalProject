package application;

import java.io.IOException;

import controllers.Mechanics;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Map implements EventHandler<KeyEvent>{

	private int positionX = 0;
	private int positionY = 0;


	@FXML
	private StackPane gameLayout;

	@FXML
	private ImageView mapImage;

	@FXML
	private GridPane mapLayout;

	@FXML
	private Label commands;

	@FXML
	private Label map;

	@FXML
	private Label mapName;

	@FXML
	private Label characterInfo;

	@FXML
	private Label stats;

	@FXML
	private Button exit;

	@FXML
	private Button desktopExit;

	@FXML
	private Button up;

	@FXML
	private Button down;

	@FXML
	private Button left;

	@FXML
	private Button right;

	@FXML
	private Button save;

	@FXML
	private Button load;

	@FXML
	private Label hp;

	@FXML
	private Label mana;

	@FXML
	private AnchorPane anchor;

	@FXML
	private Label characterClass;

	@FXML
	private Label strength;

	@FXML
	private Label dexterity;

	@FXML
	private Label armorReduction;

	@FXML
	private Label weapon;

	@FXML
	private static ImageView character;

	
	
	@FXML
	public void upButtonMovement(ActionEvent event) {
		int up = -1;
		if(positionY > 0) {
			mapLayout.getChildren().remove(character);
			positionY = positionY+up;
			mapLayout.add(character, positionX, positionY);

			event.consume();						
		}
	}

	@FXML
	public void downButtonMovement(ActionEvent event) {
		int down = 1;
		if(positionY < mapLayout.getRowConstraints().size()) {
			mapLayout.getChildren().remove(character);
			positionY = positionY+down;
			mapLayout.add(character, positionX, positionY);
			event.consume();			
		}
	}

	@FXML
	public void leftButtonMovement(ActionEvent event) {
		if(positionX > 0) {
			int left = -1;
			mapLayout.getChildren().remove(character);
			positionX = positionX+left;
			mapLayout.add(character, positionX, positionY);
			event.consume();												
		}
	}

	@FXML
	public void rightButtonMovement(ActionEvent event) {
		int right = 1;
		if(positionX < mapLayout.getColumnConstraints().size()) {
			mapLayout.getChildren().remove(character);
			positionX = positionX+right;
			mapLayout.add(character, positionX, positionY);
			event.consume();			
		}
	}

	
	@FXML
	public void exitApp(ActionEvent event) throws IOException{
		Platform.exit();
	}

	Menu control = new Menu();

	@FXML
	public void saveGame(ActionEvent event) {
		Mechanics.save();
	}
	
	@FXML
	public void loadGame(ActionEvent event) {
		Mechanics.load();
	}
	
	@FXML
	public void attack(ActionEvent event) {
//		String playerMove = "attack";
//		control(playerMove);
	}
	
	@FXML
	public void specialAttack(ActionEvent event) {
//		String playerMove = "Special Attack";
	}
	
	@FXML
	public void item(ActionEvent event) {
//		HBox itemHolder = new HBox();
	}
	
	
	
	
	@FXML
	public void changeScreenButtonPushed(ActionEvent event) throws IOException {		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Menu.class.getResource("view/MenuView.fxml"));
		loader.setController(control);
		StackPane mapView = loader.load();
		gameLayout.getChildren().clear();
		gameLayout.getChildren().add(mapView);
	}



	@FXML
	void initialize() {
		assert gameLayout != null : "fx:id=\"gameLayout\" was not injected: check your FXML file 'MapView.fxml'.";
		assert anchor != null : "fx:id=\"anchor\" was not injected: check your FXML file 'MapView.fxml'.";
		assert mapImage != null : "fx:id=\"mapImage\" was not injected: check your FXML file 'MapView.fxml'.";
		assert mapLayout != null : "fx:id=\"mapLayout\" was not injected: check your FXML file 'MapView.fxml'.";
		assert commands != null : "fx:id=\"commands\" was not injected: check your FXML file 'MapView.fxml'.";
		assert map != null : "fx:id=\"map\" was not injected: check your FXML file 'MapView.fxml'.";
		assert mapName != null : "fx:id=\"mapName\" was not injected: check your FXML file 'MapView.fxml'.";
		assert characterInfo != null : "fx:id=\"characterInfo\" was not injected: check your FXML file 'MapView.fxml'.";
		assert stats != null : "fx:id=\"stats\" was not injected: check your FXML file 'MapView.fxml'.";
		assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'MapView.fxml'.";
		assert desktopExit != null : "fx:id=\"desktopExit\" was not injected: check your FXML file 'MapView.fxml'.";
		assert up != null : "fx:id=\"up\" was not injected: check your FXML file 'MapView.fxml'.";
		assert down != null : "fx:id=\"down\" was not injected: check your FXML file 'MapView.fxml'.";
		assert left != null : "fx:id=\"left\" was not injected: check your FXML file 'MapView.fxml'.";
		assert right != null : "fx:id=\"right\" was not injected: check your FXML file 'MapView.fxml'.";
		assert save != null : "fx:id=\"save\" was not injected: check your FXML file 'MapView.fxml'.";
		assert load != null : "fx:id=\"load\" was not injected: check your FXML file 'MapView.fxml'.";
		assert hp != null : "fx:id=\"hp\" was not injected: check your FXML file 'MapView.fxml'.";
		assert mana != null : "fx:id=\"mana\" was not injected: check your FXML file 'MapView.fxml'.";
		assert characterClass != null : "fx:id=\"characterClass\" was not injected: check your FXML file 'MapView.fxml'.";
		assert strength != null : "fx:id=\"strength\" was not injected: check your FXML file 'MapView.fxml'.";
		assert dexterity != null : "fx:id=\"dexterity\" was not injected: check your FXML file 'MapView.fxml'.";
		assert armorReduction != null : "fx:id=\"armorReduction\" was not injected: check your FXML file 'MapView.fxml'.";
		assert weapon != null : "fx:id=\"weapon\" was not injected: check your FXML file 'MapView.fxml'.";
		assert character != null : "fx:id=\"Character\" was not injected: check your FXML file 'MapView.fxml'.";


		Image image = new Image("Batman.jpg");

		character = new ImageView(image);
		character.setFitHeight(50);
		character.setFitWidth(50);
		mapLayout.add(character, 0, 0);
	}


	public void setScene(Scene scene){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch(event.getCode()) {
				case W:
				case UP:
					if(positionY > 0) {
						int up = -1;
						if(positionY > 0) {
							mapLayout.getChildren().remove(character);
							positionY = positionY+up;
							mapLayout.add(character, positionX, positionY);
							event.consume();						
						}
					}
					break;
				case D:
				case RIGHT: 
					int right = 1;
					if(positionX < mapLayout.getColumnConstraints().size()) {
						mapLayout.getChildren().remove(character);
						positionX = positionX+right;
						mapLayout.add(character, positionX, positionY);
						event.consume();			
					}
					break;
				case S:	
				case DOWN:
					int down = 1;
					if(positionY < mapLayout.getRowConstraints().size()) {
						mapLayout.getChildren().remove(character);
						positionY = positionY+down;
						mapLayout.add(character, positionX, positionY);
						event.consume();			
					}
					break;
				case A:	
				case LEFT:
					int left = -1;
					if(positionX > 0) {
						mapLayout.getChildren().remove(character);
						positionX = positionX+left;
						mapLayout.add(character, positionX, positionY);
						event.consume();												
					}
					break;
				default:					
					break;
				}
			}		
		});
	}

	@Override
	public void handle(KeyEvent event) {

	}
}
