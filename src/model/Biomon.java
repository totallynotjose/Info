package model;

import java.io.Serializable;

/**
 * This class includes all the data and methods in regard to the Biomon.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class Biomon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * These integers represent the maximum and current HP as well as the type of
	 * the Biomon.
	 */
	private int maxHP, currentHP, type;
	/**
	 * This integer represents the Biomons' level.
	 */
	private int level = 0;
	/**
	 * This integer determines if the player's and the opponent's Biomon will land a
	 * critical hit.
	 */
	public static int crit;

	/**
	 * This array includes the stats for fluffy type normal attacks, critical normal
	 * attacks and special attacks from level one to 15.
	 */
	private int[][] fluffyStats = { { 10, 12, 16, 16, 18, 21, 21, 22, 24, 24, 26, 28, 28, 29, 31 },
			{ 12, 14, 17, 18, 20, 26, 26, 27, 29, 29, 32, 34, 34, 35, 37 },
			{ 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 44 } };
	/**
	 * This array includes the stats for slimy type normal attacks, critical normal
	 * attacks and special attacks from level one to 15.
	 */
	private int[][] slimyStats = { { 10, 11, 14, 13, 14, 18, 17, 18, 21, 20, 21, 24, 23, 24, 26 },
			{ 13, 14, 15, 16, 17, 23, 24, 25, 26, 27, 31, 32, 33, 34, 35 },
			{ 9, 10, 10, 11, 12, 14, 16, 16, 18, 20, 23, 26, 29, 32, 36 } };
	/**
	 * This array includes the stats for crispy type normal attacks, critical normal
	 * attacks and special attacks from level one to 15.
	 */
	private int[][] crispyStats = { { 8, 9, 10, 11, 12, 13, 14, 14, 15, 16, 17, 18, 19, 20, 21 },
			{ 10, 11, 12, 14, 14, 15, 16, 16, 17, 18, 20, 21, 22, 23, 24 },
			{ 8, 10, 11, 13, 15, 17, 18, 19, 20, 22, 24, 27, 30, 33, 36 } };

	/**
	 * A setter for the maximum HP of each type. Type 1 equals fluffy type 2 slimy
	 * and type 3 crispy types.
	 */
	public int calculateMaxHP() {
		if (type == 1) {
			return (16 + 5 * level);
		} else if (type == 2) {
			return (22 + 5 * level);
		} else {
			return (30 + 4 * level);
		}
	}

	/**
	 * Two getters for the current level of a Biomon. One is for the index of the
	 * array and one for the real level.
	 */
	public int getLevel() {
		if (level > 14) {
			level = 14;
		}
		return level;
	}
	public int printLevel() {
		if (level > 14) {
			level = 14;
		}
		return (level + 1);
	}

	/**
	 * Two getters for the Type of a Biomon - one as an integer and one as a string.
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

	/**
	 * A getter for the maximum HP of a Biomon.
	 */
	public int getMaxHP() {
		return maxHP;
	}

	/**
	 * A getter for the current HP of a Biomon.
	 */
	public int getCurrentHP() {
		return currentHP;
	}

	/**
	 * A getter for the initiative of a Biomon.
	 */
	public int getInitiative() {
		return (4 - type) + level / 5;
	}

	/**
	 * Here, damage for the normal attack is calculated. Crits can occur.
	 */
	public int normalAttack() {
		int damage = 0;
		crit = 0;

		// if the calculated random number is less than 20, a critical hit is landed
		if (Math.random() * 100 < 20) {
			crit = 1;
		}

		if (type == 1) {
			damage = fluffyStats[crit][level];
		} else if (type == 2) {
			damage = slimyStats[crit][level];
		} else {
			damage = crispyStats[crit][level];
		}
		return damage;
	}

	/**
	 * Here, damage for the special attack is calculated. Special attacks are
	 * effective against a certain type (damage increases by 50 %) and not very
	 * effective against another certain type (damage decreases by 50 %).
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
		return damage;
	}

	/**
	 * Method used for healing. The Biomon will regain 50 % of its maximum HP.
	 */
	public void heal() {
		crit = 0;
		if (type == 2 | type == 3) {
			currentHP = currentHP + (maxHP / 3);
		} else if (type == 1) {
			currentHP = currentHP + (maxHP / 2);
		}
		if (currentHP > maxHP) {
			currentHP = maxHP;
		}
	}

	/**
	 * Setter for the current HP of a Biomon.
	 */
	public void setCurrentHP(int damage) {
		currentHP = currentHP - damage;
		if (currentHP < 0) {
			currentHP = 0;
		}
	}

	/**
	 * Method for leveling up.
	 */
	public void levelUp() {
		if (level < 14) {
			level++;
			maxHP = calculateMaxHP();
		}
	}

	/**
	 * Method for the player's Biomon.
	 */
	public Biomon(int type, int level) {
		this.type = type;
		this.level = level;
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

	/**
	 * Method for the opponent's Biomon.
	 */
	public Biomon(int level) {
		// the type is chosen randomly
		type = (int) (Math.random() * 3 + 1);
		// the level is either one below, above or exactly on par with the player's
		// Biomon's level.
		this.level = (int) (Math.random() * ((level + 1) - (level - 1) + 1) + (level - 1));
		if (this.level < 0) {
			this.level = 0;
		}
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

}
