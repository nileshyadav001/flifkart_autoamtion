package Array_Practice;

public class ImportentArray {

	public static void main(String[] args) {
		int a[]= {12,34,25,67,78};
		System.out.println(a.length);
		System.out.println(a[2]);
		//System.out.println(a[a.length]);
		
		for(int i=0;i<=a.length-1;i++) {
			System.out.println(a[i]);
		}
		duobleDimension();

	}
	
	public static void duobleDimension() {
	    // Declare and initialize 2D array
	    int[][] a = {
	        {12, 45, 34, 55},
	        {123, 455, 667},
	        {12, 45, 9}
	    };

	    // Print row count
	    System.out.println("Row count: " + a.length);

	    // Print column count of first row
	    System.out.println("Column count of row 0: " + a[0].length);

	    // Print specific elements
	    System.out.println("Element at a[0][2]: " + a[0][2]);
	    System.err.println("Element at a[2][2]: " + a[2][2]);

	    // Print first column elements of each row
	    System.out.println("First column values:");
	    for (int i = 0; i < a.length; i++) {
	        System.out.println(a[0][i]);
	    }
	    System.out.println("First row values:");
	    for (int j = 0; j < a[0].length; j++) {
	        System.out.println(a[0][j]);
	    }

	}

		
	}


