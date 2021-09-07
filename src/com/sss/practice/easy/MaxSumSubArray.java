package com.sss.practice.easy;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSumSubArray(arr));
    }

    private static int findMaxSumSubArray(int[] arr) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : arr) {
            sum += i;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
