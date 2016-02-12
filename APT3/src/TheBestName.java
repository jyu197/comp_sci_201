import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {

	public class Sorter implements Comparator<String>{
		public int compare(String a, String b) {
			if (a.equals(b)) {
				return 0;
			}
			else if (a.equals("JOHN")) {
				return -1;
			}
			else if (b.equals("JOHN")) {
				return 1;
			}
			int aWeight = 0;
			int bWeight = 0;
			for (int i = 0; i < a.length(); i++) {
				aWeight += (int)a.charAt(i) - 64;
			}
			for (int i = 0; i < b.length(); i++) {
				bWeight += (int)b.charAt(i) - 64;
			}
			if (aWeight > bWeight) {
				return -1;
			}
			else if (aWeight < bWeight) {
				return 1;
			}
			else {
				return a.compareTo(b);
			}
		}
	}
	public String[] sort(String[] names) {
		String[] data = names.clone();
		Arrays.sort(data, new Sorter());
		return data;
	}
	
}
