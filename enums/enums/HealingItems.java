package enums;

public enum HealingItems {
	MAGIC_MUSHROOM("Magic Mushroom", 7, 1, 10),
	MANA_POTION("Mana Potion", 15, 1, 20),
	SUPER_MANA_POTION("Super Mana Potion", 30, 1, 60),
	SWEETROLL("Sweetroll", 7, 0, 10),
	HEALTH_POTION("Health Potion", 15, 0, 20),
	SUPER_HEALTH_POTION("Super Health Potion", 30, 0, 60);

	private String name;
	private int baseHealing;
	private int healType;
	private int baseValue;

	private HealingItems(String name, int baseHealing, int healType, int baseValue) {
		this.name = name;
		this.baseHealing = baseHealing;
		this.healType = healType;
		this.baseValue = baseValue;
	}

	public String getName() {
		return name;
	}

	public int getBaseHealing() {
		return baseHealing;
	}

	public int getBaseValue() {
		return baseValue;
	}

	public int getHealType() {
		return healType;
	}

}
