package com.sss.practice.amazon;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        for (int[] interval : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 4}, {0, 2}, {3, 5}
        };
        printIntervals(merge(intervals));
    }

    private static void printIntervals(int[][] merge) {
        for (int[] i: merge) {
            System.out.println(i[0] + "," + i[1]);
        }
    }
}
