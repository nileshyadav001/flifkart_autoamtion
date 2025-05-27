package Abstract_this_super;

  public abstract class Sample {
	  public Sample(int a) {
		  
		  System.out.println("hello");
	  }

	
	public abstract void m1();

}
   class S extends Sample{
	  public S(int s) {
		  super(4);
		System.out.println("hhihi");
	  }

	public void m1() {
		
	}
	public static void main(String[] args) {
	new S(34);
	
	  
  }
}