package biomon;

// here all things regarding the fights will be handled 

public class Fight {
	// who starts the fight (initiative)
	// alternating turns
	// choose attack
	// random attack of enemy
	// calculate damage dealt (for either attack)
	// fight has to stop when either HP drops to 0 or less
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

	public static void ThisFight(Biomon myBiomon, Biomon enemyBiomon) {
		// as you level up with each fight your level is an indicator for the amounts of
		// fights you had
		System.out.println(myBiomon.printLevel() + ". fight!");
		System.out.println("Test fight");
	}

}
