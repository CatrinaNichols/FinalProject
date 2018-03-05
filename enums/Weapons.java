package enums;

public enum Weapons {
	STAFF("Staff", 1, 3, 30),
	AXE("Axe", 2, 6, 60),
	SPEAR("Spear", 2, 6, 60),
	BOW("Bow", 2, 5, 50),
	CROSSBOW("Crossbow", 3, 5, 60),
	SCYTHE("Scythe", 1, 6, 50),
	GREATSWORD("Greatsword", 3, 5, 60),
	WAR_HAMMER("War Hammer", 4, 4, 70),
	MACE("Mace", 2, 4, 50),
	DAGGER("Dagger", 2, 3, 30),
	STRAIGHT_SWORD("Straight Sword", 1, 5, 50);
	
	 
	private final String name;
	private final int baseMinDam;
	private final int baseMaxDam;
	private final int minValue;
	
	private Weapons(String name, int baseMinDam, int baseMaxDam, int minValue) {
		this.name = name;
		this.baseMinDam = baseMinDam;
		this.baseMaxDam = baseMaxDam;
		this.minValue = minValue;
	}

	public String getName() {
		return name;
	}

	public int getBaseMinDam() {
		return baseMinDam;
	}

	public int getBaseMaxDam() {
		return baseMaxDam;
	}

	public int getMinValue() {
		return minValue;
	}
	
	
	

}
