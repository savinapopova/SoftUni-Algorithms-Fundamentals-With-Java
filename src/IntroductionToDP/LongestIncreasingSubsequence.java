package IntroductionToDP;

import java.util.*;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] length = new int[numbers.length];
        int[] prev = new int[numbers.length];
        Arrays.fill(prev, -1);

        int maxLength = 0;
        int maxIndex = -1;


        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            int bestLength = 1;
            int bestIndex = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < current && length[j] + 1 >= bestLength) {
                    bestLength = length[j] + 1;
                    bestIndex = j;
                }
            }

            prev[i] = bestIndex;
            length[i] = bestLength;
            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }

        }
        List<Integer> sequence = new ArrayList<>();

        int index = maxIndex;

        while (index != -1) {
            sequence.add(numbers[index]);
            index = prev[index];
        }

         Collections.reverse(sequence);
        System.out.println(sequence.stream().map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
