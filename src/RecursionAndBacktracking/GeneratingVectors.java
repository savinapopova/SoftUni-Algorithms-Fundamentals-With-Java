package RecursionAndBacktracking;

import java.util.Scanner;



public class GeneratingVectors {

   public static Integer[] vector;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        vector = new Integer[n];

        createVector(0);
    }

    private static void createVector(int index) {
        if (index >= vector.length) {
            print();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            vector[index] = i;
            createVector(index + 1);

        }
    }

    public static void print() {

        for (Integer integer : vector) {
            System.out.print(integer);
        }
        System.out.println();
    }
}
