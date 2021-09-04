package com.sss.practice.amazon;

public class WordSearch {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row == board.length || col == board[0].length ||
                this.board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean flag = false;
        this.board[row][col] = '#';
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            flag = backtrack(row + rowOffset[i], col + colOffset[i], word, index + 1);
            if (flag) {
                break;
            }
        }
        this.board[row][col] = word.charAt(index);
        return flag;
    }

    public static void main(String[] args) {
        // Using DFS
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCF";
        System.out.println(new WordSearch().exist(board, word));
    }
}
