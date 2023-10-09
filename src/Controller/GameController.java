package Controller;

import model.Biomon;
import ressources.Enums;
import services.FightService;
import services.SaveService;
import view.FightMenuView;
import view.MainMenuView;
import view.StarterChoiceMenuView;

/**
 * This class includes all the data and methods in regard to the Biomon.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class GameController {
	/**
	 * This is the current game state.
	 */
	public static Enums.RunningStates game;

	/**
	 * This is the instances of the Biomons of the player and the opponent.
	 */
	public static Biomon biomonInstance;
	public static Biomon enemyInstance;

	/**
	 * This is the instance of the fight menu.
	 */
	public static FightMenuView fightMenu;
	
	
	/**
	 * This method starts the game and prompts the user to choose a new game or continue with
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
				new StarterChoiceMenuView();
			} else {
				biomonInstance = loadGame(Enums.SaveStates.EXISTING_GAME);
			}
		}
		MainMenuView.biomonInstanceCreated = true;
		game = Enums.RunningStates.RUNNING;
		enemyInstance = new Biomon(biomonInstance.getLevel());
		fightMenu = new FightMenuView();
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
	 * This method initiates a fight between the player's Biomon and a randomly generated
	 * opponent Biomon. If the player's Biomon wins the fight, it levels up and
	 * prompts the user to save or continue the game. If the player's Biomon loses
	 * the fight, the game state is set to GAME_OVER.
	 */
	public static void fight() {
		FightService.ThisFight(biomonInstance, enemyInstance);
	}
}