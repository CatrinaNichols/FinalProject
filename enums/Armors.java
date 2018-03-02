package enums;

public enum Armors {
	METAL_L("Metal Armor Set", "Light", 1, 10, 30, 70),
	METAL_M("Metal Armor Set", "Medium", 0, 15, 45, 70),
	METAL_H("Metal Armor Set", "Heavy", -1, 20, 60, 70);
	
	private final String name;
	private final String type;
	private final int baseDexMod;
	private final int baseMinDamageReduction;
	private final int baseMaxDamageReduction;
	private final int baseValue;
	
	

	private Armors(String name, String type, int baseDexMod, int baseMinDamageReduction, int baseMaxDamageReduction,
			int baseValue) {
		this.name = name;
		this.type = type;
		this.baseDexMod = baseDexMod;
		this.baseMinDamageReduction = baseMinDamageReduction;
		this.baseMaxDamageReduction = baseMaxDamageReduction;
		this.baseValue = baseValue;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getDexMod() {
		return baseDexMod;
	}

	public int getMinDamageReduction() {
		return baseMinDamageReduction;
	}
	
	public int getMaxDamageReduction() {
		return  baseMaxDamageReduction;
	}

	public int getValue() {
		return baseValue;
	}
	
	
	
	

}
