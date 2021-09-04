package com.sss.practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class ValidParanthesis {
	public static void main(String[] args) {
		int n = 3;
		List<String> list = new ArrayList<String>();
		backtrack(n, 0, 0, list, "");
		list.forEach(x -> System.out.println(x));
	}

	private static void backtrack(int n, int i, int j, List<String> list, String s) {
		if (s.length() == 2 * n) {
			list.add(s);
			return;
		}
		if (i < n) {
			backtrack(n, i + 1, j, list, s + "(");
		}
		if (j < i) {
			backtrack(n, i, j + 1, list, s + ")");
		}
	}
}
