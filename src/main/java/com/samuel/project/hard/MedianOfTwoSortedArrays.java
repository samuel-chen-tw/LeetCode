package com.samuel.project.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> allNum = new ArrayList<Integer>();
        double ans = 0.0;
        for (int i = 0; i < nums1.length; i++) {
            allNum.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            allNum.add(nums2[j]);
        }
        Collections.sort(allNum);
        int size = allNum.size();
        if (size % 2 == 0) {
            ans = (allNum.get(size / 2 - 1) + allNum.get(size / 2)) / 2.0;
        } else {
            ans = allNum.get((int) Math.ceil(size / 2));
        }
        return ans;
    }

    public static double mostVotesFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] new_arr = new int[n];

        int i = 0, j = 0, k = 0;

        while (i <= n1 && j <= n2) {
            if (i == n1) {
                while (j < n2) new_arr[k++] = nums2[j++];
                break;
            } else if (j == n2) {
                while (i < n1) new_arr[k++] = nums1[i++];
                break;
            }

            if (nums1[i] < nums2[j]) {
                new_arr[k++] = nums1[i++];
            } else {
                new_arr[k++] = nums2[j++];
            }
        }

        if (n % 2 == 0) return (float) (new_arr[n / 2 - 1] + new_arr[n / 2]) / 2;
        else return new_arr[n / 2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }
}
