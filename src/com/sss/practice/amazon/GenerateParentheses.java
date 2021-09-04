package com.sss.practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		int n = 2;
		List<String> list = printAllParantheses(n);
		System.out.println(list);
	}

	private static List<String> printAllParantheses(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(n, 0, 0, list, "");
		return list;
	}

	private static void backtrack(int n, int l, int r, List<String> list, String s) {
		int length = s.length();
		if (length == 2*n) {
			list.add(s);
			return;
		}
		if (l < n) {
			backtrack(n, l + 1, r, list, s + "(");
		}
		if (r < l) {
			backtrack(n, l, r + 1, list, s + ")");
		}
	}

}
