package enums;

public enum HealingItems {
	
	MANA_POTION("Mana Potion", 15, 1, 20),
	HEALTH_POTION("Health Potion", 15, 0, 20);

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
