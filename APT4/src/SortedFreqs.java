import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class SortedFreqs {
	
	public int[] freqs(String[] data) {
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
		Arrays.sort(data);
		int[] results = new int[data.length];
		for (int i = 0; i < data.length; i++) {
			results[i] = freqs.get(data[i]);
		}
		return results;
	}
	
}
