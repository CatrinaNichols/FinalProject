package enums;

public enum Weapons {
	MACE("Mace", 2, 4, 50),
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
