package Exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrainsCopy {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] arrivals = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        double[] departures = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int countPlatforms = 0;
        int maxPlatforms = 0;
        int i = 0;
        int j = 0;

        while (i < arrivals.length) {

            if (arrivals[i] < departures[j]) {
                countPlatforms++;
                i++;
                maxPlatforms = Math.max(maxPlatforms, countPlatforms);
            } else {
                countPlatforms--;
                j++;
            }
        }
        System.out.println(maxPlatforms);

    }
}
