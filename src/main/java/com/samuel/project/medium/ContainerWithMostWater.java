package com.samuel.project.medium;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
//        int ans = 0;
//        for (int i = 0; i < height.length; i++) {
//            int j = i + 1;
//            while (j < height.length) {
//                int temp = (height[i] > height[j] ? height[j] : height[i]) * (j - i);
//                ans = temp > ans ? temp : ans;
//                j++;
//            }
//        }

        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int area = Math.min(left, right) * (j - i);
            if (ans < area) ans = area;
            if (left > right) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

    public static int mostVotesMaxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            max = Math.max(max, area);
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = maxArea(input);
        System.out.println(result);
    }
}
