package biomon;

public class Main {

	// TODO add all loops
	// TODO add methods from stats
	// TODO bring both methods (newFight and chooseOwnBiomon) to stats
	// TODO make Biomon class with fields (not 500 ints with different infos

	private static boolean newFight() {
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

	private static int chooseOwnBiomon() {
		System.out.println("Choose your Biomon! (1) fluffy (2) slimy (3) crispy");
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

	public static void main(String[] args) {

		boolean game = true; // game runs while true
		boolean fight = true; // after every fight decide if you want another one (if not game ends)
		// separation of game and fight because saving happens outside of the fight
		int fightCounter = 0;

		// choose type of Biomon (and print for checking), start with level 0
		int myLevel = 0;
		int myType = chooseOwnBiomon();
		System.out.println("Type is " + myType + " and maxHP are " + Stats.getMaxHP(myLevel, myType));
		System.out.println();

		while (game == true) {
			fightCounter++;

			// if fight == true make enemyBiomon here (HP, type and level)
			if (fight == true) {
				// type of enemy 1, 2 or 3
				int enemyType = (int) (Math.random() * (3 - 1 + 1) + 1);
				int enemyLevel = myLevel;
				System.out.println("Enemy type is " + enemyType + " and level is " + (enemyLevel + 1)
						+ " and max HP are " + Stats.getMaxHP(enemyLevel, enemyType));

				System.out.println(fightCounter + ". fight!");
			}

			while (fight == true) {
				// fight happens here
				// TODO add fight here

				System.out.println("Test");
				fight = false;
			}

			fight = newFight();
			// if no more fight also stop the game (for now, needs to be adapted)
			if (fight == false) {
				game = false;
			}
		}

	}

}
