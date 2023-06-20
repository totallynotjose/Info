package biomon;


public class TextBasedFirstVersion {

	public static void main(String[] args) {

		int myHP = 100;
		int enemyHP = 100;
		boolean fight = true;
		int turn = 2;

		do {
			int attack;

			// my turn if the number is even
			if ((turn % 2) == 0) {

				System.out.println("1 -> basic attack; 2 -> special attack; 3 -> healing");
				attack = SystemInReader.readInt();

				// pick one out of three moves (needs to be adapted more)
				switch (attack) {
				case 1:
					enemyHP = enemyHP - 20;
					System.out.println("normal attack, 20 damage");
					break;
				case 2:
					enemyHP = enemyHP - 40;
					System.out.println("special attack, 40 damage");
					break;
				case 3:
					myHP = myHP + 20;
					System.out.println("healed yourself");
					break;
				}

				// cannot heal over mx HP
				if (myHP > 100) {
					myHP = 100;
				}
				// cannot have less than 0 HP
				if (enemyHP < 0) {
					enemyHP = 0;
				}

				// fight ends
				if (enemyHP == 0) {
					fight = false;
				}
			}

			// if the number is odd, enemy attacks (needs adaption)
			if ((turn % 2) == 1) {
				myHP = myHP - 20;
				System.out.println("Enemy attacked, you took 20 damage");

				if (myHP < 0) {
					myHP = 0;
				}

				if (myHP == 0) {
					fight = false;
					break;
				}
			}

			// show stats after each turn
			System.out.println("Your HP: " + myHP);
			System.out.println("Enemy HP: " + enemyHP);
			System.out.println();
			
			//to make turns alternate
			turn++;

		} while (fight == true);

		//show who won
		if (myHP == 0) {
			System.out.println("You lost :(");
		}
		if (enemyHP == 0) {
			System.out.println("You won, congratulations!");
		}
		/*needs to be added:
		 * randomizer to make attacks spicier
		 * enemy needs more attacks
		 * correct outputs after attacks
		 * put shit in separate methods
		 * add loop after fight
		 * add loop after loss/when fights ended
		 * stats for us and enemy (later)
		 * evolutions (later)
		 * grafik (pls somebody help me)*/
	}

}
