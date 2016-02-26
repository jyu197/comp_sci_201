import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MemberCheck {
	
	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
		HashSet<String> one = new HashSet<String>(Arrays.asList(club1));
		HashSet<String> two = new HashSet<String>(Arrays.asList(club2));
		HashSet<String> three = new HashSet<String>(Arrays.asList(club3));
		HashSet<String> dishonest = new HashSet<String>();
		one.retainAll(two);
		dishonest.addAll(new ArrayList<String>(one));
		two.retainAll(three);
		dishonest.addAll(new ArrayList<String>(two));
		three.retainAll(new HashSet<String>(Arrays.asList(club1)));
		dishonest.addAll(new ArrayList<String>(three));
		String[] cheaters = dishonest.toArray(new String[dishonest.size()]);
		Arrays.sort(cheaters);
		return cheaters;
	}
	
}
