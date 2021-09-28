package com.sss.practice.dppattern;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (int coin: coins) {
                if (i >= coin && dp[i- coin] != -1) {
                    temp = Math.min(dp[i - coin], temp);
                }
            }
            dp[i] = (temp == Integer.MAX_VALUE) ? -1: temp + 1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }
}
