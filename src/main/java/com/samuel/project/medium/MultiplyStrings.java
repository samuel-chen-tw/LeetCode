package com.samuel.project.medium;

import java.util.Arrays;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int n1_len = num1.length();
        int n2_len = num2.length();
        int[] temp = new int[n1_len + n2_len];
        for (int i = n1_len - 1; i >= 0; i--) {
            for (int j = n2_len - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int front = i + j;
                int back = i + j + 1;
                int sum = product + temp[back];

                temp[front] += sum / 10;
                temp[back] = sum % 10;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int num : temp) {
            ans.append(num);
        }
        return (ans.charAt(0) == '0' && ans.charAt(1) == '0') ? "0" : ans.toString().replaceFirst("^0*", "");
    }

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        String result = multiply(num1, num2);
        System.out.println(result);
    }
}
