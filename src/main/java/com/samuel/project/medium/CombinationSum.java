package com.samuel.project.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        recursion(candidates, ans, new ArrayList<Integer>(), 0, target);
        return ans;
    }

    public static void recursion(int[] candidates, List<List<Integer>> ans, List<Integer> tempList, int sum, int target) {
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            int tempSum = sum + candidate;
            List<Integer> newTempList = new ArrayList<>(tempList);
            if (tempSum < target) {
                System.out.println("----");
                System.out.println(tempSum);
                System.out.println("###");
                newTempList.add(candidate);
                for (int t :newTempList) {
                    System.out.println(t);
                }
                System.out.println("----");
                recursion(candidates, ans, newTempList, tempSum, target);
            } else if (tempSum == target) {
                System.out.println("----");
                System.out.println(tempSum);
                System.out.println("###");
                newTempList.add(candidate);
                for (int t :newTempList) {
                    System.out.println(t);
                }
                System.out.println("----");
                Collections.sort(newTempList);
                if (!ans.contains(newTempList)) {
                    ans.add(newTempList);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println("====");
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("====");
        }
    }
}
