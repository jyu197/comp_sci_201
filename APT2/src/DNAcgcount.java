
public class DNAcgcount {
	
	public double ratio(String dna) {
		double numcg = 0;
		if (dna.length() == 0) {
			return 0.0;
		}
		for (int i = 0; i < dna.length(); i++) {
			if (dna.charAt(i) == 'c' || dna.charAt(i) == 'g') {
				numcg += 1;
			}
		}
		return numcg / dna.length();
	}
	
}
