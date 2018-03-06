package controllers;

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
import itemModels.Armor;
import itemModels.DamagingItem;
import itemModels.HealingItem;
import itemModels.Item;
import itemModels.Weapon;
import saveModel.Save;

public class Mechanics {
	BaseCharacter[][] map;
	ArrayList<Item> inventory = new ArrayList<>();
	Hero hero;
	// Coordinates for current location
	int x = 0;
	int y = 0;

	public void newGame() {
		String name = "placeholder";
		String proffession = "warrior";
		switch (proffession) {
		case "warrior":
			hero = new Hero(name, HeroClass.WARRIOR);
			break;
		case "ranger":
			hero = new Hero(name, HeroClass.RANGER);
			break;
		case "wizard":
			hero = new Hero(name, HeroClass.WIZARD);
			break;
		}

	}

	public void save() {
		String filePath = "saves/saveFile.ser";
		// Character location
		// Character inventory
		// Story progression

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			Save save = new Save(hero, inventory, map, x, y);
			oos.writeObject(save);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void load() {
		String filePath = "saves/saveFile.ser";
		// Update character location
		// Update inventory
		// Update story progression
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void combat() {
		boolean battle = true;
		boolean heroTurn = false;

		if (inPlains) {
			PlainMonster monster = new PlainMonster();
		} else if (inCave) {
			CaveMonster monster = new CaveMonster();
		} else if (inCastle) {
			CastleMonster monster = new CastleMonster();
		}

		if (hero.getDexMod() > monster.getDexMod()) {
			heroTurn = true;
		}

		do {
			if (heroTurn) {
				takeTurn(hero, monster);
				heroTurn = false;
			} else {
				takeTurn(monster, hero);
				heroTurn = true;
			}

			if (hero.getCurrentHP() == 0) {
				battle = false;
			} else if (monster.getCurrentHP() == 0) {
				dropLoot(monster);
				battle = false;
			}
		} while (!battle);
	}

	public void takeTurn(BaseCharacter attacker, BaseCharacter defender) {
		if (attacker instanceof Hero) {
			// add in menu for hero's turn
		} else {
			int damage = attacker.attack(defender.getArmor());
			defender.takeDamage(damage);
		}
	}

	public void dropLoot(Monster monster) {
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

	public String inventoryManagement(int itemInInventory, String choice) {
		// Give player option to discard loot
		// show all loot available
		// Equipment of items
		String message;
		if (choice.equals("equip")) {
			if (inventory.get(itemInInventory) instanceof Armor) {
				hero.setequippedArmor(inventory.get(itemInInventory));
				message = "Armor is equipped";
			} else if (inventory.get(itemInInventory) instanceof Weapon) {
				hero.setequippedWeapon(inventory.get(itemInInventory));
				message = "Weapon is equipped";
			} else {
				message = "That's not an equiptable item";
			}
		} else if (choice.equals("use")) {
			if (inventory.get(itemInInventory) instanceof HealingItem) {
				hero.heal(inventory.get(itemInInventory).getHealPower(), inventory.get(itemInInventory).type);
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
			if (y - 1 < 0) {
				System.out.println("Can't move in that direction");
			} else {
				map[y][x] = null;
				y--;
				map[y][x] = hero;
			}
			break;
		case "down":
			if (y + 1 >= map.length) {
				System.out.println("Can't move in that direction");
			} else {
				map[y][x] = null;
				y++;
				map[y][x] = hero;
			}
			break;
		case "left":
			if (x - 1 < 0) {
				System.out.println("Can't move in that direction");
			} else {
				map[y][x] = null;
				x--;
				map[y][x] = hero;
			}
			break;
		case "right":
			if (x + 1 >= map[y].length) {
				System.out.println("Can't move in that direction");
			} else {
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
		case "newGame":
			newGame();
			break;
		}
	}
}
