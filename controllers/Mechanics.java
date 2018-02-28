package controllers;

import java.util.ArrayList;

import characterModels.BaseCharacter;
import models.Item;

public class Mechanics {
BaseCharacter[][] map;
ArrayList<Item> inventory = new ArrayList<>();
BaseCharacter hero = new BaseCharacter();
//Coordinates for current location
int x=0;
int y=0;

public void save(String filePath) {
	//Character location
	//Character inventory
	//Story progression

}

public void load(String filePath) {
	//Update character location
	//Update inventory
	//Update story progression
	
}

public void combat() {
	boolean battle = true;
	boolean heroTurn = false;
	
	if(inPlains) {
		PlainMonster monster = new PlainMonster();
	} else if (inCave) {
		CaveMonster monster = new CaveMonster();
	} else if (inCastle) {
		CastleMonster monster = new CastleMonster();
	}
	
	if(hero.getDexMod() > monster.getDexMod()) {
		heroTurn = true;
	}
	
	do {
		if(heroTurn) {
			takeTurn(hero, monster);
			!heroTurn;
		} else {
			takeTurn(monster, hero);
			!heroTurn;
		}
		
		if(hero.getCurrentHP() == 0) {
			hero dies
			battle = false;
		} else if (monster.getCurrentHP() == 0) {
			monster dies
			battle = false;
		}
	} while (!battle);
}

public void takeTurn(BaseCharacter attacker, BaseCharacter defender) {
	if(attacker.getClass() == Hero) {
		//add in menu for hero's turn
	} else {
		int damage = attacker.attack(defender.getArmor());
		defender.takeDamage(damage);		
	}
}

public void inventoryManagement() {
	//Give player option to discard loot
	//show all loot available
	//Equipment of items
}

public void dropLoot() {
	//Determine what to drop based on monster
	//place item in player inventory
	
}

public void move(String action) {
	switch(action) {
	case "up":
		if(y-1 < 0) {
			System.out.println("Can't move in that direction");
		} else {
			map[y][x] = null;
			y--;
			map[y][x] = hero;
		}
		break;
	case "down":
		if(y+1 >= map.length) {
			System.out.println("Can't move in that direction");
		} else {
			map[y][x] = null;
			y++;
			map[y][x] = hero;
		}
		break;
	case "left":
		if(x-1 < 0) {
			System.out.println("Can't move in that direction");
		} else {
			map[y][x] = null;
			x--;
			map[y][x] = hero;
		}
		break;
	case "right":
		if(x+1 >= map[y].length) {
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
	switch(action) {
	case "save":
		save();
		break;
	case "load":
		load();
		break;
	case "inventory":
		inventoryManagement();
		break;
	case "move":
		move(action);
		break;
	}
}
}
