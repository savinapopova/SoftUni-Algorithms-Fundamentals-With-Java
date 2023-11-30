package IntroductionToDP;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {

    public static int[] prices;
    public static int[] bestPrice;
    public static int[] prevIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        prices = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int length = Integer.parseInt(scanner.nextLine());
        bestPrice = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxProfit = cutRope(length);
        System.out.println(maxProfit);

        getSolution(length);
    }

    private static void getSolution(int length) {
        while (length - prevIndex[length] != 0) {
            System.out.print(prevIndex[length] + " ");
            length = length - prevIndex[length];
        }
        System.out.println(prevIndex[length]);
    }

    private static int cutRope(int length) {

        if (length == 0) {
            return 0;
        }

        if (bestPrice[length] != 0) {
            return bestPrice[length];
        }

        int currentBest = bestPrice[length];

        for (int i = 1; i <= length; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRope(length - i));
            if (currentBest > bestPrice[length]) {
                bestPrice[length] = currentBest;
                prevIndex[length] = i;
            }
        }
        return bestPrice[length];
    }
}
