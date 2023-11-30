package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class Guards {
    public static Map<Integer, List<Integer>> graph = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();
    public static Set<Integer> notReachable = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new ArrayList<>());

        }

        while (edges-- > 0) {
            int[] pair = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (pair.length > 1) {
                graph.get(pair[0]).add(pair[1]);
            }
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(startNode);

        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                notReachable.add(node);
            }
        }

        String result = notReachable.stream().map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);


    }

    private static void dfs(int node) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);



        for (Integer child : graph.get(node)) {
            dfs(child);
        }
    }
}
