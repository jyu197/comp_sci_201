
public class DNAMutate {

	public String mutate(String data) {
		String reversed = "";
		for(int i = data.length() - 1; i >= 0; i--) {
			reversed += data.charAt(i);
		}
		return reversed;
	}
	
}
