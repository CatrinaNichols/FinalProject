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
import enums.MonsterTypes;
import itemModels.Armor;
import itemModels.DamagingItem;
import itemModels.HealingItem;
import itemModels.Item;
import itemModels.Weapon;
import saveModel.Save;

public class Mechanics {
	static BaseCharacter[][] map;
	static ArrayList<Item> inventory = new ArrayList<>();
	static Hero hero;
	static Monster monster;
	// Coordinates for current location
	static int x = 0;
	static int y = 0;

	public void newGame(String name, String proffession) {
		switch (proffession) {
		case "warrior":
			hero = new Hero(name, HeroClass.WARRIOR, 1);
			break;
		case "ranger":
			hero = new Hero(name, HeroClass.RANGER, 1);
			break;
		case "wizard":
			hero = new Hero(name, HeroClass.WIZARD, 1);
			break;
		}

	}

	public static void save() {
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
			Save save = new Save(hero, inventory, map, x, y);
			oos.writeObject(save);
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

	public static void combat(String input) {
		monster = new Monster(MonsterTypes.PLAINS_GOBLIN_S, 1);

//		if (map) {
//			PlainMonster monster = new PlainMonster();
//		} else if (inCave) {
//			CaveMonster monster = new CaveMonster();
//		} else if (inCastle) {
//			CastleMonster monster = new CastleMonster();
//		}


		switch(input) {
		case "attack":
			hero.attack(monster);
			break;
		case "specialAttack":
			hero.specialAttack(monster);
			break;
		case "item":
			//inventoryManagement();
			break;
		}
		monster.attack(hero);
		
		combatResult();
	}

	public static void combatResult() {
		if(!hero.getIsAlive()) {
			//game over
		} else if(!monster.getIsAlive()) {
			//monster removed from map
			dropLoot(monster);
			hero.levelUp(monster.getXp());
		}
	}
	
	public static void dropLoot(Monster monster) {
		// Determine what to drop based on monster
		// place item in player inventory
		ArrayList<Item> drop = new ArrayList<>();
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
	
	public void move(String action) {
		switch (action) {
		case "up":
			if (y - 1 < 0) {} 
			else {
				map[y][x] = null;
				y--;
				map[y][x] = hero;
			}
			break;
		case "down":
			if (y + 1 >= map.length) {} 
			else {
				map[y][x] = null;
				y++;
				map[y][x] = hero;
			}
			break;
		case "left":
			if (x - 1 < 0) {} 
			else {
				map[y][x] = null;
				x--;
				map[y][x] = hero;
			}
			break;
		case "right":
			if (x + 1 >= map[y].length) {} 
			else {
				map[y][x] = null;
				x++;
				map[y][x] = hero;
			}
			break;
		}

	}

	public void engine(String action, int inventory, String choice) {
		switch (action) {
		case "save":
			save();
			break;
		case "load":
			load();
			break;
		case "inventory":
			inventoryManagement(inventory, choice);
			break;
		case "move":
			move(choice);
			break;
		}
	}
}