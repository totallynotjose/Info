package biomon;

public class TextBasedWithStats {

	/*
	 * change enemy heal less when almost full, heal more when almost dead. Get
	 * correct HP. After defeating enemy set them back up to fullHP, heal self by
	 * 50%. Save type and level for Biomon, get all the other values (get method)
	 * set turn before every new fight
	 */

	public static void main(String[] args) {
		int myHP = 100;
		int enemyHP = 100;
		boolean fight = true;
		boolean game = true;

		int turn = 2;

		// stats only for levels 1 to 5, standard attack and special attack
		// base maxHP 10 + 5 per level over 1
		int[][] fluffy = { { 10, 12, 14, 16, 18 }, { 12, 14, 16, 18, 20 } };

		// base maxHP 20 + 5 per level over 1
		int[][] slimy = { { 10, 11, 12, 13, 14 }, { 9, 10, 10, 11, 12 } };

		// base maxHP 30 + 5 per level over 1
		int[][] crispy = { { 10, 11, 12, 13, 14 }, { 8, 10, 12, 14, 16 } };

		int myLevel = 1;
		int enemyLevel = 1;

		while (game == true) {
			System.out.println("My Biomon: crispy level " + myLevel + " ; enemy Biomon: slimy level " + enemyLevel);
			System.out.println();

			// goal: calculate damage from get method
			while (fight == true) {
				int attack;

				// my turn if the number is even
				if ((turn % 2) == 0) {

					System.out.println("1 -> basic attack; 2 -> special attack; 3 -> healing");
					attack = SystemInReader.readInt();

					// pick one out of three moves (needs to be adapted more)
					switch (attack) {
					case 1:
						enemyHP = enemyHP - crispy[0][myLevel - 1];
						System.out.println("normal attack, " + crispy[0][myLevel - 1] + " damage");
						break;
					case 2:
						enemyHP = enemyHP - crispy[1][myLevel - 1];
						System.out.println("special attack, " + crispy[1][myLevel - 1] + " damage");
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
						fight = false;
					}

				} else {

					int enemyMove = (int) (Math.random() * (3 - 1 + 1) + 1);

					switch (enemyMove) {
					// normal attack
					case 1:
						myHP = myHP - slimy[0][enemyLevel - 1];
						System.out
								.println("Enemy did a basic attack, you took " + slimy[0][enemyLevel - 1] + " damage.");
						break;
					case 2:
						myHP = myHP - slimy[1][enemyLevel - 1];
						System.out.println(
								"Enemy did a special attack, you took " + slimy[1][enemyLevel - 1] + " damage.");
						break;
					case 3:
						enemyHP = enemyHP + 20;
						if (enemyHP > 100) {
							enemyHP = 100;
						}
						System.out.println("Enemy healed themself.");
						break;
					}

					if (myHP < 0) {
						myHP = 0;
						fight = false;
					}

				}

				// show stats after each turn
				System.out.println("Your HP: " + myHP);
				System.out.println("Enemy HP: " + enemyHP);
				System.out.println();

				// to make turns alternate
				turn++;

			}

			// show who won
			if (myHP == 0) {
				System.out.println("You lost :(");
				game = false;
			} else {
				System.out.println("You won, congratulations!");
				// does not work with ++ (goes to 3 instead of 2)
				myLevel = myLevel + 1;
				enemyLevel = enemyLevel + 1;
				System.out.println(myLevel + " " + enemyLevel);
				System.out.println("Next fight? 1 yes 2 no");
				int a = SystemInReader.readInt();
				if (a == 1) {
					fight = true;
				} else {
					game = false;
				}
			}

		}
		System.out.println("game ended");
	}

}
