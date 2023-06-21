package biomon;

public class Main {

	// TODO add all loops
	// TODO add methods from stats
	// TODO test if type and max hp work

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

		int myType = chooseOwnBiomon();
		System.out.println("Type is " + myType + " and maxHP are " + Stats.getMaxHP(0, myType));
		System.out.println();

		int fightCounter = 0;

		while (game == true) {
			fightCounter++;

			System.out.println(fightCounter + ". fight!");
			// TODO print stats here

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
