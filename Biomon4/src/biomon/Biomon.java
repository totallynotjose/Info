package biomon;

import java.io.Serializable;

public class Biomon implements Serializable {

	// all the stats the Biomon need
	// Biomon start at level (index) 0 (equals level 1)
	private int maxHP, currentHP, type;
	private int level = 0;
	public static int crit;

	// stats for attacks
	// normal attack, critical normal attack, special attack (levels 1 to 15; index
	// 0 to
	// 14)
	// optional: would be nice to read these from a file to make it more readable
	private int[][] fluffyStats = { { 10, 12, 16, 16, 18, 21, 21, 22, 24, 24, 26, 28, 28, 29, 31 },
			{ 12, 14, 17, 18, 20, 26, 26, 27, 29, 29, 32, 34, 34, 35, 37 },
			{ 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 44 } };
	private int[][] slimyStats = { { 10, 11, 14, 13, 14, 18, 17, 18, 21, 20, 21, 24, 23, 24, 26 },
			{ 13, 14, 15, 16, 17, 23, 24, 25, 26, 27, 31, 32, 33, 34, 35 },
			{ 9, 10, 10, 11, 12, 14, 16, 16, 18, 20, 23, 26, 29, 32, 36 } };
	private int[][] crispyStats = { { 8, 9, 10, 11, 12, 13, 14, 14, 15, 16, 17, 18, 19, 20, 21 },
			{ 10, 11, 12, 14, 14, 15, 16, 16, 17, 18, 20, 21, 22, 23, 24 },
			{ 8, 10, 11, 13, 15, 17, 18, 19, 20, 22, 24, 27, 30, 33, 36 } };

	// all setters and getters
	/* public static int chooseMyType() {
		//new StarterChoiceMenu();
		System.out.println("Choose your Biomon Type! (1) fluffy (2) slimy (3) crispy");
		int decision;
		decision = SystemInReader.readInt();
		return decision;
	}*/

	// type 1 fluffy; type 2 slimy, type 3 crispy
	public int calculateMaxHP() {
		if (type == 1) {
			return (16 + 5 * level);
		} else if (type == 2) {
			return (22 + 5 * level);
		} else {
			return (30 + 4 * level);
		}
	}

	/*
	 * print level and get level are two different methods because getLevel refers
	 * to the index that we use in arrays (stats for level 1 are index 0, so the
	 * level starts at 0. But for printing you want the actual level, not the index
	 */
	public int getLevel() {
		return level;
	}

	public int printLevel() {
		return (level + 1);
	}

	/*
	 * getType refers to the number/index associated with the type, printType is
	 * used if you want to print the type; the name of the type is much more useful
	 * here than the number/index
	 */
	public int getType() {
		return type;
	}

	public String printType() {
		if (type == 1) {
			return "fluffy";
		} else if (type == 2) {
			return "slimy";
		} else {
			return "crispy";
		}
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getInitiative() {
		return (4 - type) + level / 5;
	}

	// here damage for attacks and the heal are calculated

	// if the random number is less than 20, a critical hit is made
	// normal attack damage has the index 0, critical damage has index 1
	public int normalAttack() {
		int damage = 0;
		crit = 0;

		if (Math.random() * 100 < 20) {
			crit = 1;
			//System.out.println("Critical hit!");
		}

		if (type == 1) {
			damage = fluffyStats[crit][level];
		} else if (type == 2) {
			damage = slimyStats[crit][level];
		} else {
			damage = crispyStats[crit][level];
		}
		//System.out.println("Basic attack, " + damage + " damage dealt!");
		//System.out.println();
		return damage;
	}

	/*
	 * special attack is effective against a certain types (damage increases by 50%)
	 * and not effective against another type (damage decreases by 50%). If you
	 * attack a Biomon of the same type the damage does not change
	 */
	public int specialAttack(int enemyType) {
		int damage;
		crit = 0;
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

		//System.out.println("Special attack, " + damage + " damage dealt!");
		//System.out.println();
		return damage;
	}

	// message "Healing successful not included here because healing is also used
	// after you win a fight (message not needed there)
	public void heal() { 
	crit = 0;
	if (type == 2| type == 3){
		currentHP = currentHP + (maxHP / 3);
	}
		else if (type == 1) {
			currentHP = currentHP + (maxHP /2);
		}
		if (currentHP > maxHP) {
			currentHP = maxHP;
		}
	}

	

	public void setCurrentHP(int damage) {
		currentHP = currentHP - damage;
		if (currentHP < 0) {
			currentHP = 0;
		}
	}

	// if you win you level up and heal up to 50% of your new maxHP
	public void levelUp() {
		level++;
		maxHP = calculateMaxHP();
		heal();
		//System.out.println("You won! Biomon level up: level " + printLevel() + ", max HP " + maxHP + ", current HP "
		//	+ currentHP + "!");
	}

	public Biomon(int type, int level) {
		this.type = type;
		this.level = level;
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

	// for enemy Biomon the type is chosen randomly. The level is the level of
	// myBiomon +/- 1 (to sometimes make it easier, sometimes harder)
	public Biomon(int level) {
		type = (int) (Math.random() * 3 + 1);
		this.level = (int) (Math.random() * ((level + 1) - (level - 1) + 1) + (level - 1));
		if (this.level < 0) {
			this.level = 0;
		}
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

}
