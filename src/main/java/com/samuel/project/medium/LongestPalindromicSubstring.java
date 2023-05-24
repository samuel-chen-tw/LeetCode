package com.samuel.project.medium;

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String ans = "";
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            String frontChar = s.substring(i, i + 1);
            int lastIndex = s.length();
            while (lastIndex > i) {
                if (frontChar.equals(s.substring(lastIndex - 1, lastIndex))) {
                    String tempString = s.substring(i, lastIndex);
                    StringBuilder sb = new StringBuilder();
                    sb.append(tempString);
                    sb.reverse();
                    if (sb.toString().equals(tempString)) {
                        if (ans.length() < sb.length()) {
                            ans = sb.toString();
                        }
                        break;
                    } else {
                        lastIndex -= 1;
                    }
                } else {
                    lastIndex -= 1;
                }
            }
        }
        return ans;
    }

    public class MostVotesSolution {
        private int lo, maxLen;   //lo is used to track the starting index of the longest palindrome, maxLen is the length of the longest palindrome

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s; //if 0 or 1 chars, return the input string, no palindrome to be checked for

            for (int i = 0; i < len - 1; i++) {
                extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible. example " aba"
                extendPalindrome(s, i, i + 1); //assume even length. example "abba"
            }
            return s.substring(lo, lo + maxLen); // return the part of the input string starting at the "lo" index, length of maxLen
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) { //check if the chars at indexes j and k are the same (condition for palindrome)
                //while we have a palindrome, "extend" the length of the string being checked by decreasing the value of the beginning char index "j",
                //and increasing the value of ending char index "k"
                j--;
                k++;
            }
            if (maxLen < k - j - 1) { //if the length of the current palindrome (k - j - 1) is greater than the previous longest palindrome
                lo = j + 1; //store the beginning index of the palindrome
                maxLen = k - j - 1; // and how long the string is.
            }
        }
    }

    public static void main(String[] args) {
        String test = "aabbccb";
        String result = longestPalindrome(test);
        System.out.println(result);
    }
}
