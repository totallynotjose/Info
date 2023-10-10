package ressources;

/**
 * This class allows a higher level of readibilty of the abstract code by giving each
 * running state and save state a explicit name. Also the enums are applicable in the whole program.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kionkte
 */

public class Enums {
    public enum RunningStates {
        RUNNING, PAUSE, GAME_OVER
    }
    
    public enum SaveStates {
        NEW_GAME, EXISTING_GAME
    }
}