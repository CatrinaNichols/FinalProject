package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import characterModels.BaseCharacter;
import characterModels.Hero;
import characterModels.Monster;
import enums.HeroClass;
import itemModels.Armor;
import itemModels.DamagingItem;
import itemModels.HealingItem;
import itemModels.Item;
import itemModels.Weapon;
import javafx.scene.layout.GridPane;
import saveModel.Save;

public class Mechanics {
	static BaseCharacter[][] map;
	static ArrayList<Item> inventory = new ArrayList<>();
	private static Hero hero;

	Monster monster;
	// Coordinates for current location

	
	public static Hero getHero() {
		return hero;
	}
	
	public static void setHero(Hero hero) {
		Mechanics.hero = hero;
	}
	
	static int x = 0;
	static int y = 0;

	public static void newGame(String name, String profession) {
		switch (profession) {
		case "warrior":
			setHero(new Hero(name, HeroClass.WARRIOR, 1));
			break;
		case "ranger":
			setHero(new Hero(name, HeroClass.RANGER, 1));
			break;
		case "wizard":
			setHero(new Hero(name, HeroClass.WIZARD, 1));
			break;
		}

	}

	public static void save(Hero hero, int x, int y, ArrayList<Item> inventory, GridPane map) {
		File filePath = new File("saves/saveFile.ser");		
		try {
			File parent = filePath.getParentFile();
			parent.mkdir();
			parent.createNewFile();
		} catch (FileNotFoundException f) {}
		catch(IOException e) {}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			Save save = new Save(hero, inventory, map, x, y);
//			oos.writeObject(save);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {}
		catch (IOException e) {}

	}

	public static void load() {
		String filePath = "saves/saveFile.ser";
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Save save = (Save) ois.readObject();
			ois.close();
			fis.close();

			hero = save.getHero();
			inventory = save.getInventory();
			map = save.getMap();
			x = save.getX();
			y = save.getY();
		} catch (FileNotFoundException e) {
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}

	}

	public static void combat(String input, Hero hero, Monster monster) {

		switch(input) {
		case "attack":
			hero.attack(monster);
			break;
		case "Special Attack":
			hero.specialAttack(monster);
			break;
		case "item":
			//inventoryManagement();
			break;
		}
		monster.attack(hero);
		
		combatResult(hero, monster);
	}

	public static void combatResult(Hero hero, Monster monster) {
		if(!hero.getIsAlive()) {
			//game over
		} else if(!monster.getIsAlive()) {
			//monster removed from map
			dropLoot(monster);
			hero.levelUp(monster.getXp());
		}
	}

	public void takeTurn(BaseCharacter attacker, BaseCharacter defender) {
		if (attacker instanceof Hero) {
			// add in menu for hero's turn
		} else {
			attacker.attack(defender);
		}
	}

	public static void dropLoot(Monster monster) {
		// Determine what to drop based on monster
		// place item in player inventory
		Random rand = new Random();
		int num;
		for(int i = 0; i < 10; i++) {
			num = rand.nextInt(5);
			
			switch(num) {
			case 0:{
				Item item = new Item();
				inventory.add(item);
				break;
			}
			case 1:{
				Armor armor = new Armor(hero.getLevel());
				inventory.add(armor);
				break;
			}
			case 2:{
				Weapon weapon = new Weapon(hero.getLevel());
				inventory.add(weapon);
				break;
			}
			case 3:{
				DamagingItem dm = new DamagingItem(hero.getLevel());
				inventory.add(dm);
				break;
			}
			case 4:{
				HealingItem hp = new HealingItem(hero.getLevel());
				inventory.add(hp);
				break;
			}
			}
		}
	}

	public String inventoryManagement(int itemInInventory, String choice) {
		// Give player option to discard loot
		// show all loot available
		// Equipment of items
		String message = "";
		if (choice.equals("equip")) {
			if (inventory.get(itemInInventory) instanceof Armor) {
				hero.setEquippedArmor((Armor)inventory.get(itemInInventory));
				message = "Armor is equipped";
			} else if (inventory.get(itemInInventory) instanceof Weapon) {
				hero.setEquippedWeapon((Weapon)inventory.get(itemInInventory));
				message = "Weapon is equipped";
			} else {
				message = "That's not an equiptable item";
			}
		} else if (choice.equals("use")) {
			if (inventory.get(itemInInventory) instanceof HealingItem) {
				((HealingItem)inventory.get(itemInInventory)).use(hero);
			} else if (inventory.get(itemInInventory) instanceof DamagingItem) {
				message = "You can't damage yourself!";
			} else {
				message = "That's not a useable item";
			}
		} else if (choice.equals("discard")) {
			inventory.remove(itemInInventory);
			message = "You've dropped the item";
		}
		return message;
	}

//	public void engine(String action, int inventory, String choice) {
//		switch (action) {
//		case "save":
//			save();
//			break;
//		case "load":
//			load();
//			break;
//		case "inventory":
//			inventoryManagement(inventory, choice);
//			break;
//		case "move":
//			move(choice);
//			break;
//		case "newGame":
//			newGame();
//			break;
//		}
//	}
}
