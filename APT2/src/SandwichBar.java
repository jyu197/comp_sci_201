
public class SandwichBar {

	public int whichOrder(String[] available, String[] orders) {
		for (int i = 0; i < orders.length; i++) {
			boolean makeable = true;
			String[] orderIngredients = orders[i].split(" ");
			for (int j = 0; j < orderIngredients.length; j++) {
				for (int k = 0; k < available.length; k++) {
					if (available[k].equals(orderIngredients[j])) {
						makeable = true;
						break;
					}
					makeable = false;
				}
				if (makeable == false) {
					break;
				}
			}
			if (makeable) {
				return i;
			}
		}
		return -1;
	}
	
}
