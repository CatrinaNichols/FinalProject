package enums;
 
public enum Armors {
	ROBES_L("Robe Armor Set", "Light", 2, 10, 15, 40),
	ROBES_M("Robe Armor Set", "Medium", 0, 15, 25, 40),
	ROBES_H("Robe Armor Set", "Heavy", -1, 25, 40, 40),
	MAGIC_ROBES_L("Magic Robe Armor Set", "Light", 3, 10, 25, 50),
	MAGIC_ROBES_M("Magic Robe Armor Set", "Medium", 0, 20, 35, 50),
	MAGIC_ROBES_H("Magic Robe Armor Set", "Heavy", 0, 25, 50, 50),
	LEATHER_L("Leather Armor Set", "Light", 2, 10, 20, 50),
	LEATHER_M("Leather Armor Set", "Medium", 0, 15, 30, 50),
	LEATHER_H("Leather Armor Set", "Heavy", -1, 25, 50, 50),
	BEAST_HIDE_L("Beast Hide Armor Set", "Light", 3, 15, 25, 60),
	BEAST_HIDE_M("Beast Hide Armor Set", "Medium", 0, 20, 35, 60),
	BEAST_HIDE_H("Beast Hide Armor Set", "Heavy", -1, 30, 55, 55),
	METAL_L("Metal Armor Set", "Light", 1, 10, 30, 70),
	METAL_M("Metal Armor Set", "Medium", 0, 15, 45, 70),
	METAL_H("Metal Armor Set", "Heavy", -1, 20, 60, 70),
	EBONY_L("Ebony Armor Set", "Light", 1, 20, 30, 80),
	EBONY_M("Ebony Armor Set", "Medium", 0, 25, 50, 80),
	EBONY_H("Ebony Armor Set", "Heavy", -2, 30, 65, 80);
	
	
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
