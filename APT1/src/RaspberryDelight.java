
public class RaspberryDelight {

	public int toasts(int upper_limit, int layer_count) {
		if(layer_count % upper_limit != 0) {
			return layer_count / upper_limit + 1;
		}
		else {
			return layer_count / upper_limit;
		}
	}
	
}
