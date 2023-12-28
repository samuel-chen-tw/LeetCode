package com.samuel.project.medium;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int countStep = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = nums[i] + i;
            if (step > countStep) {
                countStep = step;
            }
            if (countStep >= nums.length - 1 || nums.length == 1) return true;
            if (nums[i] == 0 && countStep <= i) return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        boolean result = canJump(nums);
        System.out.println(result);
    }
}
