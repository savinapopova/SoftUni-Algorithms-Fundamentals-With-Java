package DP_Exe;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] first = scanner.nextLine().toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        int[][] dp = new int[first.length + 1][second.length + 1];

        dp[0][0] = 0;

        for (int col = 1; col <= first.length; col++) {
            dp[0][col] = col;
        }

        for (int row = 1; row <= first.length; row++) {
            dp[row][0] = row;
        }

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] != second[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }

        }

        System.out.printf("Deletions and Insertions: %d", dp[first.length][second.length]);
    }
}
