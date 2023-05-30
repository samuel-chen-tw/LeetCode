package com.samuel.project.medium;

public class ZigzagConversion {

    class Solution {
        public String convert(String s, int numRows) {
            StringBuffer ans = new StringBuffer();
            int len = s.length();
            if (len <= 2 || numRows == 1 || len < numRows) {
                return s;
            }
            for (int i = 0; i < numRows; i++) {
                ans.append(s.substring(i, i + 1)); // first column
                int range = numRows * 2 - 2;
                int increase = range;
                while ((i == 0 || i == numRows - 1) && i + increase < len) { // first row and last row
                    ans.append(s.substring(increase + i, increase + i + 1));
                    increase += range;
                }

                int sectionA = range - (i * 2);
                int sectionB = range - sectionA;
                increase = sectionA;
                while ((i > 0 && i < numRows - 1) && i + increase < len) {
                    ans.append(s.substring(increase + i, increase + i + 1));
                    if (increase % range == 0) {
                        increase += sectionA;
                    } else {
                        increase += sectionB;
                    }
                }

            }
            System.gc();
            return ans.toString();
        }
    }

    class MostVotesSolution {
        public String convert(String s, int nRows) {
            char[] c = s.toCharArray();
            int len = c.length;
            StringBuffer[] sb = new StringBuffer[nRows];
            for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

            int i = 0;
            while (i < len) {
                for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                    sb[idx].append(c[i++]);
                for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                    sb[idx].append(c[i++]);
            }
            for (int idx = 1; idx < sb.length; idx++)
                sb[0].append(sb[idx]);
            return sb[0].toString();
        }
    }

    public void main(String[] args) {
        String test = "PAYPALISHIRING";
        int num = 4;
        Solution solution = new Solution();
        String result = solution.convert(test, num);
        System.out.println(result);

    }
}
