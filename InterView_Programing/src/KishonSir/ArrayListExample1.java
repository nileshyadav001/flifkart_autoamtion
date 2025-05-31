package KishonSir;

import java.util.ArrayList;

public class ArrayListExample1 {
	public static void main(String[] args)
	{
	// Declaration
		ArrayList<String> list = new ArrayList<String>();
	// Add values to arraylist
	list.add("John");
	list.add("David");
	list.add("Scott");
	list.add("Smith");
	System.out.println(list.size()); // returns size of arraylist

	// reading values from arraylist
	for (String s : list)
	{
	System.out.println(s);
	}
	}
}
