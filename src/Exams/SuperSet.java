package Exams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperSet {

    public static int[] elements;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        elements = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int k = elements.length;

        for (int i = 0; i <= k; i++) {
            int[] combinations = new int[i];
            combine(0, 0, combinations);
        }


    }

    private static void combine(int index, int start, int[] combinations) {

        if (index == combinations.length) {
            print(combinations);
            return;
        }

        for (int i = start; i < elements.length; i++) {
            combinations[index] = elements[i];
            combine(index + 1, i +1, combinations);

        }

    }

    private static void print(int[] combinations) {
        String result = Arrays.stream(combinations).mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
