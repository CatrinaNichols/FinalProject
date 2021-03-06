package itemModels;

import java.io.Serializable;

import characterModels.BaseCharacter;
import enums.HealingItems;
import interfaces.Iconsumable;

public class HealingItem extends Item implements Iconsumable, Serializable {

	private int healPower;
	private HealingItems type;

	public HealingItem(int level) {
		this.type = HealingItems.values()[rng.nextInt(HealingItems.values().length)];
		healPower = type.getBaseHealing() + ((level - 1) * 5);
		value = type.getBaseValue() + (level * ((1 / 10) * type.getBaseValue()));
		name = type.getName();
	}

	public HealingItem(HealingItems type, int level) {
		this.type = type;
		healPower = type.getBaseHealing() + ((level - 1) * 5);
		value = type.getBaseValue() + (level * ((1 / 10) * type.getBaseValue()));
		name = type.getName();
	}

	@Override
	public String toString() {
		return name + ", that is worth " + value + " gold coins" + ", that heals " + healPower + " worth of HP.";
	}

	@Override
	public String getDescription() {
		return name + " restores " + healPower + " points of health.";
	}

	@Override
	public void use(BaseCharacter c) {
		c.heal(healPower, type.getHealType());

	}

}
