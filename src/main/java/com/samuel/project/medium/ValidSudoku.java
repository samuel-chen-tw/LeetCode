package com.samuel.project.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        // 1. check the row > board[i][j] + " Row " + i
        // 2. check the column > board[i][j] + " Column " + j
        // 3. check the square > board[i][j] + " Square " + i/3 + " " + j/3
        // 4. add to the HashSet
        HashSet checkSet = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    if (!checkSet.add(num + " Row " + i) ||
                            !checkSet.add(num + " Column " + j) || !checkSet.add(num + " Square " + i / 3 + " "+ j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean theMostVotesSolution(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
}
