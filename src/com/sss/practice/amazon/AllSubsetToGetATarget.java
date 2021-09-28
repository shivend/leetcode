package com.sss.practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetToGetATarget {
    private static void recursive(int index, int target, ArrayList<Integer> subset, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            subset.add(candidates[i]);
            recursive(i, target - candidates[i], subset, candidates, res);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {7, 2, 5};
        int target = 9;
        List<List<Integer>> res = new ArrayList<>();
        recursive(0, target, new ArrayList<>(), candidates, res);
        System.out.println(res);
    }
}
