package biomon;

import biomon.services.SaveService;

public class Game {
	/**
	 * The current game state.
	 */
	public static Enums.RunningStates game;

	/**
	 * The instance of the Biomon character in the game.
	 */
	public static Biomon biomonInstance;

	/**
	 * Starts the game and prompts the user to choose a new game or continue with
	 * their progress. It initializes the Biomon instance based on the user's choice
	 * and sets the game state to running.
	 */
	public static void startGame() {
		System.out.println("Do you want to start a new game or continue with your progress? (1) new (2) continue");
		int gameInput = SystemInReader.readInt();

		if (gameInput == 1) {
			biomonInstance = loadGame(Enums.SaveStates.NEW_GAME);
		} else if (gameInput == 2) {
			if (!SaveService.isBiomonSaveFileExisting()) {
				System.out.println("There is no save file. Please create a new game");
				startGame();
			}
			biomonInstance = loadGame(Enums.SaveStates.EXISTING_GAME);
		} else {
			System.out.println("Invalid Input. Please enter a valid number.");
			startGame();
		}
		game = Enums.RunningStates.RUNNING;
	}

	/**
	 * Loads the Biomon instance based on the specified save state.
	 *
	 * @param saveState The save state to load the Biomon from (new game or existing
	 *                  game).
	 * @return The loaded Biomon instance.
	 */
	public static Biomon loadGame(Enums.SaveStates saveState) {
		return switch (saveState) {
		case NEW_GAME: int type = Biomon.chooseMyType();
		if (type == 1) {
			new FluffyBiomon();
		}
		else if (type == 2) {
			new SlimyBiomon();
		}
		else {
			new CrispyBiomon();
		}
		
		
		/*switch (Biomon.chooseMyType()) {
		case 1:
			new FluffyBiomon();
			break;
		case 2:
			new SlimyBiomon();
			break;
		case 3:
			new CrispyBiomon();
			break;
		default:
			break;
		};*/
		break;
		// new Biomon();
		case EXISTING_GAME: SaveService.readBiomonFromFile();
		break;
		};
	}

	/**
	 * Displays the current Biomon's type and level. The Biomon instance should be
	 * initialized before calling this method.
	 */
	public static void writeCurrentBiomonStats() {
		System.out.println(
				"My Biomon is type " + biomonInstance.printType() + " and level " + biomonInstance.printLevel() + " .");
		System.out.println();
	}

	/**
	 * Initiates a fight between the player's Biomon and a randomly generated
	 * opponent Biomon. If the player's Biomon wins the fight, it levels up and
	 * prompts the user to save or continue the game. If the player's Biomon loses
	 * the fight, the game state is set to GAME_OVER.
	 */
	public static void fight() {
		Fight.ThisFight(biomonInstance, new Biomon(biomonInstance.getLevel()));

		if (biomonInstance.getCurrentHP() > 0) {
			biomonInstance.levelUp();

			saveOrContinueGame();
		} else {
			System.out.println("You lost :(");
			game = Enums.RunningStates.GAME_OVER;
		}
	}

	/**
	 * Prompts the user to save their progress and return to the main screen. The
	 * user's choice determines whether the game state is set to PAUSE or the game
	 * is restarted.
	 */
	public static void saveOrContinueGame() {
		System.out.println("Do u want to save your progress and return to the main screen? (1) yes (2) no");

		int saveInput = SystemInReader.readInt();

		if (saveInput == 1) {
			SaveService.saveBiomonToFile(biomonInstance);
			game = Enums.RunningStates.PAUSE;
			startGame();
		}
	}
}