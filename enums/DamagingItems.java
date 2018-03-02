package enums;

public enum DamagingItems {

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
