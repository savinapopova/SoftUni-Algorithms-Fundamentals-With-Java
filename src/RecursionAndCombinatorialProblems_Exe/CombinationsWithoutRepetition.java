package RecursionAndCombinatorialProblems_Exe;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationsWithoutRepetition {
    public static int elements[];
    public static int combinations[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        elements = new int[n];
        combinations = new int[k];

        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }

        combinations(0,0);
    }

    private static void combinations(int index, int start) {
        if (index ==  combinations.length) {
            print();
            return;
        }

        for (int i = start; i < elements.length; i++) {
            combinations[index] = elements[i];
            combinations(index + 1, i + 1);
        }
    }

    private static void print() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(combinations).forEach(n -> builder.append(n).append(" "));
        System.out.println(builder.toString());
    }
}
