package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class NuclearWaste {

    public static int[] prices;
    public static int[] dp;
    public static int[] prev;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        prices = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int flaskCount = Integer.parseInt(scanner.nextLine());

        dp = new int[flaskCount + 1];
        prev = new int[flaskCount + 1];

        for (int i = 1; i <= flaskCount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (j > prices.length) {
                    break;
                }
                int newValue = dp[i - j] + prices[j - 1];
                if (newValue < dp[i]) {
                    dp[i] = newValue;
                    prev[i] = j;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append("Cost: ").append(dp[flaskCount])
                .append(System.lineSeparator());

        while (flaskCount > 0) {
            builder.append(prev[flaskCount])
                    .append(" => ").append(prices[prev[flaskCount] - 1])
                    .append(System.lineSeparator());
            flaskCount -= prev[flaskCount];
        }

        System.out.println(builder.toString());

    }
}
