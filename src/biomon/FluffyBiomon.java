package biomon;

public class FluffyBiomon extends Biomon {
	/*
	 * stats for attacks; normal attack, critical normal attack and special attack
	 */
	private int[][] stats = { { 10, 12, 14, 16, 18, 20, 21, 22, 23, 24, 26, 27, 28, 29, 30 },
			{ 12, 14, 16, 18, 20, 25, 26, 27, 28, 29, 32, 33, 34, 35, 36 },
			{ 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 33, 36, 39, 42, 44 } };

	// other variables specific for each Biomon class
	public int calculateMaxHP() {
		return (10 + 5 * level);
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getInitiative() {
		return 3 + level / 5;
	}

	public String printType() {
		return "fluffy";
	}

	// normal attack and special attack

	public int normalAttack() {
		super();
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
		if (enemy instanceof SlimyBiomon) {
			// not effective against slimy
			damage = stats[2][level] * 5 / 10;
		} else if (enemy instanceof CrispyBiomon) {
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

	public FluffyBiomon() {
		super();
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

	public FluffyBiomon(int level) {
		super(level);
		maxHP = calculateMaxHP();
		currentHP = maxHP;
	}

}
