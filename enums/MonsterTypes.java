package enums;

public enum MonsterTypes {
	PLAINS_GOBLIN_S("Goblin Scout", 12, 0, 0, 3, 9, 7, 10, 50);
	
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
