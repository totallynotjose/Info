package biomon;

import biomon.services.SaveService;
import gui.FightMenu;
import gui.MainMenu;
import gui.StarterChoiceMenu;

public class Game {
	/**
	 * The current game state.
	 */
	public static Enums.RunningStates game;

	/**
	 * The instance of the Biomon and enemy characters in the game.
	 */
	public static Biomon biomonInstance;
	public static Biomon enemyInstance;

	/**
	 * The instance of the fight menu.
	 */
	public static FightMenu fightMenu;
	
	
	/**
	 * Starts the game and prompts the user to choose a new game or continue with
	 * their progress. It initializes the Biomon instance based on the user's choice
	 * and sets the game state to running.
	 */

	public static void startGame(int gameInput) {

		if (gameInput == 1) {
			biomonInstance = new Biomon(gameInput, 0);
		} else if (gameInput == 2) {
			biomonInstance = new Biomon(gameInput, 0);
		} else if (gameInput == 3) {
			biomonInstance = new Biomon(gameInput, 0);
		} else {
			if (!SaveService.isBiomonSaveFileExisting()) {
				new StarterChoiceMenu();
			} else {
				biomonInstance = loadGame(Enums.SaveStates.EXISTING_GAME);
			}
		}
		MainMenu.biomonInstanceCreated = true;
		game = Enums.RunningStates.RUNNING;
		enemyInstance = new Biomon(biomonInstance.getLevel());
		fightMenu = new FightMenu();
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
		case NEW_GAME -> new Biomon(0, 0);
		case EXISTING_GAME -> SaveService.readBiomonFromFile();
		};
	}

	/**
	 * Initiates a fight between the player's Biomon and a randomly generated
	 * opponent Biomon. If the player's Biomon wins the fight, it levels up and
	 * prompts the user to save or continue the game. If the player's Biomon loses
	 * the fight, the game state is set to GAME_OVER.
	 */
	public static void fight() {
		//enemyInstance = new Biomon(biomonInstance.getLevel());
		Fight.ThisFight(biomonInstance, enemyInstance);

		/*if (biomonInstance.getCurrentHP() > 0) {
			biomonInstance.levelUp();

			saveOrContinueGame();
		} else {
			new GameOver();
			game = Enums.RunningStates.GAME_OVER;
		}*/
	}

	/**
	 * Prompts the user to save their progress and return to the main screen. The
	 * user's choice determines whether the game state is set to PAUSE or the game
	 * is restarted.
	 */
	/* public static void saveOrContinueGame() {
		System.out.println("Do u want to save your progress and return to the main screen? (1) yes (2) no");

		int saveInput = SystemInReader.readInt();

		if (saveInput == 1) {
			SaveService.saveBiomonToFile(biomonInstance);
			game = Enums.RunningStates.PAUSE;
			new MainMenu();
		} else { 
			game = Enums.RunningStates.RUNNING;
			enemyInstance = new Biomon(biomonInstance.getLevel());
			new FightMenu();
		}
	}*/ 
}