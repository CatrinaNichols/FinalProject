package characterModels;

import enums.MonsterTypes;

public class Monster extends Character {

	private final MonsterTypes monster;

	public Monster(MonsterTypes monster, int level) {
		this.monster = monster;
		this.name = monster.getName();
		this.baseDex = rng.nextInt(level * 2) + 10;
		this.baseStr = rng.nextInt(level * 2) + 10;
		this.baseInt = rng.nextInt(level * 2) + 10;
		this.level = level;
		this.maxHp = monster.getBaseHp() + (int)((((float) this.level - 1.0f) / 3.0f) * (float) monster.getBaseHp());
		this.hp = this.maxHp;
		this.xp = monster.getXpValue();
	}

	@Override
	public void takeDamage(int damage) {
		int damageTaken = (damage * (100 - monster.getArmorValue())) / 100;
		hp -= damageTaken;
		// name + " took " + damageTaken + "points of damage!"
		if (hp <= 0) {
			isAlive = false;
		}

	}

	@Override
	public void heal(int heal, int type) {
	}

	@Override
	public boolean attack(Character c) {
		int toHitRoll = rng.nextInt(19) + 1;
		toHitRoll += monster.getBaseToHit() + (level / 2);
		if (toHitRoll > c.getDodge()) {
			int damage = this.getDamage();
			c.takeDamage(damage);
			return true;
		}
		return false;
	}

	// message ui not enough mp???
	@Override
	public boolean specialAttack(Character c) {
		int toHitRoll = rng.nextInt(19) + 1;
		toHitRoll += monster.getBaseToHit() + (level);
		if (toHitRoll > c.getDodge()) {
			int damage = monster.getSpecialAttack() + (2 * this.level);
			c.takeDamage(damage);
			return true;
		}
		return false;
	}

	@Override
	public int getDodge() {
		int toDodgeRoll = rng.nextInt(19) + 1;
		toDodgeRoll += monster.getBaseDodge() + (level / 2);
		return toDodgeRoll;
	}

	// base weak is 12hp
	@Override
	public int getDamage() {
		int damage = rng.nextInt(monster.getMaxAttack() - monster.getMinAttack()) + monster.getMinAttack() + 1 + level;
		return damage;
	}

	@Override
	public void levelUp(int xp) {
	}

}
