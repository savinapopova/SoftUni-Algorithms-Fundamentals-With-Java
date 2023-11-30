package Exams;

import java.util.Scanner;

public class TBCGPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        char[][] cityMap = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String row = scanner.nextLine();
            cityMap[i] = row.toCharArray();
        }

        int result = countConnectedTunnels(cityMap);
        System.out.println(result);
    }

    private static int countConnectedTunnels(char[][] cityMap) {
        int count = 0;
        int rows = cityMap.length;
        int columns = cityMap[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cityMap[i][j] == 't' && !visited[i][j]) {
                    dfs(cityMap, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] cityMap, boolean[][] visited, int row, int col) {
        int rows = cityMap.length;
        int columns = cityMap[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= columns || visited[row][col] || cityMap[row][col] == 'd') {
            return;
        }

        visited[row][col] = true;

        // Explore all neighboring cells (horizontally, vertically, and diagonally)
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                dfs(cityMap, visited, newRow, newCol);
            }
        }
    }
}
