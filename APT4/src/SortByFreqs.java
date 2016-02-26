import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class SortByFreqs {
	
	public class Sorter implements Comparator<String[]> {
		
		public int compare(String[] a, String[] b) {
			if (a[1].equals(b[1])) {
				return a[0].compareTo(b[0]);
			}
			else {
				return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);
			}
		}
		
	}
	
	public String[] sort(String[] data) {
		HashMap<String, Integer> freqs = new HashMap<String, Integer>();
		for (int i = 0; i < data.length; i++) {
			if (!freqs.containsKey(data[i])) {
				freqs.put(data[i], 1);
			}
			else {
				freqs.put(data[i], freqs.get(data[i]) + 1);
			}
		}
		HashSet<String> uniques = new HashSet<String>(Arrays.asList(data));
		data = uniques.toArray(new String[uniques.size()]);
		String[][] entries = new String[data.length][2];
		for (int i = 0; i < data.length; i++) {
			entries[i][0] = data[i];
			entries[i][1] = Integer.toString(freqs.get(data[i]));
		}
		Arrays.sort(entries, new Sorter());
		for (int i = 0; i < entries.length; i++) {
			data[i] = entries[i][0];
		}
		return data;
	}

}
