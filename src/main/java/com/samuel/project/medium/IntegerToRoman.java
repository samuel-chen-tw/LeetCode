package com.samuel.project.medium;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer[] i = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int a = 0; a < s.length; a++) {
            while (num >= i[a]) {
                num -= i[a];
                ans.append(s[a]);
            }
        }
        return ans.toString();
    }

    public static String mostVotesSulotions(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        int input = 1994;
        String result = intToRoman(input);
        System.out.println(result);
    }
}