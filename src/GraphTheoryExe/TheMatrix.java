package GraphTheoryExe;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {

    public static char[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = String.join("", scanner.nextLine().
                    split(" ")).toCharArray();
        }

        char fillChar = scanner.nextLine().charAt(0);

        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];

        dfs(startRow, startCol, matrix[startRow][startCol], fillChar);

        print();


    }

    private static void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void dfs(int row, int col, char symbol, char fillChar) {

        if (isOutOFBounds(row, col) || matrix[row][col] != symbol) {
            return;
        }

        matrix[row][col] = fillChar;

        if (!isOutOFBounds(row + 1, col)) {
            dfs(row + 1, col, symbol, fillChar);
        }
        if (!isOutOFBounds(row - 1, col)) {
            dfs(row - 1, col, symbol, fillChar);
        }
        if (!isOutOFBounds(row, col + 1)) {
            dfs(row, col + 1, symbol, fillChar);
        }
        if (!isOutOFBounds(row, col - 1)) {
            dfs(row, col - 1, symbol, fillChar);
        }

    }

    private static boolean isOutOFBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
