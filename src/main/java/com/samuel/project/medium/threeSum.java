package com.samuel.project.medium;

import java.util.*;

public class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> temp = new HashSet<List<Integer>>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = a + nums[j] + nums[k];
                if (sum == 0) {
                    temp.add(Arrays.asList(a, nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        ans.addAll(temp);
        return ans;
    }

    public List<List<Integer>> mostVotesSolutions(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }

    public static void main(String[] args) {

    }
}
