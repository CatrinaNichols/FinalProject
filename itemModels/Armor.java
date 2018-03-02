package itemModels;

import enums.Armors;

public class Armor extends Item {
	private int damReduction;
	private int dexMod;
	private String armorType;
	private final Armors armor;

	public Armor(int level) {
		this.armor = Armors.values()[rng.nextInt(Armors.values().length)];
		if(armor.getDexMod() < 0) {
			dexMod = armor.getDexMod() - (level / 2);
		} else {
			dexMod = armor.getDexMod() + (level / 2);			
		}
		armorType = armor.getType();
		damReduction = armor.getMinDamageReduction() + (int) (((float) armor.getMinDamageReduction()) * ((float) level) / 5.0f);
		if (damReduction > armor.getMaxDamageReduction()) damReduction = armor.getMaxDamageReduction();
		value = armor.getValue() + (level * ((1 / 10) * armor.getValue()));
		name = armor.getName();
	}

	public Armor(Armors armor, int level) {
		this.armor = armor;
		if(armor.getDexMod() < 0) {
			dexMod = armor.getDexMod() - (level / 2);
		} else {
			dexMod = armor.getDexMod() + (level / 2);			
		}
		armorType = armor.getType();
		damReduction = armor.getMinDamageReduction() + (int) (((float) armor.getMinDamageReduction()) * ((float) level) / 5.0f);
		if (damReduction > armor.getMaxDamageReduction()) damReduction = armor.getMaxDamageReduction();
		value = armor.getValue() + (level * ((1 / 10) * armor.getValue()));
		name = armor.getName();
	}

	public int getDexMod() {
		return dexMod;
	}

	public String getArmorType() {
		return armorType;
	}

	public int getDamReduction() {
		return damReduction;
	}
	
	

	@Override
	public String toString() {
		return armorType + " " + name + ", which has a " + dexMod
				+ " dex modifier, and damage reduction of " + damReduction
				+ ", that is worth " + value + " gold coins.";
	}
	
	

}
