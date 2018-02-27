package controllers;

public class Mechanics {
ArrayList<Items> inventory = new ArrayList<>();
Hero hero = new Hero;

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
	}
}
}
