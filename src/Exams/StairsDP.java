package Exams;

import java.util.Scanner;

public class StairsDP {

    public static long[] result;
    public static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        result = new long[n + 2];

       long count = getResult(n);
        result[0] = 1;
        result[1] = 1;
        System.out.println(count);

    }

    private static long getResult(int index) {

        if (index < 2) {
            return 1;
        }


        if (result[index] != 0) {
            return result[index];
        }

         return result[index] = getResult(index - 1) + getResult(index - 2);
    }
}
