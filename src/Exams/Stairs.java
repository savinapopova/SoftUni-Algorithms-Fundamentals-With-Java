package Exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stairs {
    public static List<Integer> steps = new ArrayList<>();
    public static int stairs;
    public static int stairsLeft;
    public static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        stairs = Integer.parseInt(reader.readLine());
        stairsLeft = stairs;
        count = 0;

        getVariations(0);

         System.out.println(count);

    }

    private static void getVariations(int n) {

        if (n == stairs) {
            count++;
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (n + i <= stairs) {
                steps.add(i);
                stairsLeft = stairsLeft - i;
                getVariations(n + i);
                steps.remove(steps.size() - 1);

                stairsLeft = stairsLeft + i;
            }

        }
    }


}
