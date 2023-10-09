package services;

import Controller.GameController;
import model.Biomon;
import ressources.Enums;
import view.FightMenuView;
import view.GameOverView;
import view.SaveOrContinueView;

/**
 * This class includes all the methods regarding battles.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class FightService {

	public static int myAttack;

	/**
	 * This method represents the player's Biomon's attack.
	 * The player can choose between normal and special attacks as well as healing.
	 */
	private static void myAttack(Biomon myBiomon, Biomon enemyBiomon, int attack) {
		switch (attack) {
		case 1:
			enemyBiomon.setCurrentHP(myBiomon.normalAttack());
			break;
		case 2:
			enemyBiomon.setCurrentHP(myBiomon.specialAttack(enemyBiomon.getType()));
			break;
		case 3:
			myBiomon.heal();
			break;
		}
	}

	/**
	 * This method represents the opponent's Biomon's attack.
	 * It is chosen randomly with a higher probability to heal if the HP are low.
	 */
	private static void enemyAttack(Biomon myBiomon, Biomon enemyBiomon) {
		int attack = (int) (Math.random() * (2 + (enemyBiomon.getMaxHP() / enemyBiomon.getCurrentHP())) + 1);
		switch (attack) {
		case 1:
			myBiomon.setCurrentHP(enemyBiomon.normalAttack());
			FightMenuView.enemyattacklabel.setText("Normal attack!");
			break;
		case 2:
			myBiomon.setCurrentHP(enemyBiomon.specialAttack(myBiomon.getType()));
			FightMenuView.enemyattacklabel.setText("Special attack!");
			break;
		default:
			enemyBiomon.heal();
			FightMenuView.enemyattacklabel.setText("Heal!");
			break;
		}
	}
	
	/**
	 * This integer helps deciding whether the player's or the opponent's Biomon can attack first.
	 */
	public static int turn;
	
	/**
	 * This method returns a string consisting of the current Biomon's type and level as well as its HP.
	 */
    public static String writeCurrentBiomonStats(Biomon myBiomon) {
    	String biomonstats;
        biomonstats = "Type: " + myBiomon.printType() + " | Level: " + myBiomon.printLevel() + " | HP: " + myBiomon.getCurrentHP() + " / " + myBiomon.getMaxHP();
        return biomonstats;
    }

	/**
	 * This method regulates the sequence of events during a fight.
	 */
	public static void ThisFight(Biomon myBiomon, Biomon enemyBiomon) {
		if (myBiomon.getInitiative() > enemyBiomon.getInitiative()) {
			turn = 0;
		} else if (enemyBiomon.getInitiative() > myBiomon.getInitiative()) {
			turn = 1;
		} else {
			turn = (int) Math.random() * 10;
		}

		if ((myBiomon.getCurrentHP() > 0) && (enemyBiomon.getCurrentHP() > 0)) {
			if (turn % 2 == 0) {
				myAttack(myBiomon, enemyBiomon, myAttack);
				if (Biomon.crit == 1) {
					FightMenuView.playercritlabel.setText("Critical hit!");
				} else {
					FightMenuView.playercritlabel.setText("");
				}
				if (enemyBiomon.getCurrentHP() > 0) {
					enemyAttack(myBiomon, enemyBiomon);
					if (Biomon.crit == 1) {
						FightMenuView.enemycritlabel.setText("Critical hit!");
					} else {
						FightMenuView.enemycritlabel.setText("");
					}
				}
			} else {
				enemyAttack(myBiomon, enemyBiomon);
				if (Biomon.crit == 1) {
					FightMenuView.playercritlabel.setText("Critical hit!");
				} else {
					FightMenuView.playercritlabel.setText("");
				}
				if (myBiomon.getCurrentHP() > 0) {
					myAttack(myBiomon, enemyBiomon, myAttack);
					if (Biomon.crit == 1) {
						FightMenuView.enemycritlabel.setText("Critical hit!");
					} else {
						FightMenuView.enemycritlabel.setText("");
					}
				}
			}
			turn++;

		}

		if (myBiomon.getCurrentHP() > 0 && enemyBiomon.getCurrentHP() <= 0) {
			myBiomon.levelUp();
			GameController.fightMenu.dispose();
			GameController.game = Enums.RunningStates.PAUSE;
			new SaveOrContinueView();
			
		} else if (myBiomon.getCurrentHP() <= 0) {
			GameController.fightMenu.dispose();
			new GameOverView();
			GameController.game = Enums.RunningStates.GAME_OVER;
		}
		
	}

}

