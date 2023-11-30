package RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveDrawing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        draw(number);
    }

    private static void draw(int number) {

        if (number == 0) {
            return;
        }

        for (int i = 0; i < number; i++) {
            System.out.print("*");
        }

        System.out.println();
        draw(number - 1);

        for (int i = 0; i < number; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
