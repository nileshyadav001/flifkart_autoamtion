package Polymorphism;

public class Concreat_method {

	
	
	public void m4() {
		System.out.println("Hellow I am main method");
	}
	}


class A{
	public void add(int a, int b) {
		int result=a+b;
		
		System.out.println(result+"A");
		
	}
	
}
class B extends A{
	
public static void main(String[] args) {
	
	A s=new B();
	s.add(45,9);
	}
	@Override

public void add(int a, int b) {
	
	System.out.println(a+b+"B");
	
}
	
}
