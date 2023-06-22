package biomon;

//all we need to make a biomon

public class Biomon {

	// all the stats the Biomon need
	// other stats like damage (from attacks) and initiative will be drawn from
	// "Stats"
	// Biomon start at level 0 (equals level 1)
	private int maxHP, currentHP, type;
	private int level = 0;

	// type 1 fluffy; type 2 slimy, type 3 crispy
	// could be calculated through type as well -> type * 10 + level * 5 (no
	// finetuning possible tho but faster and shorter)
	public static int getMaxHP(int level, int type) {
		if (type == 1) {
			return (10 + 5 * level);
		} else if (type == 2) {
			return (20 + 5 * level);
		} else {
			return (30 + 5 * level);
		}
	}

	// TODO type gets chosen in here (not in main)
	public Biomon() {

	}

}
