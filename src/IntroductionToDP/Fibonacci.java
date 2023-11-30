package IntroductionToDP;

import java.util.Scanner;

public class Fibonacci {
    public static long[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        long result = fib(n);
        System.out.println(result);

    }

    private static long fib(int n) {

        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = fib(n - 1) + fib(n - 2);
    }
}
