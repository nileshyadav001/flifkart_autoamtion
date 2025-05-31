package Code_Programing_RinkuSir;

public class OnlyEvenWordCharactorIsChange {
	
	public  static String wordReverse(String name) {
	char charArr[]=name.toCharArray();
	name="";
	for(int i=charArr.length-1;i>=0;i--) {
		name=name +charArr[i];
	}
	return name;
	
}

	public static void main(String[] args) {
		String name="My Institute is expert view automation";
		String [] wordArr =name.split(" ");
		 
		for(int i=wordArr.length-1;i>=0;i--) {
 
			String word=wordArr[i];
			if(i%2==0) {
				word=wordReverse(wordArr[i]);
			}
			System.out.print(word+" ");
		}

	}

}
