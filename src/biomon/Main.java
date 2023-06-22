package biomon;

public class Main {

	// TODO add all loops
	// TODO add methods from stats
	// TODO bring newFight to stats
	// TODO make class where questions about fight will be dealt with

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

	public static void main(String[] args) {

		boolean game = true; // game runs while true
		boolean fight = true; // after every fight decide if you want another one (if not game ends)
		// separation of game and fight because saving happens outside of the fight

		// choose type of Biomon (and print for checking), start with level (index) 0
		Biomon myBiomon = new Biomon(Biomon.chooseMyType(), 0);
		System.out.println("My Biomon is type " + myBiomon.getType() + " and Level " + myBiomon.printLevel()
				+ " and my maxHP are " + myBiomon.getMaxHP());
		System.out.println();

		while (game == true) {

			// if fight == true make enemyBiomon here (HP, type and level)
			if (fight == true) {
				// type of enemy 1, 2 or 3
				Biomon enemyBiomon = new Biomon(2, myBiomon.getLevel());

				// as you level up with each fight your level is an indicator for the amounts of
				// fights you had
				System.out.println(myBiomon.printLevel() + ". fight!");
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
