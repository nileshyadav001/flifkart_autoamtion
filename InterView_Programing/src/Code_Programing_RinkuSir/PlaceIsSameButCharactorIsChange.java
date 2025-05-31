package Code_Programing_RinkuSir;

public class PlaceIsSameButCharactorIsChange {

	public static void main(String[] args) {
		
		String str = "My Institute is expert view automation";
		String reversed = "";
		String strArr[]= str.split(" ");
		for (int j = 0; j < strArr.length ; j++) {
		        char[] charArray = strArr[j].toCharArray();
		        
		        for (int i = charArray.length - 1; i >= 0; i--) {
		            reversed += charArray[i]; 
		        }reversed=reversed+" ";}
		        System.out.println(reversed);
		}
	}


