package characterModels;

import java.util.Random;

public abstract class Character {
	protected String name;
	protected int baseStr;
	protected int baseDex;
	protected int baseInt;
	protected int hp;
	protected int maxHp;
	protected int mp;
	protected int maxMp;
	protected boolean isAlive = true;
	protected static Random rng = new Random();
	protected int level;
	protected final int maxLevel = 10;
	
	public Character() {
		
	}
	
	public abstract void takeDamage(int damage);
	
	public abstract void heal(int heal, int type);
	
	public abstract void attack(Character c);
	
	public abstract void specialAttack(Character c);
	
	public abstract int getDodge();
	
	public abstract int getDamage();
	
	public int getToHit() {
		return 0;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public String getName() {
		return name;
	}

}
