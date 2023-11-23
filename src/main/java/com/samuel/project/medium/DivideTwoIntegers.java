package com.samuel.project.medium;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // dividend 最小且除數是 -1 會超出最大值
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE; // dividend 最小且除數是 1 dividend絕對值會超出最大值
        // -2^31 ~ 2^31-1
        int ans = 0;
        boolean negative = dividend < 0 ^ divisor < 0; // XOR 互斥會是true

        long lDividend = Math.abs((long)dividend);
        long lDivisor = Math.abs((long)divisor);
        while (lDividend >= lDivisor) {
            lDividend -= lDivisor;
            ans++;
        }
        return negative ? (int)-ans : (int)ans;
    }

    public static int mostVotesSolution(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow

        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        int result = divide(dividend, divisor);
        System.out.println(result);
    }
}
