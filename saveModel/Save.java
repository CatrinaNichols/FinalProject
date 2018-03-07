package saveModel;

import java.io.Serializable;
import java.util.ArrayList;

import characterModels.BaseCharacter;
import characterModels.Hero;
import itemModels.Item;

public class Save implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hero hero;
	private ArrayList<Item> inventory;
	private BaseCharacter[][] map;
	private int x, y;

	public Save(Hero hero, ArrayList<Item> inventory, BaseCharacter[][] map, int x, int y) {
		
		this.setHero(hero);
		this.setInventory(inventory);
		this.setMap(map);
		this.setX(x);
		this.setY(y);
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public BaseCharacter[][] getMap() {
		return map;
	}

	public void setMap(BaseCharacter[][] map) {
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
