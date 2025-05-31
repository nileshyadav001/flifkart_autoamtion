package KishonSir;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// Declaration
		ArrayList list = new ArrayList();
		// Adding values to array list
		list.add("welcome");
		list.add(100);
		list.add(10.5);
		list.add('C');
		list.add(true);
		System.out.println(list.size()); // size of arraylist
		System.out.println(list.get(2)); // returns specific value from array list, index starts from 0
		System.out.println("Before inserting:" + list); // print all the values from arraylist
		// Insert values into araylist
		list.add(1, "selenium");
		System.out.println("After insertion:" + list);
		// remove values from arraylist
		list.remove(3);
		System.out.println("After remove:" + list);
		// reading values from array list usign for loop
		for (Object i : list)
		{
		System.out.println(i);
		}
		}

	}


