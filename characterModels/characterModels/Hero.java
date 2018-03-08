package characterModels;

import enums.Armors;
import enums.HeroClass;
import enums.Weapons;
import itemModels.Armor;
import itemModels.Weapon;

public class Hero extends BaseCharacter {

	private final HeroClass profession;
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	

	@Override
	public void levelUp(int xp) {
		this.xp += xp;
		if ((this.xp >= xpToNextLevel) && this.level < maxLevel) {
			xpToNextLevel += 250;
			// ui levelup stuff/ return int[2] (index of leveled stats 0 str, 1 dex, 2 intel
			int[] stats = new int[2];
			for (int i : stats) {
				switch (i) {
				case 0:
					baseStr++;
					break;
				case 1:
					baseDex++;
					break;
				case 2:
					baseInt++;
					break;
				default:
					break;
				}
			}
			this.maxHp = ((baseStr - 8) * 3) + baseDex + baseInt;
			this.hp = this.maxHp;

			this.maxMp = baseDex + (baseInt * 2);
			this.mp = this.maxMp;
		}
	}

	public Hero(String name, HeroClass profession, int level) {
		this.name = name;
		this.profession = profession;
		this.level = level;
		switch (this.profession.getStartingWeapon()) {
		case 0:
			equippedWeapon = new Weapon(Weapons.MACE, this.level);
			break;
		case 1:
			equippedWeapon = new Weapon(Weapons.DAGGER, this.level);
			break;
		case 2:
			equippedWeapon = new Weapon(Weapons.STAFF, this.level);
			break;
		default:
			break;
		}
		switch (this.profession.getStartingArmor()) {
		case 0:
			equippedArmor = new Armor(Armors.METAL_H, this.level);
			break;
		case 1:
			equippedArmor = new Armor(Armors.LEATHER_L, this.level);
			break;
		case 2:
			equippedArmor = new Armor(Armors.MAGIC_ROBES_M, this.level);
			break;
		default:
			break;
		}
		this.baseStr = this.profession.getStr();
		this.baseDex = this.profession.getDex();
		this.baseInt = this.profession.getIntel();

		this.maxHp = ((baseStr - 8) * 3) + baseDex + baseInt;
		this.hp = this.maxHp;

		this.maxMp = baseDex + (baseInt * 2);
		this.mp = this.maxMp;

	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public void setEquippedWeapon(Weapon equippedWeapon) {
		this.equippedWeapon = equippedWeapon;
	}

	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	public void setEquippedArmor(Armor equippedArmor) {
		this.equippedArmor = equippedArmor;
	}

	@Override
	public void takeDamage(int damage) {
		int damageTaken = (damage * (100 - equippedArmor.getDamReduction())) / 100;
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
			if (hp > maxHp) {
				hp = maxHp;
			}
			break;
		case 1:
			mp += heal;
			if (mp > maxMp) {
				mp = maxMp;
			}
			break;
		default:
			hp += heal;
			if (hp > maxHp) {
				hp = maxHp;
			}
			break;
		}

	}

	@Override
	public boolean attack(BaseCharacter c) {
		int toHitRoll = rng.nextInt(19) + 1;
		toHitRoll += (baseDex - 10) / 2;
		if(toHitRoll > c.getDodge()) {
			int damage = this.getDamage();
			c.takeDamage(damage);
			return true;
		}
		return false;
	}

	//message ui not enough mp???
	@Override
	public boolean specialAttack(BaseCharacter c) {
		if(mp >= 10) {
			mp -= 10;
			int toHitRoll = rng.nextInt(19) + 1;
			toHitRoll += (baseDex - 10);
			if(toHitRoll > c.getDodge()) {
				int damage = (baseInt - 10) + (4 * this.level);
				if (baseInt == 36) damage += 3; 
				c.takeDamage(damage);
				return true;
			}
			return false;
		}
		return attack(c);
	}

	@Override
	public int getDodge() {
		int toDodgeRoll = rng.nextInt(19) + 1;
		toDodgeRoll += (baseDex - 10) / 2;
		return toDodgeRoll;
	}
	//base weak is 12hp
	@Override
	public int getDamage() {
		int damage = ((baseStr - 10) / 2) + equippedWeapon.getAttackDamage();
		return damage;
	}

}
