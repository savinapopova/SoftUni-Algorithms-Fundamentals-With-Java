package Exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class PathFinder {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < nodes; i++) {
            String line = scanner.nextLine();

            if (line != null && !line.trim().equals("")) {
                graph.add(Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));
            } else {
                graph.add(new ArrayList<>());
            }
        }

        int pathsCount = Integer.parseInt(scanner.nextLine());

        while (pathsCount-- > 0) {
            int[] path = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();




                try {

                    findPath(0, path);
                    System.out.println("yes");
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());

                }

        }


    }

    private static void findPath(int index, int[] path) {
        if (index == path.length - 1) {
            return;
        }

        int node = path[index];
        int next = path[index + 1];

        if (graph.get(node).isEmpty() || !graph.get(node).contains(next)) {
            throw new IllegalStateException("no");
        } else {

            findPath(index + 1, path);
        }
    }
}
