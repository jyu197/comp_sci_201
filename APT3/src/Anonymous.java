
public class Anonymous {
	
	public int howMany(String[] headlines, String[] messages) {
		int num = messages.length;
		for (String message : messages) {
			String letters = "";
			for (String headline : headlines) {
				letters = letters + headline.toLowerCase().replaceAll(" ", "");
			}
			message = message.toLowerCase().replaceAll(" ", "");
			for (int i = 0; i < message.length(); i++) {
				int index = letters.indexOf(message.charAt(i));
				if (index != -1) {
					letters = letters.substring(0, index) + letters.substring(index + 1, letters.length());
				}
				else{
					num--;
					break;
				}
			}
		}
		return num;
	}
	
}
