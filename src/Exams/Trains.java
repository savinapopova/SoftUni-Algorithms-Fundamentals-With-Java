package Exams;

import java.util.Arrays;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arrivals = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] departures = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int count = 0;
        int maxCount = 0;

        for (int i = 0,j = 0; i < arrivals.length;) {

                if (arrivals[i] < departures[j]) {
                    count++;
                    if (maxCount < count) {
                        maxCount = count;
                    }
                    i++;
                } else {
                    count--;
                    j++;

            }
        }

        System.out.println(maxCount);


    }
}
