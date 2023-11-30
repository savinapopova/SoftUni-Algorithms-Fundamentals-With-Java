package DP_Exe;

import java.util.Arrays;
import java.util.Scanner;

public class DividingPresents2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] gifts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int totalSum = Arrays.stream(gifts).sum();

        int[] sums = new int[totalSum + 1];

        Arrays.fill(sums, -1);
        sums[0] = 0;

        for (int i = 0; i < gifts.length; i++) {
            int current = gifts[i];
            for (int j = totalSum - current; j >= 0; j--) {

                if (sums[j] != -1 && sums[j + current] == -1) {
                    sums[j + current] = i;
                }
            }
        }

        int half = totalSum / 2;

        for (int i = half; i >= 0; i--) {
            if (sums[i] == -1) {
                continue;
            }

            System.out.printf("Difference: %d%n", totalSum - i - i);
            System.out.printf("Alan:%d Bob:%d%n", i, totalSum - i);
            System.out.print("Alan takes:");

            while (i != 0) {
                System.out.printf(" %d", gifts[sums[i]]);
                i -= gifts[sums[i]];
            }

            System.out.println();
            System.out.println("Bob takes the rest.");
        }

    }
}
