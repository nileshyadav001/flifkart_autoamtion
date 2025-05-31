package Array_Practice;

import java.util.ArrayList;


public class SingleArray {

	public static void main(String[] args) {
		//1)
	int[] a = new int[10];
     a[0]=3;
     a[4]=99;
     a[6]=100;
     a[9]=100;
     for(int i=0;i<a.length;i++) {
    	//System.out.println(a[i]); 
     }
     //2)value add
     ArrayList<Integer> list = new ArrayList<>();
     list.add(88);
     list.add(90);
     list.add(47);
     list.add(98);
     for (int value : list) {
         System.out.println(value);
     }
     arrayRevers();
      indexNotChange();
      StringNumberReverse();
      intNumberReverse();
      inArrayValueAdd();
     
    }
	//3)ReverseArray
	public static void arrayRevers() {
		int[]a= {2,4,5,0,5};
		for(int i=a.length-1;i>=0;i--) {
			System.out.print(a[i]+" ");
		}
		System.out.println(" ");
	}
	//4)Print 0 Index number is change then value not change
	public static void indexNotChange() {
		int a[]= {4,2,0,4,9,};
		for(int i=0;i<=a.length-1;i++) {
			if(a[i]==0) {
				System.out.println(a[i]);
				
			}
		}
		
	}
	//5)output=54321
	public static void intNumberReverse() {
	int a= 12345;
	int reversed=0;
	for(;a!=0;a=a/10) {
		int digit=a%10;
		reversed=reversed*10+digit;
	}
	System.err.println(reversed);
	
	}
	//6i)output=54321
	public static void StringNumberReverse() {
	String a="12345";
	String reversed="";
	for(int i=a.length()-1;i>=0;i--) {
		reversed +=a.charAt(i);
	}
	System.out.println(reversed);
	//6ii)
//	StringBuilder sb=new StringBuilder(a);//muatable
//	sb.reverse();
//	System.out.println(sb.toString());
	
}
	//7)value add
	public static void inArrayValueAdd() {
		int a[]= {6,11,3,7,9,1};
		int b[]= new int[a.length];
		for(int i=0;i<=a.length-1;i++) {
		b[i]=a[i];
		}
		for(int i=0;i<=b.length-1;i++) {
			//System.out.print(b[i]+" ");
			//7i)print the only even number 
			if(b[i]%2==0) {
				System.out.print("print the even no "+b[i]);
			}
			System.out.println();
			
			if(b[i]%2!=0) {
				System.out.print("print the odd no "+b[i]);
			}
			
		}
		System.out.println();
		
//print the maximum no.
		int maximum=b[1];
		for(int i=0;i<=a.length-1;i++) {
			if(b[i]>maximum) {
				b[i]=maximum;
			}
		}
		System.out.println("hieghest value print "+maximum);
	}
	
	
}
