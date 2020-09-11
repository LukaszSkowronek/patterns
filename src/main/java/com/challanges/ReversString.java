package com.challanges;

public class ReversString {

    public static void main(String[] args) {
        String s = "dupa";
        System.out.println(reverseString(s));
    }

    private static String reverseString(String s) {
        String reversedString = "";
        for (int i = 0; i < s.length(); i++) {
            reversedString = reversedString + s.charAt(s.length() - 1 -i);
        }
        return reversedString;
    }
}
