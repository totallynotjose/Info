package biomon;

// here all things regarding the fights will be handled 

public class Fight {
	// who starts the fight (initiative)
	// random attack of enemy
	// if we won we need to level up

	// after the fight is won you can choose if you want to do another one
	public static boolean nextFight() {
		System.out.println("Do you want to start the  next fight? (1) yes (2) no");
		int decision = SystemInReader.readInt();
		while (decision < 1 || decision > 2) {
			System.out.println();
			System.out.println("Invalid input, please try again: (1) yes (2) no");
			decision = SystemInReader.readInt();
		}
		if (decision == 1) {
			return true;
		} else {
			return false;
		}
	}

	private static void myAttack(Biomon myBiomon, Biomon enemyBiomon) {
		System.out.println("1 -> basic attack; 2 -> special attack; 3 -> healing");
		int attack = SystemInReader.readInt();
		// currently not fool proof (nothing happens if you enter anything other than 1,
		// 2 or 3) -> does not matter with GUI, only in text based!

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

	private static void enemyAttack(Biomon myBiomon, Biomon enemyBiomon) {
		int attack = (int) (Math.random() * (3 - 1 + 1) + 1);
		// TODO enemy should heal less is still (almost) full HP and more when they have
		// less HP

		switch (attack) {
		case 1:
			myBiomon.setCurrentHP(enemyBiomon.normalAttack());
			break;
		case 2:
			myBiomon.setCurrentHP(enemyBiomon.specialAttack(myBiomon.getType()));
			break;
		case 3:
			enemyBiomon.heal();
			System.out.println("Healing successful!");
			break;
		}
	}

	public static void ThisFight(Biomon myBiomon, Biomon enemyBiomon) {
		// as you level up with each fight your level is an indicator for the amounts of
		// fights you had
		System.out.println(myBiomon.printLevel() + ". fight!");
		System.out.println();

		// TODO turn start value needs to be adjusted -> should depend on ini
		// turns divided in odd and even -> alternating
		int turn = 2;
		while ((myBiomon.getCurrentHP() > 0) && (enemyBiomon.getCurrentHP() > 0)) {

			// print stats before every attack
			System.out.println("My Biomon: " + myBiomon.getCurrentHP() + " HP; enemy Biomon: "
					+ enemyBiomon.getCurrentHP() + " HP");
			System.out.println();

			if (turn % 2 == 0) {
				myAttack(myBiomon, enemyBiomon);
			} else {
				enemyAttack(myBiomon, enemyBiomon);
			}
			turn++;

		}

	}

}
