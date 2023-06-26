package com.samuel.project.medium;

import java.util.*;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int temp = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int range = Math.abs(sum - target);
                if (range < temp) {
                    temp = range;
                    ans = sum;
                }
                if (target < sum) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    public static int mostVotesSolution(int[] nums, int target) {
        Arrays.sort(nums);
        var closest = 0;

        for (int i = 0, n = nums.length, minDiff = Integer.MAX_VALUE; i < n - 2; i++)
            for (int j = i + 1, k = n - 1; j < k; ) {
                var sum = nums[i] + nums[j] + nums[k];

                if (sum == target)
                    return target;
                if (sum < target)
                    j++;
                else
                    k--;

                var diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    minDiff = diff;
                    closest = sum;
                }
            }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = -100;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }
}
