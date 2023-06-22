package biomon;

public class Main {

	// TODO add all loops
	// TODO add methods from stats
	// TODO bring newFight to stats
	// TODO make class where questions about fight will be dealt with

	public static void main(String[] args) {

		// TODO should game and fight be public so it could be affected by other classes
		// like fight?

		boolean game = true; // game runs while true
		boolean fight = true; // after every fight decide if you want another one (if not game ends)
		// separation of game and fight because saving happens outside of the fight

		// choose type of Biomon (and print for checking), start with level (index) 0
		Biomon myBiomon = new Biomon(Biomon.chooseMyType(), 0);
		System.out.println("My Biomon is type " + myBiomon.getType() + " and Level " + myBiomon.printLevel()
				+ " and my maxHP are " + myBiomon.getMaxHP());
		System.out.println();

		do {
			// if no more fight the game is ended
			// TODO instead add saving and back to main screen here!
			if (fight == true) {
				// starts fight, ends if either Biomon has 0 (or less) HP
				Fight.ThisFight(myBiomon, new Biomon(2, myBiomon.getLevel()));
				fight = Fight.nextFight();
			} else {
				game = false;
			}
		} while (game == true);

	}

}
