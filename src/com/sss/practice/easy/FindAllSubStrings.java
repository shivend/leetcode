package com.sss.practice.easy;

public class FindAllSubStrings {
    public static void main(String[] args) {
        findAllSubStrings("abc", "");
    }

    private static void findAllSubStrings(String str, String s) {
        if (str.length() == 0) {
            System.out.print(s + " ");
            return;
        }
        findAllSubStrings(str.substring(1), s + str.charAt(0));
        findAllSubStrings(str.substring(1), s);
    }
}
