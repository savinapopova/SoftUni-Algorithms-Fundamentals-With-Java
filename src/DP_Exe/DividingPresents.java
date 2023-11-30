package DP_Exe;

import java.util.*;
import java.util.stream.Collectors;

public class DividingPresents {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] gifts = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(gifts);

        int totalSum = Arrays.stream(gifts).sum();


        List<Integer> alanGifts = new ArrayList<>();
        List<Integer> bobGifts = new ArrayList<>();

        int alanSum = 0;
        int bobSum = 0;

        for (int i = gifts.length - 1; i >= 0; i--) {
            alanSum = alanGifts.stream()
                    .mapToInt((m) -> (m))
                    .sum();

            bobSum = bobGifts.stream()
                    .mapToInt((m) -> (m))
                    .sum();
            int current = gifts[i];
            if (alanSum > bobSum) {
                bobGifts.add(current);
            } else {
                alanGifts.add(current);
            }
        }
        alanSum = alanGifts.stream()
                .mapToInt((m) -> (m))
                .sum();

        bobSum = bobGifts.stream()
                .mapToInt((m) -> (m))
                .sum();

        System.out.printf("Difference: %d%n", Math.abs(bobSum - alanSum));

        System.out.printf("Alan:%d Bob:%d%n", alanSum, bobSum);

        System.out.printf("Alan takes: %s%n", alanGifts.stream()
                .map(String::valueOf).collect(Collectors.joining(" ")));

        System.out.println("Bob takes the rest.");
    }
}
