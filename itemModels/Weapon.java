package itemModels;

import java.io.Serializable;

import enums.Weapons;

public class Weapon extends Item implements Serializable{

	private final Weapons weapon;
	private int minDam;
	private int maxDam;

	// the random loot weapon
	public Weapon(int level) {
		this.weapon = Weapons.values()[rng.nextInt(Weapons.values().length)];
		minDam = weapon.getBaseMinDam() * level;
		maxDam = weapon.getBaseMaxDam() * level;
		value = weapon.getMinValue() + (level * ((1 / 10) * weapon.getMinValue()));
		name = weapon.getName();
	}

	public Weapon(Weapons weapon, int level) {
		this.weapon = weapon;
		minDam = weapon.getBaseMinDam() * level;
		maxDam = weapon.getBaseMaxDam() * level;
		value = weapon.getMinValue() + (level * ((1 / 10) * weapon.getMinValue()));
		name = weapon.getName();
	}
	
	@Override
	public String toString() {
		return name + ", that is worth " + value + " gold coins"
				+ ", with a damage range of " + minDam + " - " + maxDam + "!";
	}

	public int getAttackDamage() {
		int attackDamage = 0;
		if (minDam == maxDam) {
			attackDamage = maxDam;
		} else {
			attackDamage = rng.nextInt(maxDam - minDam + 1) + minDam;
		}
		return attackDamage;
	}

	public int getMinDam() {
		return minDam;
	}

	public int getMaxDam() {
		return maxDam;
	}
	
	public Weapons getWeaponType() {
		return weapon;
	}

}
