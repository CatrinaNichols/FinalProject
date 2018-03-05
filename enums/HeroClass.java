package enums;

public enum HeroClass {
	
	WARRIOR("Warrior", 16, 12, 8, 0, 0),
	RANGER("Ranger", 10, 16, 10, 1, 1),
	WIZARD("Wizard", 8, 12, 16, 2 , 2);
	 
	private String className;
	private int str;
	private int dex;
	private int intel;
	private int startingWeapon;
	private int startingArmor;
	private HeroClass(String className, int str, int dex, int intel, int startingWeapon, int startingArmor) {
		this.className = className;
		this.str = str;
		this.dex = dex;
		this.intel = intel;
		this.startingWeapon = startingWeapon;
		this.startingArmor = startingArmor;
	}
	public String getClassName() {
		return className;
	}
	public int getStr() {
		return str;
	}
	public int getDex() {
		return dex;
	}
	public int getIntel() {
		return intel;
	}
	public int getStartingWeapon() {
		return startingWeapon;
	}
	public int getStartingArmor() {
		return startingArmor;
	}
	
	

}
