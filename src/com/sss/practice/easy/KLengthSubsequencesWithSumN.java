package com.sss.practice.easy;

import java.util.ArrayList;
import java.util.List;

public class KLengthSubsequencesWithSumN {
    static void findSub(int sum, int K, int N, List<Integer> temp){
        if (K == 0 && sum == 0) {
            System.out.println(temp);
            return;
        }
        if (sum <= 0 || K <= 0) {
            return;
        }
        for (int i = 1; i <= N; i++) {
            temp.add(i);
            findSub(sum - i, K - 1, N, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        findSub(5, 3, 5, temp);
    }
}
