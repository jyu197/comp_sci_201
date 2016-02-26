import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {

	public class Sorter implements Comparator<String> {
		
		public int compare(String a, String b) {
			if (a.split("/").length != b.split("/").length) {
				return new Integer(a.split("/").length).compareTo(b.split("/").length);
			}
			else {
				return a.compareTo(b);
			}
		}
		
	}
	
	public String[] sort(String[] dirs) {
		Arrays.sort(dirs, new Sorter());
		return dirs;
	}
	
}
