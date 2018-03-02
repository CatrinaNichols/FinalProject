package itemModels;

import java.util.Random;

public class Item {
	protected String name;
	protected int value;
	private final String[] itemNames = { "Bucket", "Shoe", "Chair", "Toy Figurine", "Spoon", "A Blank Book",
			"Playing Card", "Poster", "Rock", "Shiny Rock", "Bear Skin Rug", "Cup", "Note Saying \"I Love You\"",
			"Dah Whey", "Couch", "Pillow", "Little Bed", "Big Bed", "1 Story House", "2 Story House", "Meaning of Life",
			"Anti-Matter", "A Can of Worms", "Plumbus", "Kitten", "Broken Wand", "Dream", "Item", "Something Dumb",
			"Something Edible That Might Taste Bad" };
	static protected Random rng = new Random();

	public Item() {
		value = rng.nextInt(26);
		name = itemNames[rng.nextInt(itemNames.length)];
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + ", that is worth " + value + " gold coins.";
	}


}
