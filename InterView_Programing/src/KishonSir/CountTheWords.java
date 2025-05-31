package KishonSir;

import java.util.Scanner;

public class CountTheWords {
    public static void main(String[] args) {
        System.out.println("Enter the string:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim(); // Remove leading and trailing spaces

        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if ((s.charAt(i) == ' ') && (s.charAt(i + 1) != ' ')) {
                count++;
            }
        }

        if (s.length() > 0) {
            count++; // count first word
        }

        System.out.println("Number of words in the string = " + count);
    }
}

