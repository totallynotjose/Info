package biomon;

public class CrispyBiomon extends Biomon {
	/*
	 * stats for attacks; normal attack, critical normal attack and special attack
	 */
	private int[][] stats = { { 10, 11, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 22, 23 },
			{ 12, 13, 14, 16, 16, 17, 18, 18, 19, 20, 22, 23, 24, 25, 26 },
			{ 8, 10, 12, 14, 16, 18, 19, 20, 22, 24, 26, 29, 32, 35, 38 } };

	// other variables specific for each Biomon class
	public int calculateMaxHP() {
		return (30 + 5 * level);
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getInitiative() {
		return 1 + level / 5;
	}

	public String printType() {
		return "crispy";
	}

	// normal attack and special attack

	public int normalAttack() {
		int damage, crit = 0;

		if (Math.random() * 100 < 20) {
			crit = 1;
			System.out.println("Critical hit!");
		}

		damage = stats[crit][level];

		System.out.println("Basic attack, " + damage + " damage dealt!");
		System.out.println();
		return damage;
	}

	public int specialAttack(Biomon enemy) {
		int damage;
		if (enemy instanceof FluffyBiomon) {
			// not effective against slimy
			damage = stats[2][level] * 5 / 10;
		} else if (enemy instanceof SlimyBiomon) {
			// effective against crispy
			damage = stats[2][level] * 15 / 10;
		} else {
			// no changes when used against fluffy
			damage = stats[2][level];
		}
		System.out.println("Special attack, " + damage + " damage dealt!");
		System.out.println();
		return damage;
	}

	// constructor

	public CrispyBiomon() {
		super();
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

	public CrispyBiomon(int level) {
		super(level);
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}
}
