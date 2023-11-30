package DP_Exe;

import java.util.Scanner;

public class BinomialCoefficients {

    public static long[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        dp = new long[n + 1][k + 1];

        long result = calcResult(n, k);
        System.out.println(result);


    }

    private static long calcResult(int n, int k) {
        if (k == 0) {
            return 1;
        }

        if (k == n) {
            return 1;
        }

        if (dp[n][k] != 0) {
            return dp[n][k];
        }

        return dp[n][k] = calcResult(n - 1, k - 1) + calcResult(n - 1, k);
    }
}
