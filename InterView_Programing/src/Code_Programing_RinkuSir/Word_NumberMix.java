package Code_Programing_RinkuSir;

public class Word_NumberMix {

	public static void main(String[] args) {
		A12b34c56();
		
		String str="abcd";
		int num=1234;
		String st=String.valueOf(num);
		String result="";
		for(int i=0;i<=st.length()-1;i++) {
			result+=str.charAt(i);
			result+=st.charAt(i);
			
		}
System.out.println("output= "+result);
	}
	
	static void A12b34c56() {

		        String str = "abc";
		        int num = 123456;
		        String st=String.valueOf(num);
		        String result = "";

		        int numIndex = 0;

		        for (int i = 0; i <=str.length()-1; i++) {
		            result += str.charAt(i); 
		            if (numIndex <= st.length()) {
		                result += st.substring(numIndex, numIndex + 1); 
		                numIndex += 2;
		            }
		        }

		        System.err.println("output= "+result); 
		    }
		

	}


