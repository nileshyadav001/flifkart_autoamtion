package Polymorphism;

public class Hiding extends R {
	public static void m1() {
		System.out.println("I am m1 from Hiding");// hiding and R common method is m1 
	}
	
	public static void main(String[] args) {
		Hiding dt=new Hiding() ;
     // dt.
	}

}
 class R{
	 public static void m1() {
		 
		 System.out.println("I am m1 from the A class");
	 }
 }
