package biomon;

public class Stats {

	// TODO add getter for a new biomon (what stats do we need? only currentHP? And
	// type but that is not chosen here?)
	// TODO add attack selection (also includes initiative)
	// TODO add attacks for enemy
	// TODO add own attacks

	// stats for attacks; HP and initiative will be calculated somewhere else
	// normal attack, crit normal attack, special attack (levels 1 to 15)
	// optional: would be nice to read these from a file to make it more readable
	private int[][] fluffyStats = { { 10, 12, 14, 16, 18, 20, 21, 22, 23, 24, 26, 27, 28, 29, 30 },
			{ 12, 14, 16, 18, 20, 25, 26, 27, 28, 29, 32, 33, 34, 35, 36 },
			{ 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 44 } };
	private int[][] slimyStats = { { 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 },
			{ 13, 14, 15, 16, 17, 23, 24, 25, 26, 27, 31, 32, 33, 34, 35 },
			{ 9, 10, 10, 11, 12, 14, 16, 16, 18, 20, 23, 26, 29, 32, 36 } };
	private int[][] crispyStats = { { 10, 11, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23 },
			{ 12, 13, 14, 16, 16, 17, 18, 18, 19, 20, 22, 23, 24, 25, 26 },
			{ 8, 10, 12, 14, 16, 18, 19, 20, 22, 24, 26, 29, 32, 35, 38 } };

	// type 1 fluffy; type 2 slimy, type 3 crispy
	public static int getMaxHP(int level, int type) {
		if (type == 1) {
			return (10 + 5 * level);
		} else if (type == 2) {
			return (20 + 5 * level);
		} else {
			return (30 + 5 * level);
		}
	}

	public static void main(String[] args) {

	}

}
