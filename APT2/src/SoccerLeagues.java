
public class SoccerLeagues {

	public int[] points(String[] matches) {
		int[] totalPoints = new int[matches[0].length()];
		for (int i = 0; i < totalPoints.length; i++) {
			totalPoints[i] = 0;
		}
		for (int i = 0; i < matches.length; i++) {
			for (int j = 0; j < matches[i].length(); j++) {
				if (matches[i].charAt(j) == 'W') {
					totalPoints[i] += 3;
				}
				else if (matches[i].charAt(j) == 'D') {
					totalPoints[i] += 1;
					totalPoints[j] += 1;
				}
				else if (matches[i].charAt(j) == 'L') {
					totalPoints[j] += 3;
				}
			}
		}
		return totalPoints;
	}
	
}
