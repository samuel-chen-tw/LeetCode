package com.samuel.project.medium;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1. 從右到左找出第一個 nums[i] < nums[i+1]  ex: 23651 > 2[36]51
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) { // 處理陣列長度小於3或已經為最大值的陣列
            // 2. 從右往左找出第一個比 nums[i] 大的數字(nums[j]) ex: 2[3]6[5]1
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }

            // 3. nums[i] 和 nums[j] 互換 ex: 2[3]6[5]1 > 2[5]6[3]1
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 4. 反轉 i+1 之後的數字 ex: 25[631] > 25136
        Arrays.sort(nums, i + 1, nums.length);
    }

    public static void mostVotesSolution(int[] nums) {
        int ind1=-1;
        int ind2=-1;
        // step 1 find breaking point
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind1=i;
                break;
            }
        }
        // if there is no breaking  point
        if(ind1==-1){
            reverse(nums,0);
        }

        else{
            // step 2 find next greater element and swap with ind2
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[ind1]){
                    ind2=i;
                    break;
                }
            }

            swap(nums,ind1,ind2);
            // step 3 reverse the rest right half
            reverse(nums,ind1+1);
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Arrays.stream(nums).forEach(num -> {
            System.out.print(num + " ");
        });
        System.out.println(" ");
        nextPermutation(nums);
        Arrays.stream(nums).forEach(num -> {
            System.out.print(num + " ");
        });
    }
}
