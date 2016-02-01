
public class CountAppearances {

	public int numberTimesAppear(int number, int digit) {
		int count = 0;
		String num = Integer.toString(number);
		for (int i = 0; i < num.length(); i++) {
			if (Character.toString(num.charAt(i)).equals(Integer.toString(digit))) {
				count += 1;
			}
		}
		return count;
	}
	
}
