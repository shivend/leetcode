package com.sss.practice.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMazeLeeAlgo {

    private static int shortestPathBinaryMaze(int[][] mat, int[] source, int[] destination) {
        Point sourcePoint = new Point(source[0], source[1]);
        QueuePoint qP = new QueuePoint(0, sourcePoint);
        boolean[][] isVisit = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                isVisit[i][j] = false;
            }
        }
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        Queue<QueuePoint> q = new LinkedList<>();
        q.add(qP);
        isVisit[source[0]][source[1]] = true;
        while (!q.isEmpty()) {
            QueuePoint newQPoint = q.poll();
            int x = newQPoint.point.x;
            int y = newQPoint.point.y;
            int dist = newQPoint.dist;
            if (x == destination[0] && y == destination[1]) {
                return dist;
            }
            for (int i = 0; i < 4; i++) {
                int row = x + rowOffset[i];
                int col = y + colOffset[i];
                if (row >= 0 && col >= 0 && row < mat.length && col < mat[0].length && !isVisit[row][col] && mat[row][col] == 1) {
                    isVisit[row][col] = true;
                    q.add(new QueuePoint(dist + 1, new Point(row, col)));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };
        int[] source = {0, 0};
        int[] destination = {0, 2};
        int pathCount = shortestPathBinaryMaze(mat, source, destination);
        System.out.println(pathCount);
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class QueuePoint {
    int dist;
    Point point;

    QueuePoint(int dist, Point point) {
        this.dist = dist;
        this.point = point;
    }
}
