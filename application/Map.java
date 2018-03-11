package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import characterModels.BaseCharacter;
import characterModels.Hero;
import characterModels.Monster;
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
	private ImageView character;

	@FXML
	private ImageView enemy1;

	@FXML
	private ImageView enemy2;

	@FXML
	private ImageView enemy3;

	@FXML
	private ImageView enemy4;

	@FXML
	private Label level;

	@FXML
	private Label characterName;


	private ArrayList<Monster>monsters = new ArrayList<>();

	static ArrayList<ImageView> enemies = new ArrayList<>();

	HashMap <ImageView, Monster> enemyLocater = new HashMap<ImageView, Monster>();

	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	@FXML
	public void upButtonMovement(ActionEvent event) {
		int up = -1;
		if(positionY > 0) {
			mapLayout.getChildren().remove(character);
			positionY = positionY+up;
			mapLayout.add(character, positionX, positionY);
			enemySorter();
		}
	}
	@FXML
	public void downButtonMovement(ActionEvent event) {
		int down = 1;
		if(positionY < mapLayout.getRowConstraints().size()) {
			mapLayout.getChildren().remove(character);
			positionY = positionY+down;
			mapLayout.add(character, positionX, positionY);
			enemySorter();
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
			enemySorter();
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
			enemySorter();
		}
	}

	public void enemySorter() {
		ImageView key =null;
		for (ImageView enemy : enemies) {
			if(character.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Map.class.getResource("view/BattleView.fxml"));

				Battle battle = new Battle(Mechanics.getHero(), enemyLocater.get(enemy), anchor);
				key = enemy; 
				
				if(!enemyLocater.get(key).getIsAlive()) {
					mapLayout.getChildren().remove(enemy);										
				}
				
				loader.setController(battle);
				StackPane battleView = null;
				try {
				battleView = loader.load();
				} catch (IOException e) {}	
				anchor.setVisible(false);
				gameLayout.getChildren().add(battleView);
			}
		}
//			if()
		if(key !=null && !enemyLocater.get(key).getIsAlive()) {
			enemyLocater.remove(key);			
			enemies.remove(key);
		}
		updateStats();
	}

	@FXML
	public void exitApp(ActionEvent event) throws IOException{
		Platform.exit();
	}

	Menu control = new Menu();

	@FXML
	public void saveGame(ActionEvent event) {
		Mechanics.save(Mechanics.getHero(), positionX, positionX, null, mapLayout);
	}

	@FXML
	public void loadGame(ActionEvent event) {
		Mechanics.load();
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
	        assert dexterity != null : "fx:id=\"dexterity\" was not injected: check your FXML file 'MapView.fxml'.";
	        assert weapon != null : "fx:id=\"weapon\" was not injected: check your FXML file 'MapView.fxml'.";
	        assert level != null : "fx:id=\"level\" was not injected: check your FXML file 'MapView.fxml'.";
	        assert characterName != null : "fx:id=\"characterName\" was not injected: check your FXML file 'MapView.fxml'.";


		Monster enemy1Model = new Monster(enums.MonsterTypes.PLAINS_GOBLIN_S, 1);
		Monster enemy2Model = new Monster(enums.MonsterTypes.CASTLE_BOSS1, 1);
		Monster enemy3Model = new Monster(enums.MonsterTypes.CAVES_ARACHNE_KNIGHT, 1);

		monsters.add(enemy1Model);
		monsters.add(enemy2Model);
		monsters.add(enemy3Model);

		Image image = new Image("Batman.jpg");
		enemy1 = new ImageView(image);
		enemy1.setFitHeight(20);
		enemy1.setFitWidth(20);
		enemies.add(enemy1);
		
		enemy2 = new ImageView(image);
		enemy2.setFitHeight(20);
		enemy2.setFitWidth(20);
		enemies.add(enemy2);

		enemy3 = new ImageView(image);
		enemy3.setFitHeight(20);
		enemy3.setFitWidth(20);
		enemies.add(enemy3);

		
		mapLayout.add(enemy1, 3, 4);
		mapLayout.add(enemy2, 6, 4);
		mapLayout.add(enemy3, 2, 4);
		
//		hero = new Hero("Goat", enums.HeroClass.RANGER, 1);
		character = new ImageView(image);
		character.setFitHeight(50);
		character.setFitWidth(50);
		mapLayout.add(character, 0, 0);

		for(int i =0; i<monsters.size();i++) {
			enemyLocater.put(enemies.get(i), monsters.get(i));
		}
		
		updateStats();
	}

	public void updateStats() {
		hp.setText("Hp: " + Mechanics.getHero().getHp() + "/" + Mechanics.getHero().getMaxHp());
		mana.setText("Mana: " +Mechanics.getHero().getMp() + "/" + Mechanics.getHero().getMaxMp());
		characterClass.setText(""+Mechanics.getHero().getProfession());
		characterName.setText("Name: " + Mechanics.getHero().getName());
		level.setText("Level: " + Mechanics.getHero().getLevel());
		dexterity.setText("Dexterity: " + Mechanics.getHero().getBaseDex());
		strength.setText("Strength: " + Mechanics.getHero().getBaseStrength());
		weapon.setText("Weapon: " + Mechanics.getHero().getEquippedWeapon());
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
							enemySorter();
						}
						event.consume();
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
						enemySorter();
					}
					event.consume();
					break;
				case S:	
				case DOWN:
					int down = 1;
					if(positionY < mapLayout.getRowConstraints().size()) {
						mapLayout.getChildren().remove(character);
						positionY = positionY+down;
						mapLayout.add(character, positionX, positionY);
						event.consume();
						enemySorter();
					}
					event.consume();
					break;
				case A:	
				case LEFT:
					int left = -1;
					if(positionX > 0) {
						mapLayout.getChildren().remove(character);
						positionX = positionX+left;
						mapLayout.add(character, positionX, positionY);
						event.consume();
						enemySorter();
					}
					event.consume();
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
