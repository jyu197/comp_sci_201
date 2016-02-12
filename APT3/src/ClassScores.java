import java.util.Arrays;
import java.util.LinkedList;

public class ClassScores {
	
	public int[] findMode(int[] scores) {
		int[] data = scores.clone();
		Arrays.sort(data);
		LinkedList<Integer> modes = new LinkedList<Integer>();
		int streakStart = 0;
		int currentStreak;
		int longestStreak = 1;
		if (data.length == 1) {
			return data;
		}
		for (int i = 1; i < data.length; i++) {
			currentStreak = i - streakStart;
			if (data[i] == data[streakStart]) {
				if (i != data.length - 1) {
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
				modes.add(data[streakStart]);
				longestStreak = currentStreak;
			}
			if (i == data.length - 1) {
				if (longestStreak == 1) {
					modes.add(data[i]);
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
