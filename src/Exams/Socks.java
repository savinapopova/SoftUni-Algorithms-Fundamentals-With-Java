package Exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String leftInput = scanner.nextLine();
        String rightInput = scanner.nextLine();

        int[] leftSocks = Arrays.stream(leftInput.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rightSocks = Arrays.stream(rightInput.split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = findLongestSequence(leftSocks, rightSocks);
        System.out.println(result);
    }

    private static int findLongestSequence(int[] leftSocks, int[] rightSocks) {
        int[][] dp = new int[leftSocks.length + 1][rightSocks.length + 1];
        int maxLength = 0;

        for (int i = 1; i <= leftSocks.length; i++) {
            for (int j = 1; j <= rightSocks.length; j++) {
                if (leftSocks[i - 1] == rightSocks[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return maxLength;
    }
}
