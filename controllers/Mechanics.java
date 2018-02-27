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
	//Create a monster based on location
	//Turn taking system until someone is defeated
	//Use items accordingly
	//generate the experience gained and update player
	
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
