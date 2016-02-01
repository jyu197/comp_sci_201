
public class Freefall {

	public double fallingDistance(double time, double velo) {
		return 0.5 * 9.8 * Math.pow(time, 2) + velo * time;
	}
	
}
