package IntroductionToDP;

import java.util.*;
import java.util.stream.Collectors;

public class MoveDownRight {

    public static class Step {

        private int row;

        private int col;

        public Step(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", this.row, this.col);
        }
    }

    public static int[][] matrix;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        matrix = new int[rows][cols];
        dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        dp[0][0] = matrix[0][0];

        for (int col = 1; col < cols; col++) {
            dp[0][col] = dp[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            dp[row][0] = dp[row - 1][0] +matrix[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = matrix[row][col] + Math.max(dp[row - 1][col], dp[row][col - 1]);
            }
          }

        int row = rows - 1;
        int col = cols - 1;
        List<Step> path = new ArrayList<>();
       Step step = new Step(row, col);
       path.add(step);

        while (row > 0 || col > 0) {

            int top = -1;

            if (row > 0) {
                top = dp[row - 1][col];
            }

            int left = -1;

            if (col > 0) {
                left = dp[row][col - 1];
            }

            if (top > left) {
                row--;
            } else {
                col--;
            }

            Step current = new Step(row, col);
            path.add(current);
        }
        Collections.reverse(path);
        String result = path.stream().map(Step::toString)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
