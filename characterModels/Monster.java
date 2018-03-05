package characterModels;

import enums.MonsterTypes;

public class Monster extends Character{
	
	private final MonsterTypes monster;
	
	public Monster(MonsterTypes monster, int level) {
		this.monster = monster;
	}

	@Override
	public void takeDamage(int damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heal(int heal, int type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attack(Character c) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean specialAttack(Character c) {
		return false;
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

	@Override
	public void levelUp(int xp) {}

}
