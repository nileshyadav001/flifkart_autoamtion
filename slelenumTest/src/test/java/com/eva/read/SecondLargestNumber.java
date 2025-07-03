package com.eva.read;

public class SecondLargestNumber {

	public static void main(String[] args) {
		int a[]= {12,3,4,56,89,80};	
	int first =Integer.MIN_VALUE;
	int second=Integer.MIN_VALUE;
	for(int i=0;i<a.length;i++) {
		if(first<a[i]) {
			first=second;
			first=a[i];
		}else if(second<a[i] &&first!=a[i]) {
			second=a[i];
		}
	}
	System.out.println("Second largest number = " + second);
	}

}
