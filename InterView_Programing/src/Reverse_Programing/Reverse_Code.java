package Reverse_Programing;

public class Reverse_Code {

	public static void main(String[] args) {
		
		Reverse_Code rc=new Reverse_Code();
		rc.forwordScenario();
	///Question(2) -->A)Print all the charectar one by one in reverse order
		//input expert, outtput trepxe
		
		
		String x="expert";
		int charCount=x.length();
		for(int i=charCount-1;i>=0;i--) {//loops revers opporate
			char ch=x.charAt(i);
			System.out.print(ch);
		}
		///B)
    System.out.println();//-->Taki (B) is seprate print print or System.out.println("");
		char[] chArr=x.toCharArray();
		for(int i=charCount-1;i>=0;i--){
			char ch=chArr[i];
			System.out.print(ch);
		}
		///C)
		System.out.println();
		String[] strArr=x.split("");
		for(int i=strArr.length-1;i>=0;i--) {
			String str=strArr[i];
			System.out.print(str);
		}
		
		///Question(3) -->input ="My Institute is expert view automation",  output = automation view expert Institute My
		System.out.println();
		
		String sentence="My Institute is expert view automation";
		String [] wordArr=sentence.split(" ");
		for(int i=wordArr.length-1;i>=0;i--) {
		    String word= wordArr[i];
		    System.out.print(word+" ");//Q. with character reverse uper code print then variable change into and answer
			
		}
		
		///Question(4)--> word possition is same but words charactor possition is reverse
		System.out.println();
		String [] wordArray=sentence.split(" ");
		for(int i=0;i<=wordArray.length-1;i++) {
			String word=wordArray[i];
			
			int charcout=word.length();
			for(int j=charcout-1;j>=0;j--) {
				char reverseChar=word.charAt(j);
				System.out.print(reverseChar);
			}
			System.out.print(" ");
			
		}
		///Question(5)-->input=expert ? output=erepxt
		System.out.println();
		
		String z="expertview";
		char[] chArray =z.toCharArray();
		System.out.print(chArray[0]);
		for(int i=chArray.length-2;i>=1;i--) {
			char chr=chArray[i];
			System.out.print(chr);
			
		}
		System.out.println(chArray[chArray.length-1]);
		
		///Question(6)(i)--> Uppercase change into lowercase, and lowercase change into Uppercase
		String sentencer="My Institute is expert view automation";
		String t=sentencer.toUpperCase();
		System.out.println(t);
		
		///Question(6)(ii)
String small="INSTITUTE IS EXPERT VIEW AUTOMATION";
 String g=small.toLowerCase();
		System.out.println(g);
		
		///Question(6)(iii)
		String sentenc="      Institute is expert view automation        ";
		String h=sentenc.trim();
		System.out.println(h);
		
		/////Sorting order--->A-65, Z-90, a-97 ,z
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void forwordScenario() {//Main method call then run
		String x="My Institute is expert view automation";
		///Question(1) -->A)Print all the characters one by one
		int charCount=x.length();
		for(int i=0;i<=charCount-1;i++) {
			char ch=x.charAt(i);
			System.out.println(ch);
		}
		///B)
		char[] chArr=x.toCharArray();//-->int this toCharArray() method character access the inner of array
		for(int i=0;i<=chArr.length-1;i++) {
			char ch=chArr[i];
			System.out.println(ch);
		}
		///B) or for each loop use
		//char[] chArr=x.toCharArray();
		for(char ch:chArr) {
			System.out.println(ch);
		}
		///C)
		String[] strArr=x.split("");//-->x in 3 e then 4 tukade make
		//System.out.println("");//split in one by one word print then use space, but one by one charactor print then not a space
		//String txt=strArr[4];---> Q.how to print only "view"? 1st split in use the space then 27 lines use   
		for(int i=0;i<=strArr.length-1;i++) {
			String str=strArr[i];
			System.out.println(str);
		}
	
		
	}
	
	
}
