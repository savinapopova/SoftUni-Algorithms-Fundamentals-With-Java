package DP_Exe;

import java.util.Scanner;

public class MinimumEditDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int replace = Integer.parseInt(scanner.nextLine());
        int insert = Integer.parseInt(scanner.nextLine());
        int delete = Integer.parseInt(scanner.nextLine());

        char[] toModify = scanner.nextLine().toCharArray();
        char[] example = scanner.nextLine().toCharArray();

        int[][] dp = new int[toModify.length + 1][example.length + 1];

        for (int i = 1; i <= example.length; i++) {
            dp[0][i] = dp[0][i - 1] + insert;
        }

        for (int i = 1; i <= toModify.length; i++) {
            dp[i][0] = dp[i - 1][0] + delete;
        }

        for (int i = 1; i <= toModify.length; i++) {
            for (int j = 1; j <= example.length; j++) {
                if (toModify[i - 1] == example[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int toInsert = dp[i][j - 1] + insert;
                    int toReplace = dp[i - 1][j - 1] + replace;
                    int toDelete = dp[i - 1][j] + delete;
                    dp[i][j] = Math.min(toInsert, Math.min(toReplace, toDelete));
                }
            }

        }

        int result = dp[toModify.length][example.length];

        System.out.printf("Minimum edit distance: %d", result);




        for (int i = 0; i < example.length; i++) {
            for (int j = 0; j < toModify.length; j++) {

            }
        }
    }


}
