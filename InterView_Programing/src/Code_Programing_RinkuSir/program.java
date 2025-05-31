package Code_Programing_RinkuSir;

public class program {
	
	    public static void main(String[] args) {
	        String input = "A2B3C4";
	        StringBuilder output = new StringBuilder();

	        for (int i = 0; i < input.length(); i += 2) {
	            char letter = input.charAt(i);
	            int count = Character.getNumericValue(input.charAt(i + 1));
	            for (int j = 0; j < count; j++) {
	                output.append(letter);
	            }
	        }

	        System.out.println(output.toString());  // Output: AABBBCCCC
	    }
	}


