package biomon;

public class Main {

	// TODO add all loops
	// TODO add methods from stats

	private static boolean newFight() {
		System.out.println("Do you want to start the  next fight? (1) yes (2) no");
		int decision = SystemInReader.readInt();
		while (decision < 1 || decision > 2) {
			System.out.println();
			System.out.println("Invalid input, please try again: (1) yes (2) no");
		}
		if (decision == 1) {
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args) {

		boolean game = true; // game runs while true
		boolean fight = true; // after every fight decide if you want another one (if not game ends)
		// separation of game and fight because saving happens outside of the fight

		int fightCounter = 0;

		while (game == true) {
			fightCounter++;

			System.out.println(fightCounter + ". fight!");
			// TODO print stats here

			while (fight == true) {
				// fight happens here
				// TODO add fight here
			}
			
			fight = newFight();
		}

	}

}
