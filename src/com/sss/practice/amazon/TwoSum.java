package com.sss.practice.amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 11, 15 };
		int target = 17;
		int[] ans = returnTwoSum(arr, target);
		for (int an : ans) {
			System.out.println(an);
		}
	}

	private static int[] returnTwoSum(int[] nums, int target) {
		int[] ans = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(target - nums[i], i);
			} else {
				ans[0] = map.get(nums[i]);
				ans[1] = i;
			}
		}
		return ans;
	}

}
