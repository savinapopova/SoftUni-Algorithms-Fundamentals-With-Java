package Exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Paths {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        visited = new boolean[nodes];


        for (int i = 0; i < nodes - 1; i++) {
            String line = scanner.nextLine();
            if (line != null && !line.equals("")){
                List<Integer> children = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(children);
            } else {
                graph.add(new ArrayList<>());
            }

        }
        graph.add(new ArrayList<>());

        for (int i = 0; i < graph.size() - 1; i++) {
            if (!visited[i]) {
                path.add(i);
                findPaths(i);
                path.remove(path.size() - 1);
            }
        }






    }

    private static void findPaths(int node) {
        if (node == graph.size() - 1) {
            print();
            return;
        }
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int child : graph.get(node)) {
            path.add(child);
            findPaths(child);
            path.remove(path.size() -1);
        }

        visited[node] = false;






    }

    private static void print() {
        String result = path.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
