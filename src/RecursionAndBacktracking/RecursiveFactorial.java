package RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        long fact = getFactorial(number);
        System.out.println(fact);
    }

    private static long getFactorial(int number) {

        if (number == 0) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }
}
