package com.sss.practice.amazon;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int i = 0, j = height.length - 1, iMax = 0, jMax = 0, ans = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                if (iMax <= height[i]) {
                    iMax = height[i];
                } else {
                    ans += (iMax - height[i]);
                }
                i++;
            } else {
                if (jMax <= height[j]) {
                    jMax = height[j];
                } else {
                    ans += (jMax - height[j]);
                }
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr = {6, 4, 0, 2, 1};
        System.out.println(trap(arr));
    }
}
