package application;

import java.io.IOException;

import characterModels.Hero;
import characterModels.Monster;
import controllers.Mechanics;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Battle extends Application{

	private Stage stage;
	private Scene scene;

	@FXML
	private StackPane root;

	@FXML
    private AnchorPane battleScreen;

    @FXML
    private ImageView mapImage;

    @FXML
    private Label commands;

    @FXML
    private Label enemyStats;

    @FXML
    private Label enemyName;

    @FXML
    private Label characterInfo;

    @FXML
    private Label stats;

    @FXML
    private Button exitMenu;

    @FXML
    private Button exitDesktop;

    @FXML
    private TextField CharacterInfo;

    @FXML
    private ImageView player;

    @FXML
    private ProgressBar playerHp;

    @FXML
    private ImageView enemy;

    @FXML
    private ProgressBar enemyHp;

    @FXML
    private Button attackButton;

    @FXML
    private Button specialAttackButton;

    @FXML
    private Button itemListButton;

    @FXML
    private HBox items;

    @FXML
    private AnchorPane anchor;
    
    public AnchorPane getAnchor() {
		return anchor;
	}


	public void setAnchor(AnchorPane anchor) {
		this.anchor = anchor;
	}


	private Hero hero;
    private Monster monster;
    
    
    Battle(Hero hero, Monster monster, AnchorPane anchor) {
    	setHero(hero);
    	setMonster(monster);
    	setAnchor(anchor);
    }
    
    
	public Hero getHero() {
		return hero;
	}


	public void setHero(Hero hero) {
		this.hero = hero;
	}


	public Monster getMonster() {
		return monster;
	}


	public void setMonster(Monster enemies) {
		this.monster = enemies;
	}


	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		this.stage.setTitle("Seven Trials");

	}

	@FXML
	public void attack(ActionEvent event) {
		String playerMove = "attack";
		Mechanics.combat(playerMove, getHero(), getMonster());
		
		playerHp.setProgress((float)(Mechanics.getHero().getHp()/(float)Mechanics.getHero().getMaxHp()));
		enemyHp.setProgress((float)monster.getHp()/(float)monster.getMaxHp());
		
		checkForDeath();
	}
	
	@FXML
	public void specialAttack(ActionEvent event) {
		String playerMove = "Special Attack";
		Mechanics.combat(playerMove, getHero(), getMonster());
		
		playerHp.setProgress((double)((double)Mechanics.getHero().getHp()/(double)Mechanics.getHero().getMaxHp()));
		enemyHp.setProgress((double)((double)monster.getHp()/(double)monster.getMaxHp()));
		
		checkForDeath();
	}
	
	
	public void checkForDeath() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		if(enemyHp.getProgress() == 0.0) {
			battleScreen.setVisible(false);
			anchor.setVisible(true);
		}
		else if(playerHp.getProgress() <= 0){
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Menu.class.getResource("view/GameOverView.fxml"));
			Menu menu = new Menu();
			loader.setController(menu);
			StackPane mapView = null;
			try {
				mapView = loader.load();
			} catch (IOException e) {}
			root.getChildren().clear();
			root.getChildren().add(mapView);
		}		
	}
	
	@FXML
	public void item(ActionEvent event) {
		HBox itemHolder = new HBox();
		
	}
	
	@FXML
	public void exitApp(ActionEvent event) throws IOException{
		Platform.exit();
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
