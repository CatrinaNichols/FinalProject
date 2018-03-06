package enums;

public enum DamagingItems {
	KUKRI("Kukri", 20, 30),
	THROWINGKNIVES("Throwing Knives", 10, 20),
	POISONBOMB("Poison Bomb", 30, 60),
	SHRAPNELBOMB("Shrapnel Bomb", 25, 50),
	MOLOTOV("Molotov", 15, 30);

	private String name;
	private int baseDamage;
	private int baseValue;

	private DamagingItems(String name, int baseDamage, int baseValue) {
		this.name = name;
		this.baseDamage = baseDamage;
		this.baseValue = baseValue;
	}

	public String getName() {
		return name;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public int getBaseValue() {
		return baseValue;
	}

}
