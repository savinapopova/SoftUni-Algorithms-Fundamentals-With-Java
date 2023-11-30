package Exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TBC {

    public static char[][] fieldHorizontal;
    public static char[][] fieldVertical;
    public static char[][] fieldDiagonal;
    public static int rows;
    public static int cols;
   public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        rows = Integer.parseInt(reader.readLine());
        cols = Integer.parseInt(reader.readLine());
        fieldHorizontal = new char[rows][cols];
        fieldDiagonal = new char[rows][cols];
        fieldVertical = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String current = reader.readLine();
            fieldHorizontal[i] = current.toCharArray();
            fieldVertical[i] = current.toCharArray();
            fieldDiagonal[i] = current.toCharArray();
        }
       count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < 1; col++) {
                if (fieldHorizontal[row][col] == 't') {
                    solveHorizontal(row, col);


                }
            }
        }

        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < cols; col++) {
                if (fieldVertical[row][col] == 't') {
                    solveVertical(row, col);


                }
            }
        }

        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < 1; col++) {
                if (fieldDiagonal[row][col] == 't') {
                    solveDiagonal(row, col);


                }
            }
        }

        System.out.println(count);
    }

    private static void solveDiagonal(int row, int col) {
        if (isOutOfBounds(row, col, fieldDiagonal) || fieldDiagonal[row][col] != 't') {

            return;
        }




        fieldDiagonal[row][col] = 'V';

        if (row == rows - 1 || col == cols - 1) {
            count++;
            if ((col - 1 >= 0 && fieldDiagonal[rows - 1][col - 1] == 'V'
                    && fieldDiagonal[0][col - 1] == 'V') ||
                    (row - 1 >= 0 && fieldDiagonal[row - 1][cols - 1] == 'V'
                            && fieldDiagonal[row - 1][0] == 'V')) {
                count--;
            }
        }
        solveDiagonal(row -1, col - 1);
        solveDiagonal(row -1, col + 1);
        solveDiagonal(row + 1, col - 1);
        solveDiagonal(row + 1, col + 1);
    }

    private static void solveVertical(int row, int col) {
        if (isOutOfBounds(row, col, fieldVertical) || fieldVertical[row][col] != 't') {

            return;
        }



        fieldVertical[row][col] = 'V';

        if (row == rows - 1) {
            count++;
            if (col - 1 >= 0 && fieldVertical[row][col - 1] == 'V'
                    && fieldVertical[0][col - 1] == 'V') {
                count--;
            }
        }
        solveVertical(row -1, col);
        solveVertical(row + 1, col);
        solveVertical(row, col + 1);
        solveVertical(row, col - 1);
    }

    private static void solveHorizontal(int row, int col) {
        if (isOutOfBounds(row, col, fieldHorizontal) || fieldHorizontal[row][col] != 't') {

            return;
        }


        fieldHorizontal[row][col] = 'V';
        if (col == cols - 1) {
            count++;
            if (row - 1 >= 0 && fieldHorizontal[row - 1][col] == 'V'
                    && fieldHorizontal[row - 1][0] == 'V') {
                count--;
            }
        }
        solveHorizontal(row, col - 1);
        solveHorizontal(row, col + 1);
        solveHorizontal(row + 1, col);
        solveHorizontal(row - 1, col);
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {

        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }
}
