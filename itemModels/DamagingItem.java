package itemModels;

import enums.DamagingItems;
import characterModels.Character;
import interfaces.IConsumable;

public class DamagingItem extends Item  implements IConsumable{
	
	private int damagePower;
	private DamagingItems type;

	public DamagingItem(int level) {
		this.type = DamagingItems.values()[rng.nextInt(DamagingItems.values().length)];
		damagePower = type.getBaseDamage() + ((level - 1) * 5);
		value = type.getBaseValue() + (level * ((1 / 10) * type.getBaseValue()));
		name = type.getName();
	}
	
	public DamagingItem(DamagingItems type, int level) {
		this.type = type;
		damagePower = type.getBaseDamage() + ((level - 1) * 5);
		value = type.getBaseValue() + (level * ((1 / 10) * type.getBaseValue()));
		name = type.getName();
	}
	@Override
	public void use(Character c) {
		c.takeDamage(damagePower);
	}

	@Override
	public String getDescription() {
		
		return name + " deals " + damagePower + " points of damage.";
	}
	
	@Override
	public String toString() {
		return  name + ", that is worth " + value + " gold coins" + ", that deals "
				+ damagePower + " points of damage.";
	}

}
