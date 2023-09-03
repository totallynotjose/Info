package biomon;

import gui.FightMenu;

public class FightSafe {

	// after the fight is won you can choose if you want to do another fight
	public static boolean nextFight() {
		System.out.println("Do you want to start the  next fight? (1) yes (2) no");
		int decision = SystemInReader.readInt();

		while (decision < 1 || decision > 2) {
			System.out.println();
			System.out.println("Invalid input, please try again: (1) yes (2) no");
			decision = SystemInReader.readInt();
			System.out.println();
		}

		if (decision == 1) {
			return true;
		} else {
			return false;
		}
	}

	// for my attack, choose between normal attack, special attack or healing
	private static void myAttack(Biomon myBiomon, Biomon enemyBiomon) {
		System.out.println("1 -> basic attack; 2 -> special attack; 3 -> healing");
		int attack = SystemInReader.readInt();

		switch (attack) {
		case 1:
			enemyBiomon.setCurrentHP(myBiomon.normalAttack());
			break;
		case 2:
			enemyBiomon.setCurrentHP(myBiomon.specialAttack(enemyBiomon.getType()));
			break;
		case 3:
			myBiomon.heal();
			System.out.println("Healing successful!");
			break;
		}
	}

	/*
	 * for enemy Biomon the attack is chosen randomly (same choices available) enemy
	 * Biomon heals less often if it has (almost) full HP and more often when HP
	 * drop. For example: 100 maxHP and 100 currentHP -> 1; currentHP 50 -> 2;
	 * currentHP 10 -> 10. more random numbers result in a heal
	 */
	private static void enemyAttack(Biomon myBiomon, Biomon enemyBiomon) {
		int attack = (int) Math.random() * (2 + (enemyBiomon.getMaxHP() / enemyBiomon.getCurrentHP())) + 1;

		switch (attack) {
		case 1:
			myBiomon.setCurrentHP(enemyBiomon.normalAttack());
			break;
		case 2:
			myBiomon.setCurrentHP(enemyBiomon.specialAttack(myBiomon.getType()));
			break;
		default:
			enemyBiomon.heal();
			System.out.println("Healing successful!");
			break;
		}
	}

	public static void ThisFight(Biomon myBiomon, Biomon enemyBiomon) {
		// as you level up with each fight your level is an indicator for the amounts of
		// fights you had
		System.out.println(myBiomon.printLevel() + ". fight!");

		System.out.println("Enemy Biomon is " + enemyBiomon.printType() + " and level " + enemyBiomon.printLevel());
		System.out.println();

		// turns divided in odd and even -> alternating
		/*
		 * The Biomon with the higher initiative gets to start. If they have the same
		 * initiative, a random number gets picked. Turns are divided in odd and even;
		 * after every move the counter is raised by one
		 */
		int turn;
		if (myBiomon.getInitiative() > enemyBiomon.getInitiative()) {
			turn = 0;
		} else if (enemyBiomon.getInitiative() > myBiomon.getInitiative()) {
			turn = 1;
		} else {
			turn = (int) Math.random() * 10;
		}

		while ((myBiomon.getCurrentHP() > 0) && (enemyBiomon.getCurrentHP() > 0)) {

			// print current HP before every attack
			System.out.println("My Biomon: " + myBiomon.getCurrentHP() + " HP; enemy Biomon: "
					+ enemyBiomon.getCurrentHP() + " HP");
			System.out.println();

			if (turn % 2 == 0) {
				System.out.println("Your turn!");
				myAttack(myBiomon, enemyBiomon);
			} else {
				System.out.println("Enemy turn!");
				enemyAttack(myBiomon, enemyBiomon);
			}
			turn++;

		}

	}

}
