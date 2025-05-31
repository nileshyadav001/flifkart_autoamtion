package Reverse_Programing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InterviewCode {
//1)print the start with s end with ing
	public static void main(String[] args) {
		String str="Sita is a singing a song";
		String [] sentence=str.toLowerCase().split(" ");
		for(String sentences:sentence) {
		if(sentences.startsWith("s")||sentences.endsWith("ing")) {
			System.out.println("word:  "+sentences);
		}
		
	}
		System.out.println();
		decendent();
		addArray();
		swappingTwoWord();
		twoNumber();
		duplicateString();
}
	//2)print the acending &decending
	public static void decendent() {
		int str[]= {23,45,78,01,20,74};
		for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; j++) {
                if (str[i] < str[j]) {
                    int inc = str[j];
                    str[j] = str[i];
                    str[i] = inc;
                }
            }
        }
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
        System.out.println();
	}
	//3)add the array number
	public static void addArray() {
		int add[]= {23,12,45,56,48,};
int adding=0;
for(int i=0;i<add.length;i++) {
	adding +=add[i];
}
System.out.println("sum of array num="+adding);
	}
	//4)swapping TwoWord
	
	public static void swappingTwoWord() {
		String a="Nilesh";
		String b="Yadav";
		a=a.concat(b);
		b=a.substring(0,a.length()-b.length());//Nilesh
		a=a.substring(b.length());//Yadav
		System.out.println("After swapping string a="+a+";b="+b);
	} 
//5)Swapping two number
public static void  twoNumber() {
	int a=10;
	int b=28;
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("After swaping a="+a+";b="+b);
	
}
//6)charectore count
public static void duplicateString() {
    String str = "mahamana express";
    Map<Character, Integer> duplicateCoun = new HashMap<>();
    char[] charArray = str.toCharArray();

    for (char ch : charArray) {
        if (duplicateCoun.containsKey(ch)) {
            duplicateCoun.put(ch, duplicateCoun.get(ch) + 1);
        } else {
            duplicateCoun.put(ch, 1);
        }
    }

    Set<Character> setcount = duplicateCoun.keySet();
    System.out.println("Duplicate characters in: \"" + str + "\"");

    for (Character c : setcount) {
        if (duplicateCoun.get(c) >= 1) {
            System.out.println(c + " : " + duplicateCoun.get(c));
        }
    }
}

}
