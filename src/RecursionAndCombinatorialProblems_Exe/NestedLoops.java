package RecursionAndCombinatorialProblems_Exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;



public class NestedLoops {
    public static int[] elements;
    public static int[] result;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        elements = new int[n];
        result = new int[n];

        for (int i = 0; i < n ; i++) {
            elements[i] = i +1;
        }

        permute(0);


    }

    private static void permute(int index) {
        if (index == elements.length) {
            print();
            return;
        }
        for (int i = 0; i < elements.length; i++) {


                result[index] = elements[i];
                permute(index + 1);

            }
        }



    private static void print() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(result)
                .forEach(n -> builder.append(n).append(" "));
        System.out.println(builder.toString());

    }
}
