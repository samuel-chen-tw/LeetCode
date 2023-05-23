package com.samuel.project.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int ans = 0;
        int count = 0;
        String a = "";
        String b = "";
        StringBuilder temp = new StringBuilder();
        if (size < 1) {
            return 0;
        } else {
            for (int i = 0; i <= size - 2; i++) {
                a = s.substring(i, i + 1);
                b = s.substring(i + 1, i + 2);
                temp.append(a);

                if (!a.equals(b) && temp.indexOf(b) < 0) {
                    count += 1;
                } else if (!a.equals(b) && temp.indexOf(b) >= 0) {
                    String temp_s = temp.substring(temp.indexOf(b) + 1, temp.length());
                    temp.delete(0, temp.length());
                    temp.append(temp_s);
                    count = temp.length();
                } else {
                    count = 0;
                    temp.delete(0, temp.length());
                }
                if (count > ans) {
                    ans = count;
                }
            }
            return ans + 1;
        }
    }

    public static int mostVotesLengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++)); // faster pointer
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++)); // slow pointer
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "";
        int ans = lengthOfLongestSubstring(test);
        System.out.println(ans);
    }
}
