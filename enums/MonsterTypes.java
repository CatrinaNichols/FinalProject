package enums;

public enum MonsterTypes {
	PLAINS_GOBLIN_S("Goblin Scout", 12, 0, 0, 3, 9, 7, 10, 50), // X2 W//standard 8-14 attack range boss should be double
	PLAINS_GOBLIN_W("Goblin Warrior", 14, 0, 0, 4, 10, 8, 15, 50), //X1 W
	PLAINS_VULTURES("Flock of Vultures", 12, -1, 1, 3, 8, 6, 10, 50), //X2 W
	PLAINS_LION_MUTANT("Lion Beast Mutant", 20, 1, 1, 8, 11, 10, 15, 100),//X3 M
	PLAINS_LION_KNIGHT("Lion Knight", 22, 1, 1, 6, 13, 11, 20, 100),//X2 M
	PLAINS_CHIMERA("Chimera",40 ,3 ,0, 12, 20, 14, 30, 200),//X1 S
	CAVES_RATMEN_S("Ratmen Swarm", 14, -1, 1, 5, 10, 7, 0, 50),//X2 W
	CAVES_RATMEN_W("Ratman Warrior", 14, 1, 1, 4, 10, 7, 15, 50),//X2 W
	CAVES_RATMEN_A("Ratman Assassin", 6, 3, 3, 8, 12, 10, 0, 50),//X1 W
	CAVES_SPIDER_BEAST("Spider Beast", 16, 1, 1, 8, 11, 10, 30, 100),//X2 M
	CAVES_SPIDER_SWARM("Spider Swarm", 20, -2, 2, 9, 10, 8, 10, 100),//X2 M
	CAVES_GIANT_BAT("Giant Vampire Bat", 20, 3, 1, 8, 13, 9, 10, 100),//X1 M
	CAVES_ARACHNE_KNIGHT("Arachne Knight", 40, 2, 2, 15, 23, 16, 30, 200),//X1 S
	CASTLE_BOSS1("name", 40, 2, 2, 15, 23, 16, 30, 200),//X1 S
	CASTLE_BOSS2("name", 45, 4, 0, 12, 30, 20, 30, 300), //X1 S
	CASTLE_BOSS3("name", 80, 0, 4, 20, 35, 25, 50, 500), //X1 S
	FINAL_BOSS("name", 250, -10, -10, 1, 1, 1, 0, 1000); //X1 JOKE
	
	private String name;
	private int baseHp;
	private int baseDodge;
	private int baseToHit;
	private int minAttack;
	private int maxAttack;
	private int specialAttack;
	private int armorValue;
	private int xpValue;
	private MonsterTypes(String name, int baseHp, int baseDodge, int baseToHit, int minAttack, int maxAttack,
			int specialAttack, int armorValue, int xpValue) {
		this.name = name;
		this.baseHp = baseHp;
		this.baseDodge = baseDodge;
		this.baseToHit = baseToHit;
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
		this.specialAttack = specialAttack;
		this.armorValue = armorValue;
		this.xpValue = xpValue;
	}
	public String getName() {
		return name;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public int getBaseDodge() {
		return baseDodge;
	}
	public int getBaseToHit() {
		return baseToHit;
	}
	public int getMinAttack() {
		return minAttack;
	}
	public int getMaxAttack() {
		return maxAttack;
	}
	public int getSpecialAttack() {
		return specialAttack;
	}
	public int getArmorValue() {
		return armorValue;
	}
	public int getXpValue() {
		return xpValue;
	}
	
	
	
	
}
