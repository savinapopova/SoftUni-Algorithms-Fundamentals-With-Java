package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueensPuzzle {
   public static char[][] board = {
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'},
           {'-','-','-','-','-','-','-','-'}
   };




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        findPositions(0);











}

    private static void findPositions(int row) {
        if (row == 8) {
            printSolution();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (canPlaceQueen(row, col)) {
                placeQueen(row, col);
                findPositions(row + 1);
                removeQueen(row,  col);
            }
        }
    }

    private static boolean canPlaceQueen(int row, int col) {
        int r = row, c = col;

        while (r >= 0) {

            if (board[r--][c] == '*') {
                return false;
            }

        }

        r = row;
        c = col;
        while (r >= 0 && c >= 0 ){

            if (board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r>= 0 && c< 8 ){

            if (board[r--][c++] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static void placeQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static void printSolution() {

        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
