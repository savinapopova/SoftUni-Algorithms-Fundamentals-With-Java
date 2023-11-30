package SearchingSortingGreedy_Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(reader.readLine());

        int index = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (num < arr[mid]) {
                end = mid - 1;

            } else if (num > arr[mid]) {
                start = mid + 1;

            } else {
                index = mid;
                break;
            }
        }

        System.out.println(index);
    }
}
