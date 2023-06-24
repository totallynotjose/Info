package biomon;

//all we need to make a biomon

public class Biomon {

	// all the stats the Biomon need
	// Biomon start at level 0 (equals level 1)
	private int maxHP, currentHP;
	private int level = 0;
	private static int type;

	// stats for attacks
	// normal attack, crit normal attack, special attack (levels 1 to 15; index 0 to
	// 14)
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

	public static int chooseMyType() {
		System.out.println("Choose your Biomon-type! (1) fluffy (2) slimy (3) crispy");
		int decision = SystemInReader.readInt();

		while (decision < 1 || decision > 3) {
			System.out.println();
			System.out.println("Invalid input, please try again: (1) fluffy (2) slimy (3) crispy");
			decision = SystemInReader.readInt();
		}
		if (decision == 1) {
			return 1;
		} else if (decision == 2) {
			return 2;
		} else {
			return 3;
		}
	}

	// type 1 fluffy; type 2 slimy, type 3 crispy
	public int calculateMaxHP() {
		if (type == 1) {
			return (10 + 5 * level);
		} else if (type == 2) {
			return (20 + 5 * level);
		} else {
			return (30 + 5 * level);
		}
	}

	/*
	 * print level and get level are two different methods because getLevel refers
	 * to the index that we use in arrays (stats for level one are index 0, so the
	 * level starts at 0. But for printing you want the actual level, not the index
	 * we will be using
	 */
	public int getLevel() {
		return level;
	}

	public int printLevel() {
		return (level + 1);
	}

	public int getType() {
		return type;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	// TODO add crit
	public int normalAttack() {
		int damage;
		if (type == 1) {
			damage = fluffyStats[0][level];
		} else if (type == 2) {
			damage = slimyStats[0][level];
		} else {
			damage = crispyStats[0][level];
		}
		System.out.println("Basic attack, " + damage + " damage dealt!");
		return damage;
	}

	public int specialAttack(int enemyType) {
		int damage;
		if (type == 1) {
			// for fluffy: effective against crispy, not effective against slimy
			if (type == enemyType) {
				damage = fluffyStats[2][level];
			} else if (enemyType == 3) {
				damage = fluffyStats[2][level] * 15 / 10;
			} else {
				damage = fluffyStats[2][level] * 5 / 10;
			}
		} else if (type == 2) {
			// for slimy: effective against fluffy, not effective against crispy
			if (type == enemyType) {
				damage = slimyStats[2][level];
			} else if (enemyType == 1) {
				damage = slimyStats[2][level] * 15 / 10;
			} else {
				damage = slimyStats[2][level] * 5 / 10;
			}
		} else {
			if (type == enemyType) {
				damage = crispyStats[2][level];
			} else if (enemyType == 2) {
				damage = crispyStats[2][level] * 15 / 10;
			} else {
				damage = crispyStats[2][level] * 5 / 10;
			}
		}

		System.out.println("Special attack, " + damage + " damage dealt!");
		return damage;
	}

	// maybe change message depending on Biomon (myself or enemy)?
	public void heal() {
		currentHP = currentHP + (maxHP / 2);
		if (currentHP > maxHP) {
			currentHP = maxHP;
		}
		System.out.println("Healing successful!");
	}

	public void setCurrentHP(int damage) {
		currentHP = currentHP - damage;
		if (currentHP < 0) {
			currentHP = 0;
		}
	}

	public Biomon(int type, int level) {
		this.type = type;
		this.level = level;
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

}
