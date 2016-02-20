import java.util.Arrays;
import java.util.Comparator;

public class ClientsList {
	
	public class Sorter implements Comparator<String>{
		
		public int compare (String a, String b) {
			String[] aParts = a.split(" ");
			String[] bParts = b.split(" ");
			if (aParts[1].compareTo(bParts[1]) == 0) {
				return aParts[0].compareTo(bParts[0]);
			}
			else{
				return aParts[1].compareTo(bParts[1]);
			}
		}
		
	}
	
	public String[] dataCleanup(String[] names) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].contains(", ")) {
				String[] parts = names[i].split(", ");
				names[i] = parts[1] + " " + parts[0];
			}
		}
		Arrays.sort(names, new Sorter());
		return names;
	}
	
}
