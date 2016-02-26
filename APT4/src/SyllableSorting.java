import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SyllableSorting {

	public class Sorter implements Comparator<String>{
		
		public int compare(String a, String b) {
			ArrayList<String> aSyllables = new ArrayList<String>();
			ArrayList<String> bSyllables = new ArrayList<String>();
			String syllable = "" + a.charAt(0);
			ArrayList<String> vowels = new ArrayList<String>();
			vowels.add("a");
			vowels.add("e");
			vowels.add("i");
			vowels.add("o");
			vowels.add("u");
			for (int i = 1; i < a.length(); i++) {
				if (!vowels.contains(Character.toString(a.charAt(i)))) {
					if (vowels.contains(Character.toString(syllable.charAt(syllable.length() - 1)))) {
						aSyllables.add(syllable);
						syllable = "" + a.charAt(i);
						continue;
					}
				}
				syllable += a.charAt(i);
				if (i == a.length() - 1) {
					aSyllables.add(syllable);
				}
			}
			syllable = "" + b.charAt(0);
			for (int i = 1; i < b.length(); i++) {
				if (!vowels.contains(Character.toString(b.charAt(i)))) {
					if (vowels.contains(Character.toString(syllable.charAt(syllable.length() - 1)))) {
						bSyllables.add(syllable);
						syllable = "" + b.charAt(i);
						continue;
					}
				}
				syllable += b.charAt(i);
				if (i == b.length() - 1) {
					bSyllables.add(syllable);
				}
			}
			int tiebreaker = 0;
			int last = Math.min(aSyllables.size(), bSyllables.size());
			for (int i = 0; i < last; i++) {
				int comparison = aSyllables.get(i).compareTo(bSyllables.get(i));
				if (comparison != 0) {
					tiebreaker = comparison;
					break;
				}
			}
			Collections.sort(aSyllables);
			Collections.sort(bSyllables);
			for (int i = 0; i < last; i++) {
				int comparison = aSyllables.get(i).compareTo(bSyllables.get(i));
				if (comparison != 0) {
					return comparison;
				}
			}
			if (aSyllables.size() - bSyllables.size() != 0) {
				return aSyllables.size() - bSyllables.size();
			}
			return tiebreaker;
		}
		
	}
	
	public String[] sortWords(String[] words) {
		Arrays.sort(words, new Sorter());
		return words;
	}
	
}
