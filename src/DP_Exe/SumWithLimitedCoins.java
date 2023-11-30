package DP_Exe;

import java.util.*;

public class SumWithLimitedCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int targetSum = Integer.parseInt(scanner.nextLine());

        System.out.println(calcSum(coins, targetSum));
    }

    private static int calcSum(int[] coins, int targetSum) {

        Map<Integer, Integer> result = new HashMap<>();
        int answer = 0;

        result.put(0, 0);

        for (int coin : coins) {
            for (Integer integer : new ArrayList<>(result.keySet())) {
                int newSum = coin + integer;

                if (newSum == targetSum) {
                    answer++;
                }

                if (!result.containsKey(newSum)) {
                    result.put(newSum, integer);
                }
            }
        }

        return answer;
    }
}
