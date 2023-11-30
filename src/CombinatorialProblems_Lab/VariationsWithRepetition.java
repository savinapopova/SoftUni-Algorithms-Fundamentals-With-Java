package CombinatorialProblems_Lab;

import java.util.Scanner;

public class VariationsWithRepetition {
    public static String[] elements;
    public static String[] variations;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split(" ");
        int k = Integer.parseInt(scanner.nextLine());
        variations = new String[k];



        variations(0);
    }

    private static void variations(int index) {
        if (index == variations.length) {
            print();
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            variations[index] = elements[i];
            variations(index + 1);

        }
    }

    private static void print() {
        System.out.println(String.join(" ", variations));
    }
}
