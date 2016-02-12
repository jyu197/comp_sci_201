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
		String[] data = names.clone();
		for (int i = 0; i < data.length; i++) {
			if (data[i].contains(", ")) {
				String[] parts = data[i].split(", ");
				data[i] = parts[1] + " " + parts[0];
			}
		}
		Arrays.sort(data, new Sorter());
		return data;
	}
	
}
