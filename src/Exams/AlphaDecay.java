package Exams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AlphaDecay {

    public static int[] nucleus;
    public static boolean[] used;
    public static int[] variations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        nucleus = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(scanner.nextLine());
        used = new boolean[nucleus.length];
        variations = new int[k];

        getVariations(0);


    }

    private static void getVariations(int index) {
        if (index == variations.length) {
            print();
            return;
        }

        for (int i = 0; i < nucleus.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = nucleus[i];
                getVariations(index + 1);
                used[i] = false;
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.stream(variations)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
