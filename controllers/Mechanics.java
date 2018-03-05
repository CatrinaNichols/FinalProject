package controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import characterModels.BaseCharacter;
import characterModels.Hero;
import characterModels.Monster;
import enums.*;
import itemModels.Item;

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
		switch(proffession) {
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
		//Character location
		//Character inventory
		//Story progression
		

		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(map);
			oos.writeObject(hero);
			oos.writeObject(inventory);
			oos.writeObject(x);
			oos.writeObject(y);
			
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

	public void load(String filePath) {
		// Update character location
		// Update inventory
		// Update story progression

	}

public void combat() {
	boolean battle = true;
	boolean heroTurn = false;
	
	Monster monster = new Monster(MonsterTypes.PLAINS_GOBLIN_S, 1);
	
//	if(inPlains) {
//		PlainMonster monster = new PlainMonster();
//	} else if (inCave) {
//		CaveMonster monster = new CaveMonster();
//	} else if (inCastle) {
//		CastleMonster monster = new CastleMonster();
//	}
	
//	if((hero.getDexMod() > monster.getDexMod()) {
//		heroTurn = true;
//	}
	
	do {
		if(heroTurn) {
			takeTurn(hero, monster, heroTurn);
			heroTurn = !heroTurn;
		} else {
			takeTurn(monster, hero, heroTurn);
			heroTurn = !heroTurn;
		}
		
		if(!hero.getIsAlive()) {
			//game over
			battle = false;
		} else if(!monster.getIsAlive()) {
			
			battle = false;
		}
		
	} while (!battle);
}

	public void takeTurn(BaseCharacter attacker, BaseCharacter defender, boolean heroTurn) {
		if (heroTurn) {
			// add in menu for hero's turn
		} else {
			int damage = attacker.getDamage();
			defender.takeDamage(damage);
		}
	}

public void inventoryManagement() {
	//Give player option to discard loot
	//show all loot available
	//Equipment of items
	
	
	take in choice of whether to discard, equip, or exit
	
	if(discard) {
		inventory.remove();
	}else if(use) {
		if(item.instanceOf(Armor)) {
			hero.setEquippedArmor(item);
		}else if(item.instanceOf(Weapon)) {
			hero.setEquippedWeapon(item);
		}else if(item.instanceOf(HealingItem)) {
			item.use(hero);
		}else {
		 not available to use
	}
	}else if(exit) {
		back to menu
	}
}

	public void dropLoot() {
		// Determine what to drop based on monster
		// place item in player inventory

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

	public void engine(String action) {
		switch (action) {
		case "save":
			//save();
			break;
		case "load":
			//load();
			break;
		case "inventory":
			//inventoryManagement();
			break;
		case "move":
			move(action);
			break;
		case "newGame":
			newGame();
			break;
		}
	}
}
