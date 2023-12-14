package com.samuel.project.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = {-1, -1};

        while (right >= left) {
            if (nums[left] == target && nums[right] == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            }
            if (nums[left] < target) {
                left++;
            }
            if (nums[right] > target) {
                right--;
            }

        }
        return ans;
    }

    public static int[] mostVotesSolution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                last = mid;
                while (first > 0 && nums[first - 1] == target) {
                    first--;
                }
                while (last < nums.length - 1 && nums[last + 1] == target) {
                    last++;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;
        int[] result = searchRange(nums, target);
        System.out.println("========");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
