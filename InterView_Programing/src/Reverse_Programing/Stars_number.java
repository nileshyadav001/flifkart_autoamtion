package Reverse_Programing;

public class Stars_number {

	public static void main(String[] args) {
		
		String name="er";
		int a=10;
		int b=20;
		System.out.println(name+a*b);
		System.out.println(name+a+b);
		System.out.println(a+name+b);
		//System.out.println(a*name*b);not possible
		System.out.println(a+b+name);

	 a=a+b;	
	 b=a-b;
	 a=a-b;
	 System.out.println("a="+a);
	 System.out.println("b="+b);
	}

}
