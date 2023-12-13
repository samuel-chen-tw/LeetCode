package com.samuel.project.medium;

public class SearchInRotatedSortedArray {

    // O(log 2n)
    public static int search(int[] nums, int target) {
        int ans = 0;

        // 1. find the target range and pivot
        int right = nums.length - 1;
        int left = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i+1] < nums[i]) {
                // get the pivot and set the new range on left and right
                if (target > nums[0]) {
                    right = i;
                } else if (target < nums[0]) {
                    left = i + 1;
                } else {
                    return 0;
                }
            }
        }

        // 2. use binary search find the target
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // O(log n)
    public static int theMostVotesSolution(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1};
        int target = 3;
        int result = search(nums, target);
        System.out.println(result);
    }
}
