/**
 * Example of printing for first discussion section
 */ 
public class Picture {
    public static void main(String[] args) {
	//TODO: Improve this method through using loops
    	/*
        System.out.println("*");
        System.out.println("**");
        System.out.println("***");
        System.out.println("****");
        System.out.println("*****");
        System.out.println("******");
        System.out.println("*******");
        System.out.println("********");
        System.out.println("*********");
        System.out.println("**********");
        */
    	for(int i = 1; i <= 10; i++){
    		for(int j = 1; j <= i; j++){
    			System.out.print("*");
    		}
    		System.out.println();
    	}
    }
}
