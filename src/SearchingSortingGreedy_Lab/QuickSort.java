package SearchingSortingGreedy_Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class QuickSort {

    public static int[] arr;
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        quickSort(0, arr.length - 1);

        String out = Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

    System.out.println(out);
    }

    private static void quickSort(int left, int right) {

    if (left >= right) {
        return;
    }

    int index = partition(left, right);

    quickSort(left, index - 1);
    quickSort(index + 1, right);



    }

    private static int partition(int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, right);
        return i + 1;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
