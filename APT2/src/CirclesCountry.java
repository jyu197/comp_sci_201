
public class CirclesCountry {

	public int leastBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
		int borders = 0;
		for (int i = 0; i < x.length; i++) {
			if (Math.pow(x[i] - x2, 2) + Math.pow(y[i] - y2,  2) <= Math.pow(r[i],  2) && Math.pow(x[i] - x1, 2) + Math.pow(y[i] - y1,  2) <= Math.pow(r[i],  2)) {
				continue;
			}
			if (Math.pow(x[i] - x1, 2) + Math.pow(y[i] - y1,  2) <= Math.pow(r[i],  2)) {
				borders++;
			}
			if (Math.pow(x[i] - x2, 2) + Math.pow(y[i] - y2,  2) <= Math.pow(r[i],  2)) {
				borders++;
			}
		}
		return borders;
	}
	
}
