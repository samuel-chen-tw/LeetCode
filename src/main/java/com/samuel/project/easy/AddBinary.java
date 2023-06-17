package com.samuel.project.easy;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        if (b.length() > a.length()) {
            String c = "";
            c = a;
            a = b;
            b = c;
        }
        int b_index = b.length() - 1;
        boolean into = false;
        for (int i = a.length()-1; i >= 0; i--) {
            char a_char = a.charAt(i);
            char b_char = b_index >= 0 ? b.charAt(b_index) : '0';
            if (a_char != b_char) {
                if (into) {
                    ans.append("0");
                    into = true;
                } else {
                    ans.append("1");
                    into = false;
                }

            } else {
                if (a_char == '0' && b_char == '0') {
                    if (into) {
                        ans.append("1");
                    } else {
                        ans.append("0");
                    }
                    into = false;
                } else {
                    if (into) {
                        ans.append("1");
                    } else {
                        ans.append("0");
                    }
                    into = true;
                }
            }
            b_index--;
        }
        ans = into ? ans.append("1") : ans;
        return ans.reverse().toString();
    }

    public static String mostVotesSolutions(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String result = addBinary("11010100", "1111");
        System.out.println(result);
    }
}
