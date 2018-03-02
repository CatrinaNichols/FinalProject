package characterModels;

import enums.Armors;
import enums.HeroClass;
import enums.Weapons;
import itemModels.Armor;
import itemModels.Weapon;

public class Hero extends Character {

	private HeroClass profession;
	private Weapon equippedWeapon;
	private Armor equippedArmor;

	public Hero(String name, HeroClass profession, int level) {
		this.name = name;
		this.profession = profession;
		this.level = level;
		switch (profession.getStartingWeapon()) {
		case 0:
			equippedWeapon = new Weapon(Weapons.MACE, this.level);
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;
		}
		switch (profession.getStartingArmor()) {
		case 0:
			equippedArmor = new Armor(Armors.METAL_H, this.level);
			break;
		case 1:
			break;
		case 2:
			break;
		default:
			break;
		}
		this.baseStr = profession.getStr();
		this.baseDex = profession.getDex();
		this.baseInt = profession.getIntel();

		this.maxHp = ((baseStr - 8) * 3) + baseDex + baseInt;
		this.hp = this.maxHp;

		this.maxMp = baseDex + (baseInt * 2);
		this.mp = this.maxMp;

	}

	@Override
	public void takeDamage(int damage) {
		int damageTaken = (damage * equippedArmor.getDamReduction()) / 100;
		hp -= damageTaken;
		// System.out.println(name + " took " + damageTaken + "points of damage!");
		if (hp <= 0) {
			isAlive = false;
		}

	}

	@Override
	public void heal(int heal, int type) {
		switch (type) {
		case 0:
			hp += heal;
			if(hp > maxHp) {
				hp = maxHp;
			}
			break;
		case 1:
			mp += heal;
			if(mp > maxMp) {
				mp = maxMp;
			}
			break;
		default:
			hp += heal;
			if(hp > maxHp) {
				hp = maxHp;
			}
			break;
		}

	}

	@Override
	public void attack(Character c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void specialAttack(Character c) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDodge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}

}
