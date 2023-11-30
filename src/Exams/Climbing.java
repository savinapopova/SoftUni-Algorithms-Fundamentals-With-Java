package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class Climbing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if (rows == 1 && cols == 1) {
            System.out.println(matrix[0][0]);
            System.out.println(matrix[0][0]);
            return;
        }

        int[][] dp = new int[rows][cols];
        dp[rows - 1][cols - 1] = matrix[rows - 1][cols - 1];

        for (int row = rows - 2; row >= 0; row--) {
            dp[row][cols - 1] = dp[row + 1][cols -1] + matrix[row][cols - 1];
        }

        for (int col = cols - 2; col >= 0; col--) {
            dp[rows - 1][col] = dp[rows - 1][col + 1] + matrix[rows - 1][col];
        }

        List<Integer> path = new ArrayList<>();


        for (int row = rows -2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                int max = Math.max(dp[row + 1][col], dp[row][col + 1]);
                dp[row][col] = max + matrix[row][col];
            }
        }

        System.out.println(dp[0][0]);

        path.add(matrix[0][0]);
        int row = 0;
        int col = 0;

        while (true) {

            if (row == rows - 1) {
                col++;

            } else if (col == cols - 1) {
                row++;

            } else if (dp[row + 1][col] >= dp[row][col + 1]) {
                row++;
            } else if (dp[row][col + 1] > dp[row + 1][col]) {
                col++;
            }

            path.add(matrix[row][col]);

            if (row == rows -1 && col == cols - 1) {
                break;
            }
        }
        Collections.reverse(path);

        String result = path.stream()
                .map(String::valueOf)
                                .collect(Collectors.joining(" "));

        System.out.println(result);


    }
}
