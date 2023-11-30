package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class TheTyrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = getMinSum(numbers, numbers.length);
        System.out.println(result);



    }

    private static int getMinSum(int[] numbers, int n) {
        int[] dp = new int[n];

        if (n == 1) {
            return numbers[0];
        }
        if (n == 2) {
            return Math.min(numbers[0], numbers[1]);
        }
        if (n == 3) {
            return Math.min(Math.min(numbers[0], numbers[1]), numbers[2]);
        }
        if (n == 4) {
            return Math.min(Math.min(numbers[0], numbers[1]),Math.min(numbers[2], numbers[3]));
        }

        dp[0] = numbers[0];
        dp[1] = numbers[1];
        dp[2] = numbers[2];
        dp[3] = numbers[3];

        for (int i = 4; i < numbers.length; i++) {
            dp[i] = numbers[i] + Math.min(Math.min(dp[i - 1], dp[i - 2]),Math.min(dp[i - 3], dp[i - 4]));
        }
        return Math.min(Math.min(dp[n - 1], dp[n - 2]),Math.min(dp[n - 3], dp[n - 4]));
    }
}
