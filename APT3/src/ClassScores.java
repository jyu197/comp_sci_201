import java.util.Arrays;
import java.util.LinkedList;

public class ClassScores {
	
	public int[] findMode(int[] scores) {
		Arrays.sort(scores);
		LinkedList<Integer> modes = new LinkedList<Integer>();
		int streakStart = 0;
		int currentStreak;
		int longestStreak = 1;
		if (scores.length == 1) {
			return scores;
		}
		for (int i = 1; i < scores.length; i++) {
			currentStreak = i - streakStart;
			if (scores[i] == scores[streakStart]) {
				if (i != scores.length - 1) {
					continue;
				}
				else {
					currentStreak++;
				}
			}
			if (currentStreak > longestStreak) {
				modes.clear();
			}
			if (currentStreak >= longestStreak) {
				modes.add(scores[streakStart]);
				longestStreak = currentStreak;
			}
			if (i == scores.length - 1) {
				if (longestStreak == 1) {
					modes.add(scores[i]);
				}
			}
			streakStart = i;
		}
		int[] results = new int[modes.size()];
		for (int i = 0; i < modes.size(); i++) {
			results[i] = modes.get(i);
		}
		return results;
	}
	
}
