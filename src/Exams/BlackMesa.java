package Exams;

import java.util.*;
import java.util.stream.Collectors;

public class BlackMesa {

    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= nodes; i++) {
            graph.add(new ArrayList<>());
        }

        while (edges-- > 0) {
            int[] pair = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (pair.length > 1) {
                graph.get(pair[0]).add(pair[1]);
            }
        }

        int start = Integer.parseInt(scanner.nextLine().trim());
        int target = Integer.parseInt(scanner.nextLine().trim());

        visited = new boolean[nodes + 1];
        prevNodes = new int[nodes + 1];

        Arrays.fill(prevNodes, -1);
        bfs(start, target);

        Deque<Integer> path = new ArrayDeque<>();
        path.push(target);
        int previous = prevNodes[target];

        while (previous != -1) {
            path.push(previous);
            previous = prevNodes[previous];
        }

        Set<Integer> notVisited = new TreeSet<>();

        for (int i = 1; i <= nodes; i++) {
            if (!path.contains(i)) {
                notVisited.add(i);
            }
        }

        while (!path.isEmpty()) {
            System.out.print(path.pop() + " ");
        }

        if (visited.length < nodes) {
            System.out.println();

            System.out.println(notVisited.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));


        }
    }

    private static void bfs(int start, int target) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            Integer node = queue.poll();

            if (node == target) {
                return;
            }

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }
}
