package com.samuel.project.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new LinkedList<>();

        for (int i = 0; i < digits.length(); i++) {
            String letter = letters[digits.charAt(i) - '0'];
            int j = 0;
            List<String> temp = new LinkedList<>();
            while (j < letter.length() && i ==0) {
                temp.add(letter.substring(j, j + 1));
                j++;
                System.out.println(temp.toString());
            }
            while (j < letter.length()) {
                for (String a : ans) {
                    temp.add(a+letter.substring(j, j + 1));
                }
                j++;
            }
            ans = temp;
            System.out.println(letter);
        }
        return ans;
    }

    public static List<String> mostVotesSolution(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length()==0) return result;

        result.add("");
        for (int i=0; i<digits.length(); i++)
            result = combine(digitletter[digits.charAt(i)-'0'],result);

        return result;
    }

    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i=0; i<digit.length(); i++)
            for (String x : l)
                result.add(x+digit.charAt(i));

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println(result.toString());
    }
}
