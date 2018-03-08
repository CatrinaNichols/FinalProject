package characterModels;

import java.util.Random;

public abstract class BaseCharacter {
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
	protected int xp = 0;
	// 25 fights = level 10
	// each level 250 xp needed level 10 = 2500 total xp
	// average xp = 100 10 50 xp, 10 100 xp, 5 200xp drops
	protected int xpToNextLevel = 250;
	
	public int getXp() {
		return xp;
	}

	public BaseCharacter() {
		
	}
	
	public abstract void levelUp(int xp);
	
	public abstract void takeDamage(int damage);
	
	public abstract void heal(int heal, int type);
	
	public abstract boolean attack(BaseCharacter c);
	
	public abstract boolean specialAttack(BaseCharacter c);
	
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

	public int getHp() {
		return hp;
	}
	

}
