package Array_Practice;

public class Array2D {

	public static void main(String[] args) {
		int a[][]= {
				{11,33,88,90},  //11 33 88 99
				                 //23 45 88
				{23,45,80,99,99} //2*2
			};
//System.out.println(a[1][a.length-1]);
for(int i=0;i<=a.length-1;i++) {
	for(int j=0;j<=a[i].length-1;j++) {
		System.out.print(a[i][j]+" ");
	}
	System.out.println();
}
}
}
