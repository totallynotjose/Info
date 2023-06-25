package biomon;

public class Main {

	public static void main(String[] args) {
		boolean game = true; // game runs while true

		// choose type of Biomon, start with level (index) 0
		Biomon myBiomon = new Biomon(Biomon.chooseMyType(), 0);
		System.out.println("My Biomon is type " + myBiomon.printType() + " and level " + myBiomon.printLevel() + " .");
		System.out.println();

		do {
			// starts fight, ends if either Biomon has 0 (or less) HP
			Fight.ThisFight(myBiomon, new Biomon(myBiomon.getLevel()));

			// depending on who won the game is ended or your Biomon levels up and you can
			// start the next fight
			if (myBiomon.getCurrentHP() > 0) {
				myBiomon.levelUp();

				// TODO add saving and back to main screen here!
				game = Fight.nextFight();
			} else {
				System.out.println("You lost :(");
				game = false;
			}

		} while (game == true);
		System.out.println("The game has ended.");

	}
}
