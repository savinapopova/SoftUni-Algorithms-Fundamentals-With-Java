package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class MonkeyBusiness {

    public static int[] elements;
    public static int[] combinations;
    public static StringBuilder builder = new StringBuilder();
    public static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i + 1;
        }
        combinations = new int[n];

        combine(0);
        builder.append("Total Solutions: ")
                .append(count);
        System.out.println(builder.toString());



    }

    private static void combine(int index) {
        if (index >= combinations.length) {
            print();
            return;
        }

        combinations[index] = elements[index];
        combine(index + 1);
        combinations[index] = -elements[index];
        combine(index + 1);
    }

    private static void print() {
        if (Arrays.stream(combinations).sum() == 0) {
            count++;

            for (int num : combinations) {
                String numAsStr = num > 0 ? "+" + num
                        : "" + num;
                builder.append(numAsStr).append(" ");
            }
            builder.append(System.lineSeparator());
        }

    }
}
