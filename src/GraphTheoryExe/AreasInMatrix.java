package GraphTheoryExe;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AreasInMatrix {

    public static char[][] matrix;
    public static boolean[][] visited;
    public static Map<Character, Integer> countMap = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (!visited[row][col]) {

                    countMap.putIfAbsent(matrix[row][col], 0);
                    countMap.put(matrix[row][col], countMap.get(matrix[row][col]) + 1);
                    dfs(row, col, matrix[row][col]);
                }
            }
        }

        System.out.print("Areas: ");
        int sum = countMap.values().stream()
                .mapToInt((i) -> (i))
                .sum();
        System.out.println(sum);

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("Letter '" + entry.getKey() + "' -> " + entry.getValue());

        }
    }

    private static void dfs(int row, int col, char currentChar) {
        if (isOutOfBounds(row, col) || visited[row][col] || matrix[row][col] != currentChar) {
            return;
        }
        visited[row][col] = true;

        if (!isOutOfBounds(row + 1, col) && !visited[row + 1][col] && matrix[row + 1][col] == currentChar) {
            dfs(row + 1, col, matrix[row + 1][col]);
        }
        if (!isOutOfBounds(row - 1, col) && !visited[row - 1][col] && matrix[row - 1][col] == currentChar) {
            dfs(row - 1, col, matrix[row - 1][col]);
        }
        if (!isOutOfBounds(row, col + 1) && !visited[row][col + 1] && matrix[row][col + 1] == currentChar) {
            dfs(row, col + 1, matrix[row][col + 1]);
        }
        if (!isOutOfBounds(row, col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == currentChar) {
            dfs(row, col - 1, matrix[row][col - 1]);
        }

    }

    private static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
