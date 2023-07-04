package biomon;

public class Main {
	public static void main(String[] args) {

		Game.startGame();

		do {

			Game.writeCurrentBiomonStats();

			Game.fight();

		} while (Game.game != Enums.RunningStates.GAME_OVER);
		System.out.println("The game has ended.");

	}
}
