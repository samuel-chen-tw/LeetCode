package com.samuel.project.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates, ans, new ArrayList<>(), target, 0);
        return ans;
    }

    public static void recursion(int[] candidates, List<List<Integer>> ans, List<Integer> tempArr, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(tempArr));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) continue; // skip duplicates
            tempArr.add(candidates[i]);
            recursion(candidates, ans, tempArr, target - candidates[i], i + 1);
            tempArr.remove(tempArr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        for (List<Integer> subList : result) {
            for (int num : subList) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("==========");
        }
    }
}
