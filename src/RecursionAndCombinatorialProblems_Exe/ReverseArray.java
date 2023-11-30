package RecursionAndCombinatorialProblems_Exe;

import java.util.Scanner;

public class ReverseArray {

    public static String[] arr;
    public static String[] reversed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr = scanner.nextLine().split("\\s+");

        printReversed(0);
    }

    private static void printReversed(int index) {
        if (index == arr.length) {
            return;
        }

        printReversed(index + 1);
        System.out.print(arr[index] + " ");
    }
}
