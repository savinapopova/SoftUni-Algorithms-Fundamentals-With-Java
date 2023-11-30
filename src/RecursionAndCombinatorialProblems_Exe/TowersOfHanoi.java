package RecursionAndCombinatorialProblems_Exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class TowersOfHanoi {

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static StringBuilder builder = new StringBuilder();
    public static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int disks = Integer.parseInt(reader.readLine());

        for (int i = disks; i >= 1; i--) {
            source.push(i);
        }



        print();

        solve(disks,source, destination, spare);
        System.out.println(builder.toString());
    }

    private static void solve(int disks, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disks == 1) {
            destination.push(source.pop());
            builder.append(System.lineSeparator())
                    .append("Step #").append(steps++)
                    .append(": Moved disk").append(System.lineSeparator());
            print();
            return;
        }
        solve(disks - 1, source, spare, destination);
        solve(1, source, destination, spare);
        solve(disks - 1, spare, destination, source);
    }

    private static void print() {
        builder.append(String.format("Source: %s%n",source.stream().sorted(Comparator.reverseOrder())
                .map(String::valueOf).collect(Collectors.joining(", "))))
                .append(String.format("Destination: %s%n",destination.stream().sorted(Comparator.reverseOrder())
                .map(String::valueOf).collect(Collectors.joining(", "))))
                .append(String.format("Spare: %s%n",spare.stream().sorted(Comparator.reverseOrder())
                        .map(String::valueOf).collect(Collectors.joining(", "))));

    }
}
