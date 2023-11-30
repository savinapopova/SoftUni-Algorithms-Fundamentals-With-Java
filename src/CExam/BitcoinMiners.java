package CExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BitcoinMiners {
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int x = Integer.parseInt(reader.readLine());

        dp = new long[n + 1][x + 1];

        long result = getResult(n, x);
        System.out.println(result);


    }

    private static long getResult(int n, int x) {
        if (x == 0) {
            return 1;
        }

        if (x == n) {
            return 1;
        }

        if (dp[n][x] != 0) {
            return dp[n][x];
        }

        return dp[n][x] = getResult(n - 1, x - 1) + getResult(n - 1, x);
    }
}
