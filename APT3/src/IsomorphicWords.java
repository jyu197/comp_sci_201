import java.util.HashMap;

public class IsomorphicWords {
	
	public int countPairs(String[] words) {
		int numPairs = 0;
		for (int i = 0; i < words.length; i++) {
			HashMap<Character, Integer> iMap = new HashMap<Character, Integer>();
			for (int j = 0; j < words[i].length(); j++) {
				char ch = words[i].charAt(j);
				if (!iMap.containsKey(ch)) {
					iMap.put(ch, words[i].indexOf(ch));
				}
			}
			String iMapped = "";
			for (int j = 0; j < words[i].length(); j++) {
				iMapped += iMap.get(words[i].charAt(j));
			}
			for (int j = 0; j < words.length; j++) {
				if (i == j) {
					continue;
				}
				HashMap<Character, Integer> jMap = new HashMap<Character, Integer>();
				for (int k = 0; k < words[j].length(); k++) {
					char ch = words[j].charAt(k);
					if (!jMap.containsKey(ch)) {
						jMap.put(ch, words[j].indexOf(ch));
					}
				}
				String jMapped = "";
				for (int k = 0; k < words[j].length(); k++) {
					jMapped += jMap.get(words[j].charAt(k));
				}
				if (iMapped.equals(jMapped)) {
					numPairs++;
				}
			}
		}
		return numPairs / 2;
	}
	
}
