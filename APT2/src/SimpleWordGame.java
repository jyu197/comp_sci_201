
public class SimpleWordGame {

	public int points(String[] player, String[] dictionary) {
		int score = 0;
		for (int i = 0; i < player.length; i++) {
			boolean duplicate = false;
			for (int j = 0; j <  i; j++) {
				if (player[j].equals(player[i])) {
					duplicate = true;
				}
			}
			if (duplicate == true) {
				continue;
			}
			for (int j = 0; j < dictionary.length; j++) {
				if (player[i].equals(dictionary[j])) {
					score += Math.pow(player[i].length(), 2);
					break;
				}
			}
		}
		return score;
	}
	
}
